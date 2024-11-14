package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class TestCases {
	String book_id;

	@Test(priority=1,dataProvider = "BooksData")
	public void add_book(String isbn,String aisle)
	{
		RestAssured.baseURI = "http://216.10.245.166";

		String AddBookResponse =given().body(payload.AddBookDetails(isbn,aisle)).when().post("/Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(AddBookResponse);
		 book_id = js.getString("ID");
		
		System.out.println("Book is added in the library");
		
		
	}
	
	@Test(priority=2)
	public void get_book_details()
	{
		RestAssured.baseURI = "http://216.10.245.166";
		
		String GetBookResponse = given().queryParam("ID", book_id).when().get("/Library/GetBook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1 = new JsonPath(GetBookResponse);
		String BookName = js1.getString("[0].book_name");
		
		Assert.assertEquals(BookName, "Rest Assured Automation");
		
		
		System.out.println("Post-book details are matching with the pre-book details");
	}
	
	@Test(priority=3)
	public void delete_book()
	{
		RestAssured.baseURI = "http://216.10.245.166";
		
		String DeleteBookResponse = given().body(payload.DeleteBook(book_id)).when().post("/Library/DeleteBook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(DeleteBookResponse);
		String msg = js.get("msg");
		
		Assert.assertEquals(msg, "book is successfully deleted");
		
		System.out.println("Book is deleted from the library");
	}
	
	@DataProvider(name="BooksData")
	public Object[][] getData()
	{
		return new Object[][] {{"dbfk","2345"}
		,{"womd","2346"}
		,{"odis","5686"}};
	}
	

}
