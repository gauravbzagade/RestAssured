package org.example;

import Payload.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class JiraAPI {

    @Test
    public static void issuecreater() throws InterruptedException {


        RestAssured.baseURI = "https://zagadegaurav77.atlassian.net";

        String email = "zagadegaurav77@gmail.com";
        String apiToken = "ATATT3xFfGF0W41b4s8sgqupsa_3U4uzd6K9RhCuELGW4XTK0wffiLwYtAgMjOrThuWWZc_K3ChZoB6FGi" +
                "3WUeHvhmwVhE8nDs-rPl_GAueGCtAYgxIfASv6oTKg8-UQmMYJ94MoOhGnh7zPmex-4rP4tGb74daOK3_9QTscEIB-TMJp2RBZyyw=1D85DA2A";

        String authValue = "Basic " +
                java.util.Base64.getEncoder().encodeToString((email + ":" + apiToken).getBytes());

        String response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", authValue)
                .body(payload.jira())
                .when().post("/rest/api/3/issue")
                .then().log().all()
                .statusCode(201)
                .extract().asString();

        JsonPath Js = new JsonPath(response);
        String Key = Js.getString("key");

        System.out.println("✅ Issue Created: " + Key);


        //add attachement

        given().header("X-Atlassian-Token", "no-check").header("Accept", "application/json").
                header("Authorization", authValue).multiPart("file", new File("C:\\Users\\Ashwini\\Downloads\\Gaurav_Zagade_QA_4+Yrs.pdf")).
                when().post("/rest/api/3/issue/" + Key + "/attachments")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();


        //delete ticket
        System.out.println("⏳ Waiting 10 seconds before delete...");
        Thread.sleep(10000);


        given().log().all()
                .header("Authorization", authValue)
                .header("Accept", "application/json")
                .when()
                .delete("/rest/api/3/issue/" + Key)   // ✅ DELETE endpoint
                .then().log().all()
                .assertThat().statusCode(204);  // ✅ Jira returns 204 No Content

        System.out.println("✅ Issue Deleted: " + Key);


    }
}
