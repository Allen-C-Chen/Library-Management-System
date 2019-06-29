package Testing;
import java.io.IOException;

import BookDOA.BookManager;

public class testBookCSV {
	public static void main(String[] args) throws IOException {
		BookManager bookRepo = new BookManager();
		
		bookRepo.loadAuthorDataBase();
		bookRepo.loadPublisherDataBase();
		bookRepo.loadBookDataBase();
		System.out.println(bookRepo.printBookList());
		
		System.out.println(bookRepo.retrieveBook("book10").getBookName());
		bookRepo.modifyBook("book10", "bookten");
		System.out.println(bookRepo.retrieveBook("bookten").getBookName());
		System.out.println("hi " + bookRepo.findFirstBookIndex());
		
		System.out.println("*********************");
		bookRepo.removeAllPublisherAndAuthorsBasedOnBook("book1");
		bookRepo.removeAllBooksAndPublishersBasedOnAuthors("author4");
		bookRepo.removeAllBooksAndAuthorsBasedOnPublisher("publisher14");
		System.out.println(bookRepo.printBookList());
		System.out.println(bookRepo.printAuthorList());
		System.out.println(bookRepo.printPublisherList());

//		System.out.println(bookRepo.printAuthorList());
//		System.out.println(bookRepo.printPublisherList());
	}

}
