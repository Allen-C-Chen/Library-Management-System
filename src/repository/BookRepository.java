package repository;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import entity.Book;
import entity.Author;
import entity.Publisher;
public class BookRepository {
	private List<Book> books = new ArrayList<>();
	private List<Author> authors = new ArrayList<>();
	private List<Publisher> publishers = new ArrayList<>();

	private int idBookCount = 0;
	private int idAuthorCount = 0;
	private int idPublisherCount = 0;

	public void loadBookDataBase() throws IOException {
		String row;
		BufferedReader csvReader = new BufferedReader(new FileReader("book.csv"));  
		while ((row = csvReader.readLine()) != null) {  
		    String[] data = row.split(",");
		    long bookID = Long.parseLong(data[0]);//id
		    String name = data[1]; //name
		    long authorID = Long.parseLong(data[2]);
		    long publisherID = Long.parseLong(data[3]);
		    Book newBook = new Book(bookID,name,authorID,publisherID);
		    books.add(newBook);
		}
		idBookCount = books.size();
		csvReader.close();  
	}
	public void uploadBookDataBase() throws IOException {
		FileWriter csvWriter = new FileWriter("book.csv");  
	
		for (Book rowData : books) {  
			csvWriter.append(rowData.getBookID() + ",");
			csvWriter.append(rowData.getBookName() + ",");
			csvWriter.append(rowData.getAuthorID() + ",");
			csvWriter.append(rowData.getPublisherID() + ",");
		    csvWriter.append("\n");
		}
		csvWriter.flush();  
		csvWriter.close();  
	}
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
	public void addBook(String bookName, String authorName, String publisherName) {
		idBookCount++;
		books.add(new Book(idBookCount, bookName, idAuthorCount, idPublisherCount));
		
	}
	public Book retrieveBook(String bookName) {
		for(int i = 0; i < books.size(); i ++) {
			if(books.get(i).getBookName().equals(bookName)) {
				return books.get(i);
			}
		}
		return null;
	}
	public void modifyBook(String bookName, String newBookName) {
		for(int i = 0; i < books.size(); i ++) {
			if(books.get(i).getBookName().equals(bookName)) {
				books.get(i).setBookName(newBookName);
			}
		}

	}

	
	//author functions
	public void loadAuthorDataBase() throws IOException {
		String row;
		BufferedReader csvReader = new BufferedReader(new FileReader("author.csv"));  
		while ((row = csvReader.readLine()) != null) {  
		    String[] data = row.split(",");
		    long authorID = Long.parseLong(data[0]);
		    String name = data[1];
		    Author newAuthor = new Author(authorID, name);
		    authors.add(newAuthor);
		}
		idAuthorCount = authors.size();

		csvReader.close();  

	}
	public void uploadAuthorDataBase() throws IOException {
		FileWriter csvWriter = new FileWriter("author.csv");  
	
		for (Author rowData : authors) {  
			csvWriter.append(rowData.getAuthorID() + ",");
			csvWriter.append(rowData.getName() + ",");
		    csvWriter.append("\n");
		}
		csvWriter.flush();  
		csvWriter.close();  
	}
	
	public void addAuthorName(String authorName) {
		//not sure if needed
	}	
	public Author retrieveAuthor(String authorName) {
		for(int i = 0; i < authors.size(); i ++) {
			if(authors.get(i).getName().equals(authorName)) {
				return authors.get(i);
			}
		}
		return null;
	}
	public void modifyAuthor(String authorName, String newAuthorName) {
		for(int i = 0; i < authors.size(); i ++) {
			if(authors.get(i).getName().equals(authorName)) {
				authors.get(i).setName(newAuthorName);
			}
		}

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
	//publisher functions
	
	public void loadPublisherDataBase() throws IOException {
		String row;
		BufferedReader csvReader = new BufferedReader(new FileReader("book.csv"));  
		while ((row = csvReader.readLine()) != null) {  
		    String[] data = row.split(",");
		    long publisherID = Long.parseLong(data[0]);
		    String name  = data[1];
		    Publisher newPublisher = new Publisher(publisherID, name);
		    publishers.add(newPublisher);
		}
		idPublisherCount = publishers.size();

		csvReader.close();  
	}
	public void uploadPublisherDataBase() throws IOException {
		FileWriter csvWriter = new FileWriter("author.csv");  
	
		for (Publisher rowData : publishers) {  
			csvWriter.append(rowData.getPublisherID() + ",");
			csvWriter.append(rowData.getPublisherName() + ",");
		    csvWriter.append("\n");
		}
	}
	public void addPublisher(String publisherName) {
		
	}
	public Author retrievePublisher(String publisherName) {
		for(int i = 0; i < authors.size(); i ++) {
			if(authors.get(i).getName().equals(publisherName)) {
				return authors.get(i);
			}
		}
		return null;
	}
	public void modifyPublisherr(String publisherName, String newpublisherName) {
		for(int i = 0; i < authors.size(); i ++) {
			if(authors.get(i).getName().equals(publisherName)) {
				authors.get(i).setName(newpublisherName);
			}
		}
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


	
}
