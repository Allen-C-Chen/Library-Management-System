import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entity.Author;
import entity.Book;
import entity.Publisher;

class LMSDaoTest {

	//book class set methods test
	
	@Test
	void bookSetIDMethod() {
		Book newBook = new Book(1,"book1", 1, 1);
		newBook.setBookID(2);
        assertEquals(2, newBook.getBookID());
	}
	

}
