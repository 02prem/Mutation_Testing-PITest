package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static Boolean evein(int a)
    {
        return mod(a,2) == 0;
    }

    public static int mod(int a , int b)
    {
        return a % b;
    }
}
