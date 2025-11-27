package Payload;

public class payload {

    public static String addplace()
    {
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}\n";
    }

    public static String complexjson()
    {

        return "{\n" +
                "  \"dashboard\": {\n" +
                "    \"purchaseAmount\": 910,\n" +
                "    \"website\": \"rahulshettyacademy.com\"\n" +
                "  },\n" +
                "  \"courses\": [\n" +
                "    {\n" +
                "      \"title\": \"Selenium Python\",\n" +
                "      \"price\": 50,\n" +
                "      \"copies\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Cypress\",\n" +
                "      \"price\": 40,\n" +
                "      \"copies\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"RPA\",\n" +
                "      \"price\": 45,\n" +
                "      \"copies\": 10\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    public static String addbook(String isbn,String aisle)
    {
        return "{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\""+isbn+"\",\n" +
                "\"aisle\":\""+aisle+"\",\n" +
                "\"author\":\"John foe\"\n" +
                "}\n";
    }

    public static String jira()
    {
        return "{\n" +
                "    \"fields\": {\n" +
                "      \"project\": {\n" +
                "        \"key\": \"RES\"\n" +
                "      },\n" +
                "      \"summary\": \"Bug: Home button not working\",\n" +
                "      \"description\": {\n" +
                "        \"type\": \"doc\",\n" +
                "        \"version\": 1,\n" +
                "        \"content\": [\n" +
                "          {\n" +
                "            \"type\": \"paragraph\",\n" +
                "            \"content\": [\n" +
                "              {\n" +
                "                \"type\": \"text\",\n" +
                "                \"text\": \"Steps to Reproduce:\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"type\": \"paragraph\",\n" +
                "            \"content\": [\n" +
                "              {\n" +
                "                \"type\": \"text\",\n" +
                "                \"text\": \"1. Open login page\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"type\": \"paragraph\",\n" +
                "            \"content\": [\n" +
                "              {\n" +
                "                \"type\": \"text\",\n" +
                "                \"text\": \"2. Enter valid credentials\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"type\": \"paragraph\",\n" +
                "            \"content\": [\n" +
                "              {\n" +
                "                \"type\": \"text\",\n" +
                "                \"text\": \"3. Click Login\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"type\": \"paragraph\",\n" +
                "            \"content\": [\n" +
                "              {\n" +
                "                \"type\": \"text\",\n" +
                "                \"text\": \"Expected: User should be logged in\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"type\": \"paragraph\",\n" +
                "            \"content\": [\n" +
                "              {\n" +
                "                \"type\": \"text\",\n" +
                "                \"text\": \"Actual: Nothing happens\"\n" +
                "              }\n" +
                "            ]\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      \"issuetype\": {\n" +
                "        \"name\": \"Bug\"\n" +
                "      }\n" +
                "    }\n" +
                "  }";
    }

}

