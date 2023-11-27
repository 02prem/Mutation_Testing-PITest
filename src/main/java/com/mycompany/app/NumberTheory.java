package com.mycompany.app;

import java.util.*;

public class NumberTheory {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        int choice, precision, base;
        int l1_size, l2_size, exp1, exp2;

        AbstractMap.SimpleEntry<List<Integer>, Integer> ans;
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        System.out.println("Take input of first list");
        l1_size = scanner.nextInt();
        for(int i = 0; i < l1_size; i++){
            int x = scanner.nextInt();
            l1.add(x);
        }

        System.out.print("exp1: ");
        exp1 = scanner.nextInt();
        System.out.println();

        System.out.println("Take input of second list");
        l2_size = scanner.nextInt();
        for(int i = 0; i < l2_size; i++){
            int y = scanner.nextInt();
            l2.add(y);
        }
        System.out.print("exp2: ");
        exp2 = scanner.nextInt();
        System.out.println();

        System.out.print("Base: ");
        base = scanner.nextInt();
        System.out.println();

        System.out.println("Choose on of the below operations");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");

        choice = scanner.nextInt();

        AbstractMap.SimpleEntry<List<Integer>, Integer> num1 = new AbstractMap.SimpleEntry<>(l1, exp1);
        AbstractMap.SimpleEntry<List<Integer>, Integer> num2 = new AbstractMap.SimpleEntry<>(l2, exp2);

        switch (choice) {
            case 1:
                ans = addReal(num1, num2, base);
                for (int i : ans.getKey()) 
                {
                    System.out.print(i);
                }
                System.out.println();
                System.out.println(ans.getValue());
                break;
        
            case 2:
                ans = subtractReal(num1, num2, base);
                for (int i : ans.getKey()) 
                {
                    System.out.print(i);
                }
                System.out.println();
                System.out.println(ans.getValue());
                break;

            case 3:
                ans = multiplyReal(num1, num2, base);
                for (int i : ans.getKey()) 
                {
                    System.out.print(i);
                }
                System.out.println();
                System.out.println(ans.getValue());
                break;

            case 4:
                System.out.print("Precision: ");
                precision = scanner.nextInt();
                System.out.println();
                ans = divideReal(num1, num2, precision, base);
                System.out.print("Quotient: ");
                for (int i : ans.getKey()) 
                {
                    System.out.print(i);
                }
                System.out.println(" x " + base + "^" + ans.getValue());
                break;

            default:
                break;
        }

        scanner.close();
    }

// ******************************** ADDITION ***************************************************** //
    public static List<Integer> add(List<Integer> num1, List<Integer> num2, int base) 
    {
        List<Integer> ans = new ArrayList<>();
        int len1 = num1.size();
        int len2 = num2.size();
        int temp, carry = 0;

        if (len1 == 0) 
        {
            return new ArrayList<>(num2);
        } 

        else if (len2 == 0) 
        {
            return new ArrayList<>(num1);
        }

        List<Integer> n1 = new ArrayList<>(num1);
        List<Integer> n2 = new ArrayList<>(num2);

        while (len1 != len2) 
        {
            if (len1 < len2) 
            {
                n1.add(0, 0);
                len1++;
            } 

            else 
            {
                n2.add(0, 0);
                len2++;
            }
        }

        Collections.reverse(n1);
        Collections.reverse(n2);

        for (int i = 0; i < len2; i++) 
        {
            temp = n1.get(i) + n2.get(i) + carry;
            ans.add(temp % base);
            carry = temp / base;
        }

        for (int i = len2; i < len1; i++) 
        {
            temp = n1.get(i) + carry;
            ans.add(temp % base);
            carry = temp / base;
        }

        if (carry != 0) 
        {
            ans.add(carry);
        }

        Collections.reverse(ans);
        return ans;
    }

