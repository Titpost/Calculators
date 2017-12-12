package com.epam.homework.august25;

class Drawer
{
	private final static byte letterHeight = 5;
	
	private final static byte glyphs[][] =
	{ 
            { // 0
              0b111,
 	      0b101,
 	      0b101,
 	      0b101,
              0b111
            },
            { // 1
 	      0b001,
 	      0b011,
 	      0b001,
 	      0b001,
 	      0b001
	    },
	    { // 2
 	      0b111,
 	      0b001,
 	      0b111,
 	      0b100,
              0b111
            },
	    { // 3
 	      0b111,
 	      0b001,
 	      0b111,
 	      0b001,
 	      0b111
            },
            { // 4
 	      0b101,
 	      0b101,
 	      0b111,
 	      0b001,
              0b001
            },
            { // 5
 	      0b111,
 	      0b100,
 	      0b111,
 	      0b001,
 	      0b111
            },
            { // 6
 	      0b111,
 	      0b100,
 	      0b111,
 	      0b101,
              0b111
            },
            { // 7
 	      0b111,
 	      0b001,
 	      0b001,
 	      0b001,
 	      0b001
            },
            { // 8
 	      0b111,
 	      0b101,
 	      0b111,
 	      0b101,
              0b111
            },
            { // 9
 	      0b111,
 	      0b101,
 	      0b111,
 	      0b001,
 	      0b111
            }
	};

	private static byte[] bufferDigits = new byte[24]; // capacity of 24 digits must be enough

        // draws number on console
	public static void draw(final long result)
	{
		// calculate result length
		int resultLength = 0;
		boolean isResultNegative = result < 0 ? true : false;
		long digitsToParse = isResultNegative ? -result : result ;
		if( 0 == result )
		{
			bufferDigits[ resultLength++ ] = (byte)0;
		}
		else {
			while (digitsToParse > 0) {
				bufferDigits[resultLength++] = (byte) (digitsToParse % 10);
				digitsToParse /= 10;
			}
		}

		// draw line by line
		int line = -1;
		while( ++line < letterHeight )
		{
			// we must draw minus sign if result is negative
			if( 2 == line && isResultNegative )
				System.out.print( " хх  " );
			else
				System.out.print( "     " );

			// for each digit
			for( int letterNum = resultLength-1; letterNum >= 0; letterNum-- )
			{
				final int index = bufferDigits[ letterNum ];
				System.out.print(  ((glyphs[index][line] & 0b100) == 0b100) ? 'X' : ' '          );
				System.out.print(  ((glyphs[index][line] & 0b010) == 0b010) ? 'X' : ' '          );
				System.out.print( (((glyphs[index][line] & 0b001) == 0b001) ? 'X' : ' ') + "   " );
			}
			
			// draw next line
			System.out.println(); 
		}
	}
}






