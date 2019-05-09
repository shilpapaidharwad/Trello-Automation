package TrelloPackage;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class CreateBoardTest {
   // @Test
    public String creatBoard()
    {

       //String baseURL= "https://api.trello.com/1";
        RestAssured.baseURI= "https://api.trello.com/1/";
        String expectedName = "Retro";
        RequestSpecification requestspecification= given().queryParam( "key" ,  "0697ace29da135af1009cc535346c753")
               .queryParam("token", "a4ae068c9009fa3dede142965feb636b3d07cdf887f5366cdda15955a47011cc")

                .queryParam("name", "Retro").log().all()
                .contentType(ContentType.JSON);

               Response response=requestspecification.when().post("boards");
        System.out.println(response.body());
        response.then().statusCode(200)
        //response.then().body()
                .contentType(ContentType.JSON)
                .body(matchesJsonSchemaInClasspath("Schema.json"))
                .extract()
                .response();

               // .log();
        Map<String, ?> map= response.jsonPath().getMap("$");

       //map.containsKey();
       //System.out.println(map.get("id"));
       // System.out.println(map.get("name"));

        String Name= map.get("name").toString();
        String ID=map.get("id").toString();
        //Assert.assertEquals(Name,expectedName);
        System.out.println("The Name is "+ Name);
        //System.out.println("Id is" +ID);




               // JSONObject jsonobject=new JSONObject();

    return ID;
    }




}
