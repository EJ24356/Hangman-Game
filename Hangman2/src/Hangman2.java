/*
 Hangman2.java
* Author: Jesse Eldell
* Submission Date: March 17th, 2016
*
* This is a hangman game. The user will try to guess a word that is randomly
* generated. They will have 15,12, or 10 guesses depending on the difficulty
* level selected. The user is able to guess a certain amount of letters for
* a certain amount of spaces in order to get the right answer.
*
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly
* prohibited unless you have written consent from the Department
* of Computer Science at the University of Georgia.
*/

import java.util.Scanner;

public class Hangman2 {
   private static final boolean testingMode=true;
	public static void main(String[] args) 
	{
		boolean playGame=true; //As long as max isn't 20 and you don't say no
	do
	{
		String answer=RandomWord.newWord(); //Secret word
		String input; //input from the user
        int max=0;
        String kinput; //input for the user (in terms of a letter)
   
	 System.out.println("Enter your difficulty: Easy (e), Intermediate (i), or Hard (h)"); 
       Scanner keyboard=new Scanner (System.in).useDelimiter("\r\n");
       input=keyboard.next();
     
	 if (!("Easy".equalsIgnoreCase(input))&&(input.charAt(0)!='e')
	&&!("Intermediate".equalsIgnoreCase(input))&&(input.charAt(0)!='i')
		&&!("Hard".equalsIgnoreCase(input))&&(input.charAt(0)!='h'))
			 
	 {
		 do
		 {
			 System.out.println("Invalid difficulty. Try Again...");
			 input=keyboard.next();
			 
		 } while (!("Easy".equalsIgnoreCase(input))&&(input.charAt(0)!='e')
					&&!("Intermediate".equalsIgnoreCase(input))&&(input.charAt(0)!='i')
					&&!("Hard".equalsIgnoreCase(input))&&(input.charAt(0)!='h'));
	 }
       
	
	 if (testingMode==true)
		{
			System.out.println("The secret word is: "+answer);
		}
		else 
		{
			System.out.println("Find out for yourself...");	
		}
	 String fd="";
	 int length=answer.length(); //length of the answer
	 int index=0;  // this will change
	  do 
	  {
		 if (answer.charAt(index)==answer.charAt(index))
		 {
			 fd+='-';
		 }
	      index++;
		  
	  } while (length>index);
			
			String newupdate=fd; //This is subject to change throughout the loop
	 System.out.println("The word is : " + newupdate);
	
	  int guesses=0;
	  int spaces=0;
	
	  if (("Easy".equalsIgnoreCase(input)||(input.charAt(0)=='e')))
	  {
		  guesses=15;
		  spaces=4;	  
	  }
	  else if(("Intermediate".equalsIgnoreCase(input)||(input.charAt(0)=='i')))
	{
		guesses=12;
		spaces=3;
	}
  
	  else if (("Hard".equalsIgnoreCase(input)||(input.charAt(0)=='h')))
	  {
		  guesses=10;
		  spaces=2;
	  }
	   
	  //The hardest part was figuring out how to count spaces and validate each integer
	  // I used delimiter to make \n and \r not be buffered and counted in the string
	do
	{	 
	     System.out.println("Please enter the letter you want to guess: ");
	                                                
	  kinput=keyboard.next();	  
  boolean guesswrong=true;
	    if (kinput.equalsIgnoreCase("solve"))
	       {
	    	  System.out.print("Please solve the answer: ");
	    	  kinput=keyboard.next();
	    	  if (kinput.equalsIgnoreCase(answer))
	    	  {
	    		  System.out.println("You win!");
	    		  System.out.println("You have guessed the word! Congratulations");
	    		  break;
	    	  }
	    	  else if (!(kinput.equalsIgnoreCase(answer)))
	    	  {
	    		  System.out.println("That is not the secret word");
	    		  guesses--;
	    		  System.out.println("Guesses Reminaing: "+guesses);
	    		  guesswrong=false;
	    	  }
	    	  if (guesses==0)
			   {
				System.out.println("You have failed to guess the word... :(");  
				break;
			   }
	       }

	 
	  if (Character.isDigit(kinput.charAt(0)))
	  {
		  do
		  {
			  System.out.println("Your input is not valid. Try again.");
			  System.out.println("Guesses Remaining "+guesses);
			  System.out.println("Please enter the letter you want to guess: ");
			  kinput=keyboard.next();
		  } while (Character.isDigit(kinput.charAt(0)));
	  }
	  if (guesswrong==false)
	  {
		  continue;
	  }
	 if((Character.isAlphabetic(kinput.charAt(0))&&!(kinput.equalsIgnoreCase("solve"))))
	 {
     System.out.println("Please enter the spaces you want to check (seperated by spaces)");
	   String spaceput=keyboard.next().trim();
	   spaceput+=' ';
	   boolean valid=true;
	       for (int i=0;i<spaceput.length();i+=2)
	       {
	    	   if (Character.isDigit(spaceput.charAt(i))&&
	    	  (length>Character.getNumericValue(spaceput.charAt(i)))
	    	   &&(spaceput.charAt(i+1)==' ')&&(spaceput.length()==spaces*2))
	    	   {
	    		 valid=true;
	    	   }
	    	   else 
	    	   {
	    		   System.out.print("Your input is not valid. Try again.\n");
	 			  System.out.print("Guesses Remaining: "+guesses+"\n");
	 			  valid=false;
	 			  break;
	    	   }
	    	   
	       }
	       if (valid==true){
	    	   
	       
	       int i=0,t=0,w=0,a=0,ds=0;
	       
	       
	     if (spaces==4)
	     {
	    	  t=Character.getNumericValue(spaceput.charAt(2));
		        w=Character.getNumericValue(spaceput.charAt(4));
		        a=Character.getNumericValue(spaceput.charAt(6));
		        ds=Character.getNumericValue(spaceput.charAt(0));
		       
	     }
	       else if (spaces==3)
	        {
	    	    t=Character.getNumericValue(spaceput.charAt(2));
		        w=Character.getNumericValue(spaceput.charAt(4));
		        a=0;
		       boolean forreal = false;
		       ds=Character.getNumericValue(spaceput.charAt(0));
		       	
	        }
	        else if (spaces==2)
	        {
	           t=Character.getNumericValue(spaceput.charAt(2));
	  	        w=0;
	  	        a=0;
	  	        ds=Character.getNumericValue(spaceput.charAt(0));
	        }
	     boolean forreal = false;
	     int dss = 0,ts=0,ws=0,as=0;
	       for (i=0;i<length;i++)
   	    {
	       if ((answer.charAt(i)==kinput.charAt(0))&&(i==ds||i==t||i==a||i==w))
	       {  	  
	    		  String y=newupdate.substring(0,i);
		    	   String u=newupdate.substring(i+1);
		    	   newupdate=y+kinput.charAt(0)+u; 	     
		    	   ds=Character.getNumericValue((spaceput.charAt(0)));
		    	   forreal=true;
		    	   dss=ds;
		    	   ts=t;
		    	   as=a;
		    	   ws=w;
	        }
	       else if ((dss!=ds&&ts!=t&&as!=a&&ws!=w))
	       {
	    	   forreal=false;
	       }
   	    }
	    	  if (forreal==true)
			     {
			    	    System.out.println("Your guess is in the word!");
			 	       System.out.println("The updated word is: "+ newupdate);
			     	   System.out.println("Guesses Remaining: "+guesses);
			     	   kinput="";
			     	    if (newupdate.equalsIgnoreCase(answer))
			     	    {
			     	    	System.out.println("You win!");
				    		  System.out.println("You have guessed the word! Congratulations");
				    		  break;
			     	    }
			     }
			     else 
			     {
			    	   guesses--;
			    	 System.out.println("Your letter was not found in the spaces provided");
			    	   System.out.println("Guesses Remaining: "+guesses);
			     }
	      }
	       if (guesses==0)
		   {
			System.out.println("You have failed to guess the word... :(");  
		   }
	 }
	 
    }  while ((answer.toLowerCase()==answer.toLowerCase())||guesses==0);
	 
	 if ((guesses==0)||(newupdate.equalsIgnoreCase(answer))||(kinput.equalsIgnoreCase(answer)))
	  {
	  System.out.println("Would you like to play again? Yes(y) or No (n)");
	   input=keyboard.next();
	    if ("yes".equalsIgnoreCase(input)||"y".equalsIgnoreCase(input))
	    {
	    	max++;
	    	input="";
	    }
	    else if ("no".equalsIgnoreCase(input)||"n".equalsIgnoreCase(input))
	    {
	    	System.out.println("Thanks for playing !!!");
	    	System.exit(0);
	    }
	 	 System.out.println("Games Completed: "+ max);
       
	}while ((max<20)&&(("no".equalsIgnoreCase(input)||"n".equalsIgnoreCase(input))));
	  
	if (max==20)
	{
		playGame=false;
	}
	
   } while (playGame==true);
	
   
   // Best project challenge of the year! And it only gets better!
   
	}
	
}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	   
	 
	

	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	


