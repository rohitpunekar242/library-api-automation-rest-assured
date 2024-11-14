package files;

public class payload {

	
	public static String AddBookDetails(String isbn,String aisle)
	{
		return "{\r\n"
				+ "    \"name\": \"Rest Assured Automation\",\r\n"
				+ "    \"isbn\": \""+isbn+"\",\r\n"
				+ "    \"aisle\": \""+aisle+"\",\r\n"
				+ "    \"author\": \"Rohit P\"\r\n"
				+ "}";
	}
	
	public static String DeleteBook(String book_id)
	{
		return "{\r\n"
				+ "    \"ID\": \""+book_id+"\"\r\n"
				+ "}";
	}
}
