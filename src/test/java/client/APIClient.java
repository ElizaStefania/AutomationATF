package client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIClient {

    //Clasa in care configuram clientul
    //Facem o metoda in care setam configurarile de client
    //Facem o metota in care setam actiunea pe care o face clientul

    public String baseURI = "https://demoqa.com";

    public Response persormRequest(String requestType, RequestSpecification requestSpecification, String endPoint){
        switch (requestType){
            case "POST":
                return prepareClient(requestSpecification).post(endPoint);
            case "GET":
                return prepareClient(requestSpecification).get(endPoint);
            case "DELETE":
               return  prepareClient(requestSpecification).delete(endPoint);
        }
        return null;
    }

    public RequestSpecification prepareClient(RequestSpecification requestSpecification){
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.baseUri(baseURI);
        return requestSpecification;
    }
}
