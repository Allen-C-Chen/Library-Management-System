package entity;

public class Author {
	private long authorID;
	private String name;
	//private String lastName;
	public Author(long authorID, String name) {
		super();
		this.authorID = authorID;
		this.name = name;
	}
	
	public long getAuthorID() {
		return authorID;
	}

	public void setAuthorID(long authorID) {
		this.authorID = authorID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