// ************************************* SUBTRACTION ************************************************** //
    public static List<Integer> subtract(List<Integer> num1, List<Integer> num2, int base) 
    {
        List<Integer> ans = new ArrayList<>();
        int len1 = num1.size();
        int len2 = num2.size();
        int temp, carry = 0;

        if (len1 == 0) 
        {
            num2.set(0, -1 * num2.get(0));
            return new ArrayList<>(num2);
        } 
        else if (len2 == 0) 
        {
            return new ArrayList<>(num1);
        }

        // Finding the greater number
        int grt = 0;
        int sml = 0;
        if (len1 > len2) 
        {
            grt = 1;
            sml = 2;
        } 

        else if (len2 > len1) 
        {
            grt = 2;
            sml = 1;
        } 
        
        else 
        {
            boolean flag = false;
            for (int i = 0; i < len1; i++) 
            {
                if (num1.get(i) > num2.get(i)) 
                {
                    grt = 1;
                    sml = 2;
                    flag = true;
                    break;
                } 

                else if (num2.get(i) > num1.get(i)) 
                {
                    grt = 2;
                    sml = 1;
                    flag = true;
                    break;
                }
            }

            if (!flag) 
            {
                List<Integer> zeroList = new ArrayList<>();
                zeroList.add(0);
                return zeroList;
            }
        }

        // Padding zeroes in the beginning to equate the lengths
        while (len1 != len2) 
        {
            if (len1 < len2) 
            {
                num1.add(0, 0);
                len1++;
            } 
            
            else 
            {
                num2.add(0, 0);
                len2++;
            }
        }

        Collections.reverse(num1);
        Collections.reverse(num2);

        if (grt == 1) 
        {
            for (int i = 0; i < len2; i++) 
            {
                temp = num1.get(i) - num2.get(i) + carry;
                if (temp < 0 && i != len1 - 1)
                {
                    temp = temp + base;
                    carry = -1;
                } 
                
                else 
                {
                    carry = 0;
                }
                ans.add(temp % base);
                carry = carry + temp / base;
            }

            for (int i = len2; i < len1; i++) 
            {
                temp = num1.get(i) + carry;
                if (temp < 0) 
                {
                    temp = temp + base;
                    carry = -1;
                } 
                
                else 
                {
                    carry = 0;
                }
                ans.add(temp % base);
                carry = carry + temp / base;
            }

            if (carry != 0)
                ans.add(carry);

            Collections.reverse(ans);
            while (true) 
            {
                if (ans.get(0) != 0 || ans.size() == 1) 
                {
                    break;
                } 
                
                else 
                {
                    ans.remove(0);
                }
            }
        } 
        
        else if (grt == 2) 
        {
            for (int i = 0; i < len1; i++) 
            {
                temp = num2.get(i) - num1.get(i) + carry;
                if (temp < 0 && i != len2 - 1) 
                {
                    temp = temp + base;
                    carry = -1;
                } 
                else 
                {
                    carry = 0;
                }
                ans.add(temp % base);
                carry = carry + temp / base;
            }

            for (int i = len1; i < len2; i++) 
            {
                temp = num2.get(i) + carry;
                if (temp < 0) 
                {
                    temp = temp + base;
                    carry = -1;
                } 

                else 
                {
                    carry = 0;
                }
                ans.add(temp % base);
                carry = carry + temp / base;
            }

            if (carry != 0)
                ans.add(carry);

            Collections.reverse(ans);
            while (true) 
            {
                if (ans.get(0) != 0) 
                {
                    break;
                } 
                else 
                {
                    ans.remove(0);
                }
            }
            ans.set(0, -1 * ans.get(0));
        }
        return ans;
    }

// ************************************************ MULTIPLICATION ********************************* //
    public static int max(int a, int b) 
    {
        return (a > b) ? a : b;
    }

    public static void normalize(List<Integer> num, int shift) 
    {
        for (int i = 0; i < shift; i++) 
        {
            num.add(0);
        }
    }

    public static List<Integer> multiply(List<Integer> num1, List<Integer> num2, int base) 
    {
        int len1 = num1.size();
        int len2 = num2.size();
        List<Integer> c = new ArrayList<>();
        int carry, tmp;

        Collections.reverse(num1);
        Collections.reverse(num2);

        for (int i = 0; i <= len1 + len2 - 1; i++) 
        {
            c.add(0);
        }

        for (int i = 0; i < len1; i++) 
        {
            carry = 0;
            for (int j = 0; j < len2; j++) 
            {
                tmp = num1.get(i) * num2.get(j) + c.get(i + j) + carry;
                carry = tmp / base;
                c.set(i + j, tmp % base);
            }
            c.set(i + len2, carry);
        }

        Collections.reverse(c);
        return c;
    }

