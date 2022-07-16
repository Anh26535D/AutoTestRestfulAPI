package apihelper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import urlhelper.BaseURI;

public class GetListBrandsHelper extends GeneralHelper {

	public Response getApiResponse() {

		BaseURI baseUri = new BaseURI();
		RestAssured.baseURI = baseUri.getBaseURI();
		
		Response response = RestAssured
				.given()
				.when()
					.get("api/brands");
		
		return response;
	}
}
