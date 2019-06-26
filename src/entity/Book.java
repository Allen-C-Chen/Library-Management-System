package entity;

public class Book {
	private long bookID;
	private String bookName;
	private long authorID;
	private long publisherID;
	

	public Book(long bookID, String bookName, long authorID, long publisherID) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.authorID = authorID;
		this.publisherID = publisherID;
	}
	public long getBookID() {
		return bookID;
	}
	public void setBookID(long bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public long getAuthorID() {
		return authorID;
	}
	public void setAuthorID(long authorID) {
		this.authorID = authorID;
	}
	public long getPublisherID() {
		return publisherID;
	}
	public void setPublisherID(long publisherID) {
		this.publisherID = publisherID;
	}


	
}