// ******************************************** DIVISION **************************************************** //
    public static void truncate(List<Integer> num) 
    {
        while (num.get(0) == 0 && num.size() > 1) 
        {
            num.remove(0);
        }
    }

    public static AbstractMap.SimpleEntry<List<Integer>, List<Integer>> divide(List<Integer> num1, List<Integer> num2, int base) 
    {
        List<Integer> remainder = new ArrayList<>();
        List<Integer> quotient = new ArrayList<>();
        int k = num1.size(), l = num2.size();
        int NOfNormalize = 0, count = 0;
        int tmp, carry;
        boolean flag = false;

        if (k > l) 
        {
            flag = true;
        }

        else if (l > k) 
        {
            quotient.add(0);
            for (int i = 0; i < k; i++) 
            {
                remainder.add(num1.get(i));
            }
            return new AbstractMap.SimpleEntry<>(quotient, remainder);
        } 
        
        else 
        {
            for (int i = 0; i < k; i++) 
            {
                if (num1.get(i) > num2.get(i)) 
                {
                    flag = true;
                    break;
                } 
                else if (num2.get(i) > num1.get(i)) 
                {
                    quotient.add(0);
                    for (int j = 0; j < k; j++) 
                    {
                        remainder.add(num1.get(j));
                    }
                    return new AbstractMap.SimpleEntry<>(quotient, remainder);
                }
            }

            if (!flag) 
            {
                quotient.add(1);
                remainder.add(0);
                return new AbstractMap.SimpleEntry<>(quotient, remainder);
            }
        }

        k = num1.size();
        l = num2.size();

        Collections.reverse(num1);
        Collections.reverse(num2);

        for (int i = 0; i <= k - 1; i++) 
        {
            remainder.add(num1.get(i));
        }
        remainder.add(0);

        for (int i = 0; i <= k - l; i++) 
        {
            quotient.add(0);
        }

        for (int i = k - l; i >= 0; i--) 
        {
            if(num2.get(l - 1) != 0)
            {
                quotient.set(i, (remainder.get(i + l) * base + remainder.get(i + l - 1)) / num2.get(l - 1));
            }
            // else
            // {
            //     quotient.set(i, 0);
            // }
            // quotient.set(i, (remainder.get(i + l) * base + remainder.get(i + l - 1)) / num2.get(l - 1));
            if (quotient.get(i) >= base) {
                quotient.set(i, base - 1);
            }
            carry = 0;
            count = 0;

            for (int j = 0; j <= l - 1; j++) 
            {
                tmp = remainder.get(i + j) - quotient.get(i) * num2.get(j) + carry;
                carry = tmp / base;
                remainder.set(i + j, tmp % base);
                if (remainder.get(i + j) < 0) 
                {
                    remainder.set(i + j, remainder.get(i + j) + base);
                    carry--;
                }
            }
            remainder.set(i + l, remainder.get(i + l) + carry);

            while (remainder.get(i + l) < 0) 
            {
                carry = 0;
                for (int j = 0; j <= l - 1; j++) 
                {
                    tmp = remainder.get(i + j) + num2.get(j) + carry;
                    carry = tmp / base;
                    remainder.set(i + j, tmp % base);
                    if (remainder.get(i + j) < 0) 
                    {
                        remainder.set(i + j, remainder.get(i + j) + base);
                        carry--;
                    }
                }

                remainder.set(i + l, remainder.get(i + l) + carry);
                quotient.set(i, quotient.get(i) - 1);
            }
        }

        Collections.reverse(quotient);
        Collections.reverse(remainder);

        for (int i = 0; i < quotient.size(); i++) 
        {
            if (quotient.get(i) != 0) 
            {
                truncate(quotient);
            }
        }

        if (quotient.size() == 0) 
        {
            quotient.add(0);
        }

        return new AbstractMap.SimpleEntry<>(quotient, remainder);
    }

