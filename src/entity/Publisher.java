package entity;

public class Publisher {
	private long publisherID;
	private String publisherName;
	
	public Publisher(long publisherID, String publisherName) {
		super();
		this.publisherID = publisherID;
		this.publisherName = publisherName;
	}
	public long getPublisherID() {
		return publisherID;
	}
	public void setPublisherID(long publisherID) {
		this.publisherID = publisherID;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	
}
