import com.jayway.restassured.RestAssured;

/**
 * Isolate set-up of REST-assured here in order not to have to change it
 * everywhere else.
 */
public class RestAssuredUtil
{
    public static final void setup()
    {
        RestAssured.baseURI  = "http://localhost";
        RestAssured.port     =  8080;
        RestAssured.basePath = "/BatchMvnWeb/webresources/home";
    }
}

