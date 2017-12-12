package com.epam.calculators;

public class Calc_sum {

	public static void main(String... args)	{

		if( args.length > 1 ) {
			try {
				int param1 = Integer.parseInt( args[0] );
				int param2 = Integer.parseInt( args[1] );
				System.out.println( args[0] + " + " + args[1] + " = " + (param1 + param2) );
			}
			catch (NumberFormatException e) {
				System.err.println( "Arguments must be integers." );
				System.exit(1);
			}
		}
		else
			System.out.println( "Please, supply with 2 arguments." );
	}
}
