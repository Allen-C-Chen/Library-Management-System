package services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import BookDOA.LMSDoa;
import entity.Author;
import entity.Book;
import entity.Publisher;

public class LibraryServices {
	private List<Book> books;
	private List<Author> authors;
	private List<Publisher> publishers;
	private LMSDoa library;
	public LibraryServices()  { //fix thro wexception later
		library = new LMSDoa();
		//books = new ArrayList<>();
		books = library.loadBookDataBase();
		//authors = new ArrayList<>();
		authors = library.loadAuthorDataBase();
		//publishers = new ArrayList<>();
		publishers = library.loadPublisherDataBase();
	}
	public void newLibrary() { //testing only
		books = new ArrayList<>();

		authors = new ArrayList<>();
		publishers = new ArrayList<>();
	}
	public void upload() { //fix throw execption later
		library.uploadBookDataBase(books);  
		library.uploadAuthorDataBase(authors);
		library.uploadPublisherDataBase(publishers);
	}
	
	//three add funtions
	public void addBook(String bookName, String authorName, String publisherName) {
		int firstBookIndex = findFirstBookIndex();
		int firstAuthorIndex = findFirstAuthorIndex();
		int firstPublisherIndex = findFirstPublisherIndex();
		books.add(firstBookIndex, new Book(firstBookIndex, bookName, firstAuthorIndex, firstPublisherIndex));
		addAuthors(authorName);
		addPublishers(publisherName);
	}
	public void addAuthors(String authorName) {
		int firstAuthorIndex = findFirstAuthorIndex();
		authors.add(firstAuthorIndex,new Author(firstAuthorIndex, authorName));
	}
	public void addPublishers(String publisherName) {
		int firstPublisherIndex = findFirstPublisherIndex();
		publishers.add(firstPublisherIndex, new Publisher(firstPublisherIndex, publisherName));
	}
	//three retrieve fucntions
	public Book retrieveBook(String bookName) {
		for(int i = 0; i < books.size(); i ++) {
			if(books.get(i).getBookName().equals(bookName)) {
				return books.get(i);
			}
		}
		return null;
	}
	public Author retrieveAuthor(String authorName) {
		for(int i = 0; i < authors.size(); i ++) {
			if(authors.get(i).getName().equals(authorName)) {
				return authors.get(i);
			}
		}
		return null;
	}
	public Publisher retrievePublisher(String publisherName) {
		for(int i = 0; i < publishers.size(); i ++) {
			if(publishers.get(i).getPublisherName().equals(publisherName)) {
				return publishers.get(i);
			}
		}
		return null;
	}
	//update
	public void updateBook(String bookName, String newBookName) {
		String str = "not";

		for(int i = 0; i < books.size(); i ++) {
			if(books.get(i).getBookName().equals(bookName)) {
				books.get(i).setBookName(newBookName);
				str = "";
			}
		}
		System.out.println("Book has " + str + " updated");

	}
	public void updateAuthor(String authorName, String newAuthorName) {
		String str = "not";

		for(int i = 0; i < authors.size(); i ++) {
			if(authors.get(i).getName().equals(authorName)) {
				authors.get(i).setName(newAuthorName);
				str = "";
			}
		}
		System.out.println("Author has " + str + " updated");

	}
	public void updatePublisher(String publisherName, String newPublisherName) {
		String str = "not";
		for(int i = 0; i < authors.size(); i ++) {
			if(publishers.get(i).getPublisherName().equals(publisherName)) {
				publishers.get(i).setPublisherName(newPublisherName);
				str = "";
			}
		}
		System.out.println("Publisher has " + str + " updated");
	}	
	//Simple/helper remove
	private void removeBook(String bookName) { //maybe return book removed
		for(int i = 0; i < books.size(); i ++) {
			if(bookName.equals(books.get(i).getBookName())) {
				System.out.println(books.remove(i).getBookName() + " has been removed");

				i--;
			}
		}
	}
	private void removeAuthors(int tempAuthorID) {
		for(int i = 0; i < authors.size(); i ++) {
			if(authors.get(i).getAuthorID() ==  tempAuthorID) {
				System.out.println(authors.remove(i).getName() + " has been removed");

				i--;
			}
		}	
	}
	
	private void removePublisher(int tempPublisherID) {
		for(int i = 0; i < publishers.size(); i ++) {
			if(tempPublisherID == publishers.get(i).getPublisherID()) {
				
				System.out.println(publishers.remove(i).getPublisherName() + " has been removed");
				i--;
			}
		}		
	}
	//advance removes
	public void removeBooksAndPublishersByAuthors(String authorName) {
		
		int authorID = retrieveAuthor(authorName).getAuthorID();
		for(int i = 0; i < books.size(); i ++) {
			if(books.get(i).getAuthorID() == authorID) {
				int tempPublisherID = books.get(i).getPublisherID();
				removePublisher(tempPublisherID);
				books.remove(i);
				i--;
			}
		}
		removeAuthors(authorID);
	}
	public void removeBooksAndAuthorsByPublisher(String publisherName) {
		int publisherID = retrievePublisher(publisherName).getPublisherID();
		for(int i = 0; i < books.size(); i ++) {
			if(books.get(i).getPublisherID() == publisherID) {
				int tempAuthorID = books.get(i).getAuthorID();
				removeAuthors(tempAuthorID);
				
				books.remove(i);
				i--;
			}

		}

		removePublisher(publisherID);
	}
	public void removePublisherAndAuthorsByBook(String bookName) {
		Book tempBook = retrieveBook(bookName);
		
		int tempPublisherID = tempBook.getPublisherID();
		removePublisher(tempPublisherID);
		int tempAuthorID = tempBook.getAuthorID();
		
		removeAuthors(tempAuthorID);
		removeBook(bookName);
	}	
	//print list functions
	public String printBookList() {
		String str = "";
		for(int i =0 ; i < books.size(); i ++) {
			str += "bookID: " + books.get(i).getBookID() + "\n";
			str += "bookName: "+ books.get(i).getBookName() + "\n";
			str += "authorID: "+ books.get(i).getAuthorID() + "\n";
			str += "publisherID: "+ books.get(i).getPublisherID()+ "\n";
			str += "\n";
		}
		return str;
	}
	public String printAuthorList() {
		String str = "";
		for(int i =0 ; i < authors.size(); i ++) {
			str += "authorID: " + authors.get(i).getAuthorID() + "\n";
			str += "authorName: "+ authors.get(i).getName() + "\n";
			str += "\n";
		}
		return str;
	}
	public String printPublisherList() {
		String str = "";
		for(int i =0 ; i < publishers.size(); i ++) {
			str += "PublisherID: " + publishers.get(i).getPublisherID() + "\n";
			str += "PublisherName: " + publishers.get(i).getPublisherName() +  "\n";
			str += "\n";
		}
		return str;
	}
	//helper functions
	public int findFirstBookIndex() { //**
		for(int i = 0; i < books.size(); i ++) {
			
			if(i != books.get(i).getBookID()) {
				return i;
			}
		}
		return books.size();
	}
	public int findFirstPublisherIndex() { //**
		for(int i = 0; i < publishers.size(); i ++) {
			
			if(i != publishers.get(i).getPublisherID()) {
				return i;
			}
		}
		return publishers.size();
	}
	public int findFirstAuthorIndex() { //**
		for(int i = 0; i < authors.size(); i ++) {
			
			if(i != authors.get(i).getAuthorID()) {
				return i;
			}
		}
		return authors.size();
	}

}
