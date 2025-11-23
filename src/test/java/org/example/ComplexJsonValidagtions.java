package org.example;

import Payload.payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import resusablemethods.jsonparse;

public class ComplexJsonValidagtions {

    @Test
    public static void jasonvalidation() {
        JsonPath JS = jsonparse.jsontparsing(payload.complexjson());
        //1. Print number of courses returned by API
        int noofcourses = JS.getInt("courses.size()");
        System.out.println(noofcourses);

        //2. Print purchase amount

        System.out.println(JS.getInt("dashboard.purchaseAmount"));

        //3. Print title of first course
        System.out.println(JS.getString("courses[0].title"));

        //4. print all course titles and their respective prices

        for (int i = 0; i < noofcourses; i++) {
            String alltiles = JS.getString("courses[" + i + "].title");
            System.out.println(alltiles);
            System.out.println(JS.getInt("courses[" + i + "].price"));

        }
        //5. print no of copies sold by RPA course

        for (int j = 0; j < noofcourses; j++) {
            if (JS.getString("courses[" + j + "].title").equalsIgnoreCase("RPA")) {

                int RPAcopies = JS.getInt("courses[" + j + "].copies");
                System.out.println(RPAcopies);
                break;
            }
        }
        //6. Verify if sum of all the courses prices matches with purchase amount
        int sum = 0;

        for (int k = 0; k < noofcourses; k++) {

            int price = JS.getInt("courses[" + k + "].price");
            int copies = JS.getInt("courses[" + k + "].copies");
            int totalprice = price * copies;
            sum=sum+totalprice;

        }

        System.out.println(sum);
        Assert.assertEquals(sum,910);


    }

}
