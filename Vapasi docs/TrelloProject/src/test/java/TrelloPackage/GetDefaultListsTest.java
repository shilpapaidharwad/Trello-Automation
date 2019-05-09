package TrelloPackage;

import com.google.gson.JsonArray;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;

public class GetDefaultListsTest {

    public String gettingList(String ID) {

        String listid = null;
//System.out.println("CREATE LIST ID:"+ID);
        String str;
        RestAssured.baseURI = "https://api.trello.com/1/";
        RequestSpecification requestspecification = given().queryParam("key", "0697ace29da135af1009cc535346c753")
                .queryParam("token", "a4ae068c9009fa3dede142965feb636b3d07cdf887f5366cdda15955a47011cc")
                .contentType(ContentType.JSON)
                .body("name")
                .pathParam("idBoard", ID);


        Response response = requestspecification.when().get("boards/{idBoard}/lists");
    String temp=response.asString();
        //System.out.println("LIST ID:"+temp);

        JsonPath jp=response.jsonPath();
        List<String> listID = jp.getList("id");
        List<String> name = jp.getList("name");
        for(String lstID:listID){
            System.out.println("ListID : "+lstID);
            System.out.println("");
            listid=lstID;

        }
        //System.out.println(listid);
        for(String lstID:name){
            System.out.println("LIST Name : "+lstID);

        }


return listid;







    }


}




