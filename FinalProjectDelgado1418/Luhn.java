/**
 * 
* @version The Luhn class checks whether a string of digits is a valid credit card number according to the Luhn algorithm.
* 
* @Class: 2015FA-COSC-1437-81002
* @Assignment: Final Project
* @author Text book
* @version 12-9-2015
*/
public class Luhn
{
		/**The Validate method evaluates a number and determines if it is a valid card or not using Luhn's algorithm.
		 * 
		 * @param cNumber
		 * @return boolean
		 * @throws not implemented
		 */
        public static boolean Validate(String cNumber)
        {	
        	//variable to hold the sum of the digits in the card.
                int sum = 0;
                //Return variable
                boolean alt = false;
                //For loop evaluating the number of the card from end to beginning.
                for (int i = cNumber.length() - 1; i >= 0; i--)
                {
                		//Reads the numbers backwards.
                        int n = Integer.parseInt(cNumber.substring(i, i + 1));
                        if (alt)
                        {
                        		//Double the value of that digit.
                                n *= 2;
                                //Sum the digits in that place to make it one-digit number.
                                if (n > 9)
                                {
                                        n-=9;
                                }
                        }
                        //Keep a counting sum of all the digits.
                        sum += n;
                        alt = !alt;
                }
                //Determine if the card is valid by doing a modulus operation on the total sum of the digits.
                return (sum % 10 == 0);
        }
}