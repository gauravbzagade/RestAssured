package resusablemethods;

import io.restassured.path.json.JsonPath;

public class jsonparse {


    public static JsonPath jsontparsing(String response)
    {
        JsonPath js=new JsonPath(response);
                return js;
    }
}
