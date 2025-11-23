package org.example;

import Payload.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class addPlaceApi {
    public static void main(String[] args) {
        // validate if add place API is working as expected

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given().log().all().queryParam("key", "qaclick123").body(payload.addplace()).when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP")).extract().response().asString();


        JsonPath js = new JsonPath(response);
        String palceid = js.getString("place_id");
        System.out.println(palceid);

        //get location api

        String getplaceapi = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", palceid).when().get("/maps/api/place/get/json")
                .then().log().all().extract().asString();

        System.out.println(getplaceapi);


        //update place api

        given().log().all().queryParam("key", "qaclick123").queryParam("getplaceapi", palceid).body("{\n" +
                        "\"place_id\":\"" + palceid + "\",\n" +
                        "\"address\":\"70 winter walk, USA\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n").when().put("/maps/api/place/update/json")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();


        //delete place api

       String deleterResponse= given().log().all().queryParam("key","qaclick123").body("{\n" +
                       "    \"place_id\":\""+palceid+"\"\n" +
                       "}\n").when().post("/maps/api/place/delete/json").
                then().log().all().assertThat().statusCode(200).extract().response().asString();

       JsonPath js1=new JsonPath(deleterResponse);
       js1.getString("status").equalsIgnoreCase("OK");

    }
}
