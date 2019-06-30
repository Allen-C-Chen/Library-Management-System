package Testing;

import services.LibraryServices;

public class LMSServiceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LibraryServices lib = new LibraryServices();
		//System.out.println(lib.printBookList());
		System.out.println(lib.printBookList());

		//lib.addBook("book5", "author5", "publisher5");
		lib.addBook("book0", "author0", "publisher0");
		lib.addBook("book1", "author1", "publisher1");
		lib.addBook("book2", "author2", "publisher2");
		lib.addBook("book3", "author3", "publisher3");

		System.out.println("HHJEKWWE " );
		System.out.println(lib.printBookList());

		lib.removePublisherAndAuthorsByBook("book2");
		lib.addBook("book2", "author2", "publisher2");
		lib.addBook("book4", "author4", "publisher4");

		System.out.println(lib.printBookList());
		System.out.println("HI THERE");
		//lib.addBook("book2", "author2", "publisher2");
		//lib.removePublisherAndAuthorsByBook("book5");
		lib.removePublisherAndAuthorsByBook("book2");
		lib.addBook("book5", "author5", "publisher6");
		//lib.addBook("book6", "author6", "publisher5");
		
		//System.out.println(lib.printAuthorList());
		System.out.println("UPDATE");
		lib.updatePublisher("publisher1", "HI DIana");
		System.out.println(lib.printBookList());
		System.out.println(lib.printPublisherList());

		
		//lib.upload();
		//System.out.println(lib.printPublisherList());
	}

}