// ******************************************************** REAL NUMBERS ************************************************ //
    //Normalize function for multiplication
    public static void normalizeMul(List<Integer> num, int shift) 
    {
        for (int i = 0; i < shift; i++) 
        {
            num.add(0);
        }
    }

    //Padding zeroes in the end. Exponents are negative.
    public static void normalize(List<Integer> num1, List<Integer> num2, int exp1, int exp2) 
    {
        if (exp1 == exp2) 
        {
            return;
        } 
        
        else if (exp1 > exp2) 
        {
            for (int i = 0; i < exp1 - exp2; i++) 
            {
                num1.add(0);
            }
        } 
        
        else 
        {
            for (int i = 0; i < exp2 - exp1; i++) 
            {
                num2.add(0);
            }
        }
    }


    public static AbstractMap.SimpleEntry<List<Integer>, Integer> precise(AbstractMap.SimpleEntry<List<Integer>, Integer> num1, int p) 
    {
        List<Integer> num1List = new ArrayList<>(num1.getKey());
        for (int i = 0; i < p; i++) 
        {
            num1List.add(0);
        }
        
        return new AbstractMap.SimpleEntry<>(num1List, num1.getValue());
    }

    //To remove the extras digits if it exceeds the precision.
    public static void removeBack(AbstractMap.SimpleEntry<List<Integer>, Integer> num, int precision) 
    {
        while (num.getValue() != (-1) * precision) 
        {
            num.getKey().remove(num.getKey().size() - 1);
            num.setValue(num.getValue() + 1);
        }
    }

    //Operations on real numbers

    //Addition for floating point numbers
    public static AbstractMap.SimpleEntry<List<Integer>, Integer> addReal(AbstractMap.SimpleEntry<List<Integer>, Integer> num1,
                                                                         AbstractMap.SimpleEntry<List<Integer>, Integer> num2, int base) 
    {
        normalize(num1.getKey(), num2.getKey(), num1.getValue(), num2.getValue());
        int precision = Math.min(num1.getValue(), num2.getValue());
        List<Integer> sum = add(num1.getKey(), num2.getKey(), base);
        return new AbstractMap.SimpleEntry<>(sum, precision);
    }

    //Subtraction for floating point numbers
    public static AbstractMap.SimpleEntry<List<Integer>, Integer> subtractReal(AbstractMap.SimpleEntry<List<Integer>, Integer> num1,
                                                                              AbstractMap.SimpleEntry<List<Integer>, Integer> num2, int base) 
    {
        normalize(num1.getKey(), num2.getKey(), num1.getValue(), num2.getValue());
        int precision = Math.min(num1.getValue(), num2.getValue());
        List<Integer> difference = subtract(num1.getKey(), num2.getKey(), base);
        return new AbstractMap.SimpleEntry<>(difference, precision);
    }

    //Multplication for floating point numbers
    public static AbstractMap.SimpleEntry<List<Integer>, Integer> multiplyReal(AbstractMap.SimpleEntry<List<Integer>, Integer> num1,
                                                                              AbstractMap.SimpleEntry<List<Integer>, Integer> num2, int base)
    {
        List<Integer> product = multiply(num1.getKey(), num2.getKey(), base);
        int precision = num1.getValue() + num2.getValue();
        return new AbstractMap.SimpleEntry<>(product, precision);
    }

    //Division for floating point numbers
    //Only quotient will have an exponent, remainder does not have an exponent.
    public static AbstractMap.SimpleEntry<List<Integer>, Integer> divideReal(AbstractMap.SimpleEntry<List<Integer>, Integer> num1,
                                                                            AbstractMap.SimpleEntry<List<Integer>, Integer> num2,
                                                                            int precision, int base) 
    {
        int l = precision - num2.getValue();
        num1 = precise(num1, l);
        AbstractMap.SimpleEntry<List<Integer>, List<Integer>> ansDiv = divide(num1.getKey(), num2.getKey(), base);
        AbstractMap.SimpleEntry<List<Integer>, Integer> ans = new AbstractMap.SimpleEntry<>(ansDiv.getKey(), (-1) * (precision - num1.getValue()));
        removeBack(ans, precision);
        return ans;
    }

}
