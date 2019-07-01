import static org.junit.Assert.*;

import org.junit.Test;

import services.LibraryServices;

public class LMSTest {
	@Test
	public void retrieveBook() {
		LibraryServices lib = new LibraryServices();
		assertTrue(lib.retrieveBook("book1").getBookName().equals("book1"));
	}
	@Test
	public void updateRemoveOLdFail() {
		LibraryServices lib = new LibraryServices();
		lib.updateBook("book1", "bookOne");
		lib.removePublisherAndAuthorsByBook("bookOne");
		assertTrue(lib.retrieveBook("bookOne") == null);

	}
	@Test
	public void updateFailFind() {
		LibraryServices lib = new LibraryServices();
		lib.updateBook("book1", "bookOne");
		assertTrue(lib.retrieveBook("book1") == null);

	}
	@Test
	public void updateTest1() {
		LibraryServices lib = new LibraryServices();
		lib.updateBook("book1", "bookOne");
		assertTrue(lib.retrieveBook("bookOne").getBookName().equals("bookOne"));
	}
	@Test
	public void updateNotFoundBookTest() {
		LibraryServices lib = new LibraryServices();
		lib.updateBook("book1", "bookOne");
		assertTrue(lib.retrieveBook("book1") == null);

	}
	@Test
	public void add5Test() { //might need to change
		LibraryServices lib = new LibraryServices();
		LibraryServices lib2 = new LibraryServices();
		lib.newLibrary();
		lib.addBook("book0", "author0", "publisher0");
		lib.addBook("book1", "author1", "publisher1");
		lib.addBook("book2", "author2", "publisher2");
		lib.addBook("book3", "author3", "publisher3");
		lib.addBook("book4", "author4", "publisher4");
		assertTrue(lib.printBookList().equals(lib2.printBookList()));
	}
	@Test
	public void addRemoveTest1() {
		LibraryServices lib = new LibraryServices();
		LibraryServices lib2 = new LibraryServices();

		lib.removePublisherAndAuthorsByBook("book2");
		lib.addBook("book2", "author2", "publisher2");
		assertTrue(lib.printBookList().equals(lib2.printBookList()));
	}
	@Test 
	public void addTwoFindTwo() {
		LibraryServices lib = new LibraryServices();
		lib.addBook("book6", "author6", "publisher6");
		lib.addBook("book7", "author7", "publisher7");
		assertTrue(lib.retrieveBook("book7").getBookName().equals("book7") );
		assertTrue(lib.retrieveBook("book6").getBookName().equals("book6") );
	}

	@Test 
	public void addTwoRemoveTwoFindTwo() {
		LibraryServices lib = new LibraryServices();
		lib.addBook("book6", "author6", "publisher6");
		lib.addBook("book7", "author7", "publisher7");
		lib.removePublisherAndAuthorsByBook("book6");
		lib.removePublisherAndAuthorsByBook("book7");
		assertTrue(lib.retrieveBook("book7") == null );
		assertTrue(lib.retrieveBook("book6") == null );
	}


}
