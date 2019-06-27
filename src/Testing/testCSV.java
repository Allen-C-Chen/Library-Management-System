package Testing;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class testCSV {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<List<String>> rows = Arrays.asList(  
			    Arrays.asList("Jean", "author", "Java"),
			    Arrays.asList("David", "editor", "Python"),
			    Arrays.asList("Scott", "editor", "Node.js")
			);
		FileWriter csvWriter = new FileWriter("book.csv");  
		csvWriter.append("BookName");  
		csvWriter.append(",");  
		csvWriter.append("bookID");  
		csvWriter.append(",");  
		csvWriter.append("publisherID");  
		//csvWriter.append(",");  
		//csvWriter.append("authorID");  

		csvWriter.append("\n");

		for (List<String> rowData : rows) {  
		    csvWriter.append(String.join(",", rowData));
		    csvWriter.append("\n");
		}

		csvWriter.flush();  
		csvWriter.close();  
		
		//getting the data from file
		String row;
		BufferedReader csvReader = new BufferedReader(new FileReader("book.csv"));  
		while ((row = csvReader.readLine()) != null) {  
		    String[] data = row.split(",");
		    System.out.println(data[0] );
		    System.out.println(data[1] );
		    System.out.println(data[2] );
		    System.out.println( );
		}
		csvReader.close();  

	}

}
