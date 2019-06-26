package Testing;
import java.io.IOException;

import repository.BookRepository;

public class testBookCSV {
	public static void main(String[] args) throws IOException {
		BookRepository bookRepo = new BookRepository();
		
		bookRepo.loadAuthorDataBase();
		bookRepo.loadPublisherDataBase();
		bookRepo.loadBookDataBase();
		System.out.println(bookRepo.printBookList());
		
		System.out.println(bookRepo.retrieveBook("book10").getBookName());
		bookRepo.modifyBook("book10", "bookten");
		System.out.println(bookRepo.retrieveBook("bookten").getBookName());

//		System.out.println(bookRepo.printAuthorList());
//		System.out.println(bookRepo.printPublisherList());
	}

}
