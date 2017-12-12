package com.epam.homework.august25;

import java.util.Scanner;

public class Calculator
{
    public static void main(String[] args)
    {
        System.out.println( " Привет, я калькулятор. Что будем делать?" );
        System.out.println( "1 - сложение");
        System.out.println( "2 - вычитание");
        System.out.println( "3 - умножение");
        System.out.println( "4 - деление");
        System.out.println( "5 - выход");

        //create an object that reads integers:
        Scanner cin = new Scanner(System.in);

        // read operation code (+, -, *, /, quit)
        byte operation = 0;
        do
        {
            System.out.print( " Please enter a number [1..5]: " );
            try {
                operation = cin.nextByte();
            }
            catch( java.util.InputMismatchException ex ) {
                System.out.print( "Wrong parameter. ");
            }
            cin.nextLine();
        } while( operation < 1 || operation > 5 );

        // read first argument
        long value1 = 0;
        boolean paramInited = false;
        do
        {
            System.out.print( " Please enter argument №1: " );
            try {
                value1 = cin.nextLong();
                paramInited = true;
            }
            catch( java.util.InputMismatchException ex ) {
                System.out.print( "Wrong parameter. ");
            }
            cin.nextLine();
        } while( !paramInited );

        // read second argument
        long value2 = 0;
        paramInited = false;
        do
        {
            System.out.print( " Please enter argument №2: " );
            try {
                value2 = cin.nextLong();
                if( operation != 4 || value2 != 0 )
                    paramInited = true;
                else
                    System.out.print( "You can't devide by zero. Try another value.");
            }
            catch( java.util.InputMismatchException ex ) {
                System.out.print( "Wrong parameter. ");
            }
            cin.nextLine();
        } while( !paramInited );


        long result = -1;
        switch( operation ) {
            case 1 : {
                result = value1 + value2;
                break;
            }

            case 2 : {
                result = value1 - value2;
                break;
            }

            case 3 : {
                result = value1 * value2;
                break;
            }

            case 4 : {
                result = value1 / value2;
                break;
            }

            case 5 :
                return;

        }

        Drawer.draw( result );
    }
}






