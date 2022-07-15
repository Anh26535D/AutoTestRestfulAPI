package apihelper;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import urlhelper.BaseURI;

public class EditAuctionHelper extends GeneralHelper {

	public JSONObject setRequestObject(String category_id, String start_date, String end_date, String title_ni) {
		JSONObject request = new JSONObject();
		request.put("category_id", category_id);
		request.put("start_date", start_date);
		request.put("end_date", end_date);
		request.put("title_ni", title_ni);
		return request;
	}

//Having log in
	public Response getApiResponse(String email, String password, String category_id, String start_date, String end_date, String title_ni, String auctionId) { 
		LoginHelper login = new LoginHelper();
		String access_token = login.getAccessToken(email, password);
		
		JSONObject request = this.setRequestObject(category_id, start_date, end_date, title_ni);
		
		BaseURI baseUri = new BaseURI();
		RestAssured.baseURI = baseUri.getBaseURI();
		
		Response response = RestAssured
				.given()
					.header("Authorization", "Bearer" + access_token)
					.contentType("application/json")
					.body(request.toString())
				.when()
					.post("api/auctions/edit" + auctionId);
		return response;
	}
//Not log in	
	public Response getEditAuctionResponse(String category_id, String start_date, String end_date, String title_ni, String auctionId) { 
		JSONObject request = this.setRequestObject(category_id, start_date, end_date, title_ni);
		
		BaseURI baseUri = new BaseURI();
		RestAssured.baseURI = baseUri.getBaseURI();
		
		Response firstResponse = RestAssured
				.given()
					.header("Content-Type", "application/json")
					.body(request.toString())
		            .redirects().follow(false)
		        .expect().statusCode(302)
				.when()
					.post("api/auctions/edit" + auctionId);
		String redirectUrl = firstResponse.getHeader("Location");
		Response response = RestAssured
		        .given()
		        	.header("Content-Type", "application/json")
		        .when().
		            get(redirectUrl);
		return response;
	}
}
