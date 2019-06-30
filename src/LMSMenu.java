


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
	public final static String WHATISNEWNAME = 
			"What is the new name?";

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
						lib.addBook(bookName, authorName, publisherName);
						//add operation
					}
					if(innerMenuChoice == 2) { //remove
						System.out.println(REMOVEMENU);
						System.out.println(BOOKNAMEQUESTION);
						String bookName = scan.nextLine();
						lib.removePublisherAndAuthorsByBook(bookName);
						//perform remove
						//maybe do if
					}
					if(innerMenuChoice == 3) { //retrieve
						System.out.println(RETRIEVEMENU);
						System.out.println(BOOKNAMEQUESTION);
						String bookName = scan.nextLine();
						System.out.println(lib.retrieveBook(bookName).getBookName());
						//retrieve
						//display
					}
					if(innerMenuChoice == 4) { //update
						System.out.println(UPDATEMENU);
						System.out.println(BOOKNAMEQUESTION);
						String bookName = scan.nextLine();
						System.out.println(WHATISNEWNAME);
						String newBookName = scan.nextLine();
						lib.updateBook(bookName, newBookName);
						
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
						lib.addAuthors(authorName);

					}
					if(innerMenuChoice == 2) { //remove
						System.out.println(REMOVEMENU);
						System.out.println(AUTHORNAMEQUESTION);
						String authorName = scan.nextLine();
						lib.removeBooksAndPublishersByAuthors(authorName);
						//perform remove
						//maybe do if
					}
					if(innerMenuChoice == 3) { //retrieve
						System.out.println(RETRIEVEMENU);
						System.out.println(AUTHORNAMEQUESTION);
						String authorName = scan.nextLine();
						lib.retrieveAuthor(authorName);
						//retrieve
						//display
					}
					if(innerMenuChoice == 4) { //update
						System.out.println(UPDATEMENU);
						System.out.println(AUTHORNAMEQUESTION);
						String authorName = scan.nextLine();
						System.out.println(WHATISNEWNAME);
						String newAuthorName = scan.next();
						lib.updateAuthor(authorName, newAuthorName);
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
						lib.addPublishers(publisherName);
					}
					if(innerMenuChoice == 2) { //remove
						System.out.println(REMOVEMENU);
						System.out.println(PUBLISHERNAMEQUESTION);
						String publisherName = scan.nextLine();
						lib.removeBooksAndAuthorsByPublisher(publisherName);
						//perform remove
						//maybe do if
					}
					if(innerMenuChoice == 3) { //retrieve
						System.out.println(RETRIEVEMENU);
						System.out.println(PUBLISHERNAMEQUESTION);
						String publisherName = scan.nextLine();
						System.out.println(lib.retrievePublisher(publisherName).getPublisherName());
						//retrieve
						//display
					}
					if(innerMenuChoice == 4) { //update
						System.out.println(UPDATEMENU);
						System.out.println(PUBLISHERNAMEQUESTION);
						String publisherName = scan.nextLine();
						System.out.println(WHATISNEWNAME);
						String newPublisherName = scan.next();
						lib.updatePublisher(publisherName, newPublisherName);
						//update
					}


				}

			}
			
		}
	}

}
