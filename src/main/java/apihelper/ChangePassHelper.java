package apihelper;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import urlhelper.BaseURI;

public class ChangePassHelper extends GeneralHelper{
	public JSONObject setRequestObject(String old_pass, String new_pass, String re_pass) {
		JSONObject request = new JSONObject();
		request.put("old_pass", old_pass);
		request.put("new_pass", new_pass);
		request.put("re_pass", re_pass);
		return request;
	}
	
	public Response getApiResponse(String email, String password, String old_pass, String new_pass, String re_pass) {
		LoginHelper login = new LoginHelper();
		String access_token = login.getAccessToken(email, password);
		
		JSONObject request = this.setRequestObject(old_pass, new_pass, re_pass);
		
		BaseURI baseUri = new BaseURI();
		RestAssured.baseURI = baseUri.getBaseURI();
		
		Response response = RestAssured
				.given()
					.header("Authorization", "Bearer" + access_token)
					.contentType("application/json")
					.body(request.toString())
				.when()
					.post("api/changepass");
		return response;	
	}
	
	public Response getApiResponse(String old_pass, String new_pass, String re_pass) {	
		JSONObject request = this.setRequestObject(old_pass, new_pass, re_pass);
		
		BaseURI baseUri = new BaseURI();
		RestAssured.baseURI = baseUri.getBaseURI();
		
		Response firstResponse = RestAssured
				.given()
					.header("Content-Type", "application/json")
					.body(request.toString())
		            .redirects().follow(false)
		        .expect().statusCode(302)
				.when()
					.post("api/changepass");
		String redirectUrl = firstResponse.getHeader("Location");
		Response response = RestAssured
		        .given()
		        	.header("Content-Type", "application/json")
		        .when().
		            get(redirectUrl);
		return response;	
	}
}
