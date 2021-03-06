package apihelper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import urlhelper.BaseURI;

public class InfoAuctionHelper extends GeneralHelper{

	public Response getApiResponse(String email, String password, String auctionId) {
		LoginHelper login = new LoginHelper();
		String access_token = login.getAccessToken(email, password);
		
		BaseURI baseUri = new BaseURI();
		RestAssured.baseURI = baseUri.getBaseURI();;
		
		Response response = RestAssured
				.given()
					.header("Authorization", "Bearer" + access_token)
				.when()
					.get("api/auctions/info" + auctionId);
		return response;
	}
	
	public Response getApiResponse(String auctionId) {
		BaseURI baseUri = new BaseURI();
		RestAssured.baseURI = baseUri.getBaseURI();;
		
		Response response = RestAssured
				.given()
				.when()
					.get("api/auctions/info" + auctionId);
		return response;
	}
}
