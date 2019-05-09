package TrelloPackage;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;

public class BaseTest {

public String ID;
public  String listID;
public String idCard;
    @BeforeClass
    public void setUp() {

        //String baseURL= "https://api.trello.com/1";
        RestAssured.baseURI = "https://api.trello.com/1/";
        RequestSpecification requestspecification = given().queryParam("key", "0697ace29da135af1009cc535346c753")
                .queryParam("token", "a4ae068c9009fa3dede142965feb636b3d07cdf887f5366cdda15955a47011cc");

        //createBoard();


    }

    //String expectedName = "Retro";
@Test(priority = 0)
    public void createBoard() {


    CreateBoardTest createBoardTest=new CreateBoardTest();
    ID=createBoardTest.creatBoard();
    System.out.println("Board ID->:"+ID);
    }

    @Test(priority = 1)
    public void GetDefaultListsTest(){
        GetDefaultListsTest getDefaultListsTest=new GetDefaultListsTest();
        listID=getDefaultListsTest.gettingList(ID);

              }

    @Test(priority = 2)
public void createCard(){
        CreatingCardWithinListTest CC=new CreatingCardWithinListTest();
        idCard=CC.createCard(listID);

}

    @Test(priority = 3)
    public void updateCard(){
        UpdateCardTest updateCardTest=new UpdateCardTest();
        updateCardTest.updateCard(idCard);

    }

    @Test(priority = 4)
    public void updatedCardValue(){
        UpdateCardTest UT=new UpdateCardTest();
        UT.displayUpdatedInfo(idCard);

    }

}

    /*@AfterSuite
    public void tearDown()
    {
        deleteBoard();

    }
    public void deleteBoard()
    {
        RequestSpecification requestspecification = given()
                .queryParam("name", "Retro").log().all()
                .contentType(ContentType.JSON);
        Response response = requestspecification.when().delete(boardid);
        // System.out.println("Board Has been deleted");

    }


}*/