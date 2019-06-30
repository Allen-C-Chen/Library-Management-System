package BookDOA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.Author;
import entity.Book;
import entity.Publisher;

public class LMSDoa {
	//private List<Book> books = new ArrayList<>();
	//private List<Author> authors = new ArrayList<>();
	//private List<Publisher> publishers = new ArrayList<>();

	
	//book doa methods
	public List<Book> loadBookDataBase() {
		String row;
		List<Book> books = new ArrayList<>();

		try {
			BufferedReader csvReader;

			csvReader = new BufferedReader(new FileReader("book.csv"));
			while ((row = csvReader.readLine()) != null) {  
			    String[] data = row.split(",");
			    int bookID = Integer.parseInt(data[0]);//id
			    String name = data[1]; //name
			    int authorID = Integer.parseInt(data[2]);
			    int publisherID = Integer.parseInt(data[3]);
			    Book newBook = new Book(bookID,name,authorID,publisherID);
			    books.add(newBook);
			}
			//idBookCount = books.size(); /need to fi siizng issue
			csvReader.close();  

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return books;
	}
	
	public void uploadBookDataBase(	List<Book> books)  {
		FileWriter csvWriter;
		try {
			csvWriter = new FileWriter("book.csv");
			for (Book rowData : books) {  
				csvWriter.append(rowData.getBookID() + ",");
				csvWriter.append(rowData.getBookName() + ",");
				csvWriter.append(rowData.getAuthorID() + ",");
				csvWriter.append(rowData.getPublisherID() + ",");
			    csvWriter.append("\n");
			}
			csvWriter.flush();  
			csvWriter.close();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	//author DOA methods
	public List<Author> loadAuthorDataBase() { //Fix excepetions later
		
		List<Author> authors = new ArrayList<>();
		String row;
		try {
			BufferedReader csvReader;

			csvReader = new BufferedReader(new FileReader("author.csv"));
			while ((row = csvReader.readLine()) != null) {  
			    String[] data = row.split(",");
			    int authorID = Integer.parseInt(data[0]);
			    String name = data[1];
			    Author newAuthor = new Author(authorID, name);
			    authors.add(newAuthor);
			    
			}
			//idBookCount = books.size(); /need to fi siizng issue
			csvReader.close();  

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		//idAuthorCount = authors.size();

		return authors;
	}
	public void uploadAuthorDataBase(List<Author> authors ) {
		
		FileWriter csvWriter;
		try {
			csvWriter = new FileWriter("author.csv");  
			for (Author rowData : authors) {  
				csvWriter.append(rowData.getAuthorID() + ",");
				csvWriter.append(rowData.getName() + ",");
			    csvWriter.append("\n");
			}
			csvWriter.flush();  
			csvWriter.close();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	//publisher doas
	public List<Publisher> loadPublisherDataBase()  { //fix also
		List<Publisher> publishers = new ArrayList<>();
		String row;
		try {
			BufferedReader csvReader;

			csvReader = new BufferedReader(new FileReader("publisher.csv"));
			while ((row = csvReader.readLine()) != null) {  
			    String[] data = row.split(",");
			    int publisherID = Integer.parseInt(data[0]);
			    String name  = data[1];
			    Publisher newPublisher = new Publisher(publisherID, name);
			    publishers.add(newPublisher);
			}
			
			//idBookCount = books.size(); /need to fi siizng issue
			csvReader.close();  

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		return publishers;
	}
	
	public void uploadPublisherDataBase(List<Publisher> publishers) {
		FileWriter csvWriter;
		try {
			csvWriter = new FileWriter("publisher.csv");  
			for (Publisher rowData : publishers) {  
				csvWriter.append(rowData.getPublisherID() + ",");
				csvWriter.append(rowData.getPublisherName() + ",");
			    csvWriter.append("\n");
			}
			csvWriter.flush();  
			csvWriter.close();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

}
