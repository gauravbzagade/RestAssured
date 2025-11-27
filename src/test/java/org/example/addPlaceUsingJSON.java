package org.example;

import io.restassured.RestAssured;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class addPlaceUsingJSON {

    @Test
    public static void addplaceusingjson() throws IOException {

        RestAssured.baseURI = "http://216.10.245.166";

        String payload = new String(Files.readAllBytes(Paths.get("src/test/java/Payload/addplace.json")));
        JSONArray inputpayload = new JSONArray(payload);

        for (int i = 0; i < inputpayload.length(); i++) {

            JSONObject jsonbody = inputpayload.getJSONObject(i);
            String addBookResponse = given().log().all().body(jsonbody.toString()).
                    when().post("Library/Addbook.php").
                    then().log().all().assertThat().statusCode(200).extract().response().asString();
            System.out.println(addBookResponse);

        }


    }
}
