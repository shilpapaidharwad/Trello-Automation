package TrelloPackage;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UpdateCardTest {

    public void updateCard(String idCard)
    {

        System.out.println("Id Card:"+idCard);

        RestAssured.baseURI= "https://api.trello.com/1/";
        //String expectedName = "Retro";
        RequestSpecification requestspecification= given().queryParam( "key" ,  "0697ace29da135af1009cc535346c753")
                .queryParam("token", "a4ae068c9009fa3dede142965feb636b3d07cdf887f5366cdda15955a47011cc")
                .pathParam("idCard", idCard )
                .queryParam("desc",  "Updated Card Information")

                .queryParam("name", "RetroCard").log().all()
                .contentType(ContentType.JSON);

        Response response=requestspecification.when().put("cards/{idCard}");
        System.out.println(response.body());
        response.then().statusCode(200)
                //response.then().body()
                .contentType(ContentType.JSON).
                extract()
                .body()
                .jsonPath();

    }

    public void displayUpdatedInfo(String idCard)
    {


        RequestSpecification requestspecification= given().queryParam( "key" ,  "0697ace29da135af1009cc535346c753")
                .queryParam("token", "a4ae068c9009fa3dede142965feb636b3d07cdf887f5366cdda15955a47011cc")
                .pathParam("idCard", idCard )
                .contentType(ContentType.JSON);

        Response response=requestspecification.when().put("/cards/{idCard}/desc");
        System.out.println(response.body());

    }

    }






