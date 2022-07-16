package apihelper;

import io.restassured.RestAssured;
import org.json.JSONObject;
import io.restassured.response.Response;
import urlhelper.BaseURI;

public class EditAccountHelper extends GeneralHelper{

	public JSONObject setRequestObject(String email, String address, String name, String phone, String avatar) {		
		JSONObject req = new JSONObject();
		req.put("email", email);
		req.put("address", address);
		req.put("name", name);
		req.put("phone", phone);
		req.put("avatar", avatar);
		return req;
	}
	
	public Response getApiResponse(String email, String password, String address, String name, String phone, String avatar) {
		LoginHelper login = new LoginHelper();
		String access_token = login.getAccessToken(email, password);
		
		JSONObject request = this.setRequestObject(email, address, name, phone, avatar);
		
		BaseURI baseUri = new BaseURI();
		RestAssured.baseURI = baseUri.getBaseURI();

		Response response = RestAssured
				.given()
					.header("Authorization", "Bearer" + access_token)
					.contentType("application/json")
					.body(request.toString())
				.when()
					.post("api/edit");
		
		return response;
	}
	
	public Response getApiResponse(String email, String address, String name, String phone, String avatar) {
	
		JSONObject request = this.setRequestObject(email, address, name, phone, avatar);
		
		BaseURI baseUri = new BaseURI();
		RestAssured.baseURI = baseUri.getBaseURI();

		Response firstResponse = RestAssured
				.given()
					.header("Content-Type", "application/json")
					.body(request.toString())
		            .redirects().follow(false)
		        .expect().statusCode(302)
				.when()
					.post("api/edit");
		String redirectUrl = firstResponse.getHeader("Location");
		Response response = RestAssured
		        .given()
		        	.header("Content-Type", "application/json")
		        .when().
		            get(redirectUrl);
		return response;
	}
}
