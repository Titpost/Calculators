package com.epam.calculators;

public class Calc_div {

	public static void main(String... args)	{

		if( args.length > 1 ) {
			try {
				float param1 = Float.parseFloat( args[0] );
				float param2 = Float.parseFloat( args[1] );				
				System.out.println( args[0] + " / " + args[1] + " = " + (param1 / param2) );
			}
			catch (NumberFormatException e) {
				System.err.println( "Arguments must be floats." );
				System.exit(1);
			}
		}
		else
			System.out.println( "Please, supply with 2 arguments." );
	}
}
