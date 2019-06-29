package entity;

public class Author {
	private int authorID;
	private String name;
	//private String lastName;
	public Author(int authorID, String name) {
		super();
		this.authorID = authorID;
		this.name = name;
	}
	public int getAuthorID() {
		return authorID;
	}
	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	
}
