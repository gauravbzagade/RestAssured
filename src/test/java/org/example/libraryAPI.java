package org.example;

import Payload.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resusablemethods.jsonparse;

import static io.restassured.RestAssured.given;

public class libraryAPI {

    @Test(dataProvider ="dataprovider" )
    public static void addbook(String isbn, String aisle) {

        //add book

        RestAssured.baseURI = "http://216.10.245.166";
        String addbookresponse = given().log().all().header("content-type", "application/json").body(payload.addbook(isbn, aisle))
                .when().post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();
        System.out.println(addbookresponse);
        JsonPath jso = jsonparse.jsontparsing(addbookresponse);
        String id = jso.getString("ID");
        System.out.println(id);

//        //get book by id
//
//        String getbook=given().queryParam("ID",id).log().all().when().get("Library/GetBook.php")
//                .then().assertThat().statusCode(200).extract().response().asString();
//
//        System.out.println(getbook);


    }

    @DataProvider(name="dataprovider")
    public static Object[][] data(){

      return  new Object[][]{{"fgfgf","2234"},{"fdgvfg","23234"},{"dgfgfg","2324"},};
    }
}

