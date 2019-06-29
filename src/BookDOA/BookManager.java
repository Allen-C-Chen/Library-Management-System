package BookDOA;

//OLD CLASS TO IGNORE
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
public class BookManager {
	private List<Book> books = new ArrayList<>();
	private List<Author> authors = new ArrayList<>();
	private List<Publisher> publishers = new ArrayList<>();

	private int idBookCount = 0;
	private int idAuthorCount = 0;
	private int idPublisherCount = 0;

	public void loadBookDataBase() {
		String row;
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
			idBookCount = books.size();
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
	//modify to accept a name
	public void uploadBookDataBase()  {
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
	public void removeBook(String bookName) {
		for(int i = 0; i < books.size(); i ++) {
			if(bookName.equals(books.get(i).getBookName())) {
				books.remove(i);
				i--;
			}
		}
	}
	
	public void removeAllBooksAndPublishersBasedOnAuthors(String authorName) {
		
		int authorID = retrieveAuthor(authorName).getAuthorID();
		for(int i = 0; i < books.size(); i ++) {
			if(books.get(i).getAuthorID() == authorID) {
				int tempPublisherID = books.get(i).getPublisherID();
				for(int j = 0; j < publishers.size(); j ++) {
					if(tempPublisherID == publishers.get(j).getPublisherID()) {
						publishers.remove(j);
						j--;
					}
				}
				books.remove(i);
				i--;
			}
		}
		removeAuthors(authorID);
	}
	public void removeAllBooksAndAuthorsBasedOnPublisher(String publisherName) {
		int publisherID = retrievePublisher(publisherName).getPublisherID();
		for(int i = 0; i < books.size(); i ++) {
			if(books.get(i).getPublisherID() == publisherID) {
				System.out.println("SDFJSDFFDFDSFSDDFSSSSSSSSSSSSSSSSSSSSSSSSS");
				int tempAuthorID = books.get(i).getAuthorID();
				removeAuthors(tempAuthorID);
				
				books.remove(i);
				i--;
			}

		}

		removePublisher(publisherID);
	}
	public void removeAllPublisherAndAuthorsBasedOnBook(String bookName) {
		Book tempBook = retrieveBook(bookName);
		
		int tempPublisherID = tempBook.getPublisherID();
		removePublisher(tempPublisherID);
		int tempAuthorID = tempBook.getAuthorID();
		
		removeAuthors(tempAuthorID);
		removeBook(bookName);
	}
	
	//author functions
	public void loadAuthorDataBase() throws IOException {
		String row;
		BufferedReader csvReader = new BufferedReader(new FileReader("author.csv"));  
		while ((row = csvReader.readLine()) != null) {  
		    String[] data = row.split(",");
		    int authorID = Integer.parseInt(data[0]);
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
		
	}	
	public void removeAuthors(int tempAuthorID) {
		for(int i = 0; i < authors.size(); i ++) {
			if(authors.get(i).getAuthorID() ==  tempAuthorID) {
				authors.remove(i);
				i--;
			}
		}	
	}
	public Author retrieveAuthor(String authorName) {
		for(int i = 0; i < authors.size(); i ++) {
			if(authors.get(i).getName().equals(authorName)) {
				return authors.get(i);
			}
		}
		return null;
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
		BufferedReader csvReader = new BufferedReader(new FileReader("publisher.csv"));  
		while ((row = csvReader.readLine()) != null) {  
		    String[] data = row.split(",");
		    int publisherID = Integer.parseInt(data[0]);
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
		csvWriter.flush();  
		csvWriter.close();  

	}
	public void addPublisher(String publisherName) {
		
	}
	public Publisher retrievePublisher(String publisherName) {
		for(int i = 0; i < publishers.size(); i ++) {
			System.out.println(publishers.get(i).getPublisherName());
			if(publishers.get(i).getPublisherName().equals(publisherName)) {
				return publishers.get(i);
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
	public void modifyAuthor(String authorName, String newAuthorName) {
		for(int i = 0; i < authors.size(); i ++) {
			if(authors.get(i).getName().equals(authorName)) {
				authors.get(i).setName(newAuthorName);
			}
		}
	
	}
	public void modifyPublisherr(String publisherName, String newpublisherName) {
		for(int i = 0; i < authors.size(); i ++) {
			if(authors.get(i).getName().equals(publisherName)) {
				authors.get(i).setName(newpublisherName);
			}
		}
	}
	public void removePublisher(int tempPublisherID) {
		for(int i = 0; i < publishers.size(); i ++) {
			if(tempPublisherID == publishers.get(i).getPublisherID()) {
				publishers.remove(i);
				i--;
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
