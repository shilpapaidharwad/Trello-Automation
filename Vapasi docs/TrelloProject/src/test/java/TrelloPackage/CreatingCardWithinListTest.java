package TrelloPackage;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreatingCardWithinListTest{

public String createCard(String listID){





    RestAssured.baseURI= "https://api.trello.com/1/";
    //String expectedName = "Retro";
    RequestSpecification requestspecification= given().queryParam( "key" ,  "0697ace29da135af1009cc535346c753")
            .queryParam("token", "a4ae068c9009fa3dede142965feb636b3d07cdf887f5366cdda15955a47011cc")
            .queryParam("idList",listID)

            .queryParam("name", "RetroCard").log().all()
            .contentType(ContentType.JSON);

    Response response=requestspecification.when().post("cards");
    System.out.println(response.body());
    response.then().statusCode(200)
            //response.then().body()
            .contentType(ContentType.JSON).
            extract()
            .body()
            .jsonPath();
    Map<String, ?> map= response.jsonPath().getMap("$");

    //map.containsKey();
    //System.out.println(map.get("id"));
    // System.out.println(map.get("name"));

    String Name= map.get("name").toString();
    String Id=map.get("id").toString();
    //Assert.assertEquals(Name,expectedName);
    System.out.println("Card Name is : "+ Name);
    System.out.println("Card Id is : " +Id);
    return Id;



}


}
