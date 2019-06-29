


import java.util.Scanner;

import services.LibraryServices;

public class LMSMenu {

	public final static String DEFAULTMENU = 
			"Hello there, would you like to modfiy \n" + 
			"(1) Book \n" +
			"(2) Authors \n" +
			"(3) Publisher \n" +
			"(4) Quit";

	public final static String MODFICATIONMENU = 
			"Please choice one of the following options\n" + 
			"(1) ADD\n" +
			"(2) REMOVE\n" + 
			"(3) RETRIEVE\n" +  
			"(4) UPDATE\n" +
			"(5) Back to main menu";
	public final static String ADDMENU = 
			"Hello there you selected the add option";
	public final static String REMOVEMENU = 
			"Hello there you selected the remove option";
	public final static String RETRIEVEMENU = 
			"Hello there you selected the retrieve option";
	public final static String UPDATEMENU= 
			"Hello there you selected the update option";
	public final static String BOOKNAMEQUESTION = 
			"What is the book name?";
	public final static String AUTHORNAMEQUESTION = 
			"What is the author name?";
	public final static String PUBLISHERNAMEQUESTION = 
			"What is the publisher name?";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Scanner scan = new Scanner( System.in );

		int defaultMenuChoice = 0;
		int innerMenuChoice = 0;
		LibraryServices lib = new LibraryServices();
		while(defaultMenuChoice < 4) {
			System.out.println(DEFAULTMENU);
			defaultMenuChoice = scan.nextInt();
			if(defaultMenuChoice == 1) {
				while (innerMenuChoice < 5) {
					System.out.println("Hello you selected Book, please select one");
					System.out.println(MODFICATIONMENU);
					innerMenuChoice = scan.nextInt();
					if(innerMenuChoice == 1) { //add
						System.out.println(ADDMENU);
						System.out.println(BOOKNAMEQUESTION);
						String bookName = scan.nextLine();
						
						System.out.println(AUTHORNAMEQUESTION);
						String authorName = scan.nextLine();
						
						System.out.println(PUBLISHERNAMEQUESTION);
						String publisherName = scan.nextLine();

						//add operation
					}
					if(innerMenuChoice == 2) { //remove
						System.out.println(REMOVEMENU);
						System.out.println(BOOKNAMEQUESTION);
						String bookName = scan.nextLine();

						//perform remove
						//maybe do if
					}
					if(innerMenuChoice == 3) { //retrieve
						System.out.println(RETRIEVEMENU);
						System.out.println(BOOKNAMEQUESTION);
						String bookName = scan.nextLine();
						
						//retrieve
						//display
					}
					if(innerMenuChoice == 4) { //update
						System.out.println(UPDATEMENU);
						System.out.println(BOOKNAMEQUESTION);
						String bookName = scan.nextLine();
						
						//update
					}

				}
				
			}
			if(defaultMenuChoice == 2) {
				while (innerMenuChoice < 5) {
					System.out.println("Hello you selected Authors, please select one");
					System.out.println(MODFICATIONMENU);
					innerMenuChoice = scan.nextInt();
					if(innerMenuChoice == 1) { //add
						System.out.println(ADDMENU);
						System.out.println(AUTHORNAMEQUESTION);
						String authorName = scan.nextLine();

					}
					if(innerMenuChoice == 2) { //remove
						System.out.println(REMOVEMENU);
						System.out.println(AUTHORNAMEQUESTION);
						String authorName = scan.nextLine();

						//perform remove
						//maybe do if
					}
					if(innerMenuChoice == 3) { //retrieve
						System.out.println(RETRIEVEMENU);
						System.out.println(AUTHORNAMEQUESTION);
						String authorName = scan.nextLine();
						
						//retrieve
						//display
					}
					if(innerMenuChoice == 4) { //update
						System.out.println(UPDATEMENU);
						System.out.println(AUTHORNAMEQUESTION);
						String authorName = scan.nextLine();
						
						//update
					}

				}


			}
			if(defaultMenuChoice == 3) {
				while (innerMenuChoice < 5) {
					System.out.println("Hello you selected Publishers, please select one");
					System.out.println(MODFICATIONMENU);
					innerMenuChoice = scan.nextInt();
					if(innerMenuChoice == 1) { //add
						System.out.println(ADDMENU);
						System.out.println(PUBLISHERNAMEQUESTION);
						String publisherName = scan.nextLine();

					}
					if(innerMenuChoice == 2) { //remove
						System.out.println(REMOVEMENU);
						System.out.println(PUBLISHERNAMEQUESTION);
						String publisherName = scan.nextLine();

						//perform remove
						//maybe do if
					}
					if(innerMenuChoice == 3) { //retrieve
						System.out.println(RETRIEVEMENU);
						System.out.println(PUBLISHERNAMEQUESTION);
						String publisherName = scan.nextLine();
						
						//retrieve
						//display
					}
					if(innerMenuChoice == 4) { //update
						System.out.println(UPDATEMENU);
						System.out.println(PUBLISHERNAMEQUESTION);
						String publisherName = scan.nextLine();
						
						//update
					}


				}

			}
			
		}
	}

}
