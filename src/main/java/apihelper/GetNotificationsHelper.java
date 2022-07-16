package apihelper;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import urlhelper.BaseURI;

public class GetNotificationsHelper extends GeneralHelper{
	
	public JSONObject setRequestObject(String index, String count, String is_not_read) {
		JSONObject request = new JSONObject();
		request.put("index", index);
		request.put("count", count);
		request.put("is_not_read", is_not_read);
		return request;
	
	}
	
	public Response getApiResponse(String email, String password, String index, String count, String is_not_read) {
		JSONObject request = this.setRequestObject(index, count, is_not_read);
		
		LoginHelper login = new LoginHelper();
		String access_token = login.getAccessToken(email, password);
		
		BaseURI baseUri = new BaseURI();
		RestAssured.baseURI = baseUri.getBaseURI();
		
		Response response = RestAssured
				.given()
					.header("Authorization", "Bearer" + access_token)
					.body(request.toString())
					.contentType("application/json")
				.when()
					.get("api/notifications");
		
		return response;
	}
	
	public Response getApiResponse(String index, String count, String is_not_read) {
		JSONObject request = this.setRequestObject(index, count, is_not_read);
		
		BaseURI baseUri = new BaseURI();
		RestAssured.baseURI = baseUri.getBaseURI();
		
		Response response = RestAssured
				.given()
					.contentType("application/json")
					.body(request.toString())
				.when()
					.get("api/notifications");
		
		return response;
	}
}
