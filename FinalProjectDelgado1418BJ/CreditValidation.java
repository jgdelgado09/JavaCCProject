//Import statements for individual classes.
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * The CreditValidation class uses the Luhn class to check if a list of credit card numbers is valid.
 * 
 * @Class: 2015FA-COSC-1437-81002
 * @Assignment: Final Project
 * @author Jose Delgado
 * @version 12-10-2015
 *
 */
public class CreditValidation
{
    /**Entry point of application.
     * 
     * @param args as String[]
     * @return void
     * @throws FileNotFoundException
     */
    public static  void main (String[] args) throws FileNotFoundException
    {
        //Greet the user.
        System.out.println("Hello, and welcome. This application determines the validity of a given card"
                + "by matching against known issuers and uses Luhn's algorithm to do so, then writing the valid numbers into a"
                + " seperate file with the appropriate issuer. Press enter to continue.");
        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();
        
        //Try statement to open files.
        try
        {
        //Open the files.
        File file = new File("cardnumbers.txt");
        File validFile = new File("valid_cards.txt");
        File validNumbersFile = new File("unmatched_nums.txt");
        File invalidFile = new File("invalid_numbers.txt");
        //Create a Scanner object to read from the file with the credit card numbers.
        Scanner ccFile = new Scanner(file);
        //Create a PrintWriter object to write valid numbers.
        PrintWriter validNums = new PrintWriter(validNumbersFile);
        //Create a PrintWriter object to write invalid numbers.
        PrintWriter invalidNums = new PrintWriter(invalidFile);
        
        
        while(ccFile.hasNext())
        {   
            //Variable to hold each line
            String cardNumber = ccFile.nextLine();
            
            //If-else decision to test the card number
            if(Luhn.Validate(cardNumber))
            {
                System.out.println(cardNumber + " is valid.");
                //Print the card number to the valid file.
                validNums.println(cardNumber);
            }
            else
            {
                System.out.println(cardNumber + " is invalid.");
                //Print the card number to the invalid file.
                invalidNums.println(cardNumber);
            }
        }   
        //Close invalid file.
        invalidNums.close();
        //Close valid file.
        validNums.close();
        
        
        //Scanner object to read from the valid file
        Scanner validRead = new Scanner(validNumbersFile);
        //PrintWrite object to write the matched cards to the file.
        PrintWriter validWrite = new PrintWriter(validFile);
        //While loop to read the numbers from the valid file
        while(validRead.hasNext())
        {
            //Variable to hold the numbers
            String card = validRead.nextLine();
            
            //If-else-is decision to match the card numbers to issuer.
            //AMEX
            if (card.startsWith("37") || card.startsWith("34"))
                {
                    //Write the issuer to the file.
                    validWrite.println(card + " is AMEX.");
                }
            //Discover
            else if(card.startsWith("60"))
                {
                    validWrite.println(card + " is Discover.");
                }
            //Diner's Club - North America
            else if(card.startsWith("54") || card.startsWith("55"))
                {
                    validWrite.println(card + " is Diner's Club - North America.");
                }
            //Diner's Club - Carte Blanche
            else if(card.startsWith("30"))
                {
                    validWrite.println(card + " is Diner's Club - Carte Blanche.");
                }
            //Diner's Club - International
            else if(card.startsWith("36"))
                {
                    validWrite.println(card + " is Diner's Club - International.");
                }
            //JCB
            else if(card.startsWith("31") || card.startsWith("33"))
                {
                    validWrite.println(card + " is Diner's Club - Carte Blanche.");
                }
            //LASER
            else if(card.startsWith("67"))
                {
                    validWrite.println(card + " is LASER");
                }
            //Maestro
            else if(card.startsWith("58"))
                {
                    validWrite.println(card + " is Maestro");
                }
            //InstaPayment
            else if(card.startsWith("63"))
                {
                    validWrite.println(card + " is InstaPayment");
                }
            //MasterCard
            else if(card.startsWith("51") || card.startsWith("53"))
                {
                    validWrite.println(card + " is MasterCard");
                }   
            //Visa
            else if(card.startsWith("44") || card.startsWith("45"))
                {
                    validWrite.println(card + " is Visa");
                }
            //Visa Electron    
            else if(card.startsWith("48") || card.startsWith("49"))
                {
                    validWrite.println(card + " is Visa Electron.");
                }   
            //Default message.
            else
                {
                    //Default message
                    validWrite.println(card + " does not have a known issuer.");
                }
    
        }
        

        //Close the files.
        ccFile.close();
        validRead.close();
        validWrite.close();
        }
        //catch statement to handle the exception/
        catch(FileNotFoundException e)
        {
            System.out.println("File was not found or is incorrect.");
        }
    }//End of main method.

}
