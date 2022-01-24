package reqresAPI.tests;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;

import java.util.List;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;

public class NewAPITests {
	@Test
	public void get_single_user_returns_200_with_employee_id() {
		given().		
		when().
			get("/users/{id}", 2).then().
				statusCode(200).
				body("data.email", equalTo("janet.weaver@reqres.in"));
	}

	@Test 
	public void post_login_success_returns_200_with_token() {
		
		String requestBody = "{\"email\":\"eve.holt@reqres.in\"," +
						 	 "\"password\":\"cityslicka\"}";

		given().
			contentType(ContentType.JSON).body(requestBody).
		post("/login").
		then().
			statusCode(200).
			body("token", equalTo("QpwL5tke4Pnpja7X4"));
	}

	@Test
	public void delete_success_returns_204() {
		Response response = given().
							when().
								delete("/users/2").
							then().
								extract().response();
		
		//HTTP 204 Response Code Definition: No Content, server has fulfilled request
		//successfully and the response payload body contains no additional content		
		Assert.assertEquals(response.statusCode(), 204);
	}
	
	@Test 
	public void patch_morpheus_success() {
		String requestBody = "{\"name\":\"morpheus2\"}";
		
		given().
			contentType(ContentType.JSON).body(requestBody).
		patch("/users/2").
		then().
			statusCode(200).
			body("name", equalTo("morpheus2"),
				 "updatedAt", greaterThan("2022-01-21T21:34:20.533Z"));		
	}
	
	@Test
	public void put_morpheus_success() {
		String requestBody = "{\"name\":\"morpheus2\"," +
			 	 "\"job\":\"zion resident\"}";
		
		given().
			contentType(ContentType.JSON).body(requestBody).
		put("/users/2").
		then().
			statusCode(200).
			body("name", equalTo("morpheus2"), 
				 "updatedAt", greaterThan("2022-01-21T21:34:20.533Z"));		
	}
	
	@Test 
	public void get_single_user_and_deserialize() {
		
		String testName = "Janet";
		UserData testUserObject = new UserData();
		
		JsonPath jsonPath = given().
							when().
								get("/users/{id}", 2).
							then().
								statusCode(200).extract().body().jsonPath();
		
		testUserObject = jsonPath.getObject("data", UserData.class);		
		
		Assert.assertEquals(testUserObject.getFirst_name(), testName);
	}
	

	@Test 
	public void get_user_list_and_deserialize() {
		int expectedListSize = 6;
		String expectedName = "Tobias";
		
		JsonPath jsonPath = given().
							when().
								get("/users/?page=2").
							then().
								statusCode(200).extract().body().jsonPath();
		
		List<UserData> userDataList = jsonPath.getList("data", UserData.class);
		UserData testUserObject = userDataList.get(2);
		
		Assert.assertEquals(userDataList.size(), expectedListSize);
		Assert.assertEquals(testUserObject.getFirst_name(), expectedName);
	}
	
    @BeforeTest
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
    }	
}

