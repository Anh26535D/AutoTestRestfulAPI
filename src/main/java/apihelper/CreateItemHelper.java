package apihelper;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import urlhelper.BaseURI;

public class CreateItemHelper extends GeneralHelper {

	public JSONObject setRequestObject(String name, String starting_price, String brand_id, String description, String series, String images) {		
		JSONObject request = new JSONObject();
		request.put("name", name);
		request.put("starting_price", starting_price);
		request.put("brand_id", brand_id);
		request.put("description", description);
		request.put("series", series);
		request.put("images", images);
		return request;
	}
	
	public JSONObject setRequestObject(String name, String starting_price, String brand_id, String description) {		
		JSONObject request = new JSONObject();
		request.put("name", name);
		request.put("starting_price", starting_price);
		request.put("brand_id", brand_id);
		request.put("description", description);
		return request;
	}

	public Response getApiResponse(String email, String password, String name, String starting_price, String brand_id, String description, String series, String images, String auctionId) {
		JSONObject request = this.setRequestObject(name,starting_price,brand_id,description,series, images);

		BaseURI baseUri = new BaseURI();
		RestAssured.baseURI = baseUri.getBaseURI();

		LoginHelper login = new LoginHelper();
		String access_token = login.getAccessToken(email, password);

		Response response = RestAssured
				.given()
					.header("Authorization", "Bearer" + access_token)
					.contentType("application/json")
					.body(request.toString())
				.when()
					.post("api/items/create" + auctionId);
		return response;
	}

	public Response getApiResponse(String name, String starting_price, String brand_id, String description, String series, String images, String auctionId) {
		JSONObject request = this.setRequestObject(name,starting_price,brand_id,description,series, images);

		BaseURI baseUri = new BaseURI();
		RestAssured.baseURI = baseUri.getBaseURI();

		Response firstResponse = RestAssured
				.given()
					.header("Content-Type", "application/json")
					.body(request.toString())
		            .redirects().follow(false)
				.when()
					.post("api/items/create" + auctionId);

		String redirectUrl = firstResponse.getHeader("Location");
		Response response = RestAssured
		        .given()
		        	.header("Content-Type", "application/json")
		        .when().
		            get(redirectUrl);
		return response;
	}
}
