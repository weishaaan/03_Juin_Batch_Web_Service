
import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Before;
import org.junit.Test;

import model.*;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import java.util.Map;
import javax.ws.rs.Path;
import static org.junit.Assert.assertEquals;

public class TestBatch{
    
    @Before
    public void setup(){
        RestAssuredUtil.setup();
    }

    @Test
    public void test_GetAllBatch(){
        Response res = get("/getAllBatch");
        assertEquals(200, res.getStatusCode());
        String json = res.asString();
        JsonPath jp = new JsonPath(json);

        assertEquals("07J",                         jp.get("CODE[0]"));
        assertEquals("Batch num 7 - extraction 7",  jp.get("NAME[0]"));
        assertEquals("USA",                         jp.get("DESCRIPTION[0]"));
        assertEquals("Fichier xls",                 jp.get("OUTPUT[0]"));
        assertEquals("refMora",                     jp.get("INPUT[0].PARAM[0].PARAMNAME"));
        assertEquals("",                            jp.get("INPUT[0].PARAM[0].DEFAULTVALUE"));
        assertEquals("Référence Mora",              jp.get("INPUT[0].PARAM[0].LABEL"));   
        assertEquals("date1",                       jp.get("INPUT[0].PARAM[1].PARAMNAME"));
        assertEquals("",                            jp.get("INPUT[0].PARAM[1].DEFAULTVALUE"));
        assertEquals("Début de la période",         jp.get("INPUT[0].PARAM[1].LABEL"));   
        assertEquals("date2",                       jp.get("INPUT[0].PARAM[2].PARAMNAME"));
        assertEquals("",                            jp.get("INPUT[0].PARAM[2].DEFAULTVALUE"));
        assertEquals("Fin de la période",           jp.get("INPUT[0].PARAM[2].LABEL"));   
              
        assertEquals("08M",                         jp.get("CODE[1]"));
        assertEquals("Batch num 8 - extraction 8",  jp.get("NAME[1]"));
        assertEquals("USA",                         jp.get("DESCRIPTION[1]"));
        assertEquals("Fichier xls",                 jp.get("OUTPUT[1]"));
        assertEquals("codeClient",                  jp.get("INPUT[1].PARAM[0].PARAMNAME"));
        assertEquals("",                            jp.get("INPUT[1].PARAM[0].DEFAULTVALUE"));
        assertEquals("Code client",                 jp.get("INPUT[1].PARAM[0].LABEL"));        
        
        assertEquals("09T",                         jp.get("CODE[2]"));
        assertEquals("Batch num 8 - extraction 8",  jp.get("NAME[2]"));
        assertEquals("USA",                         jp.get("DESCRIPTION[2]"));
        assertEquals("Fichier xls",                 jp.get("OUTPUT[2]"));
        assertEquals("codeClient",                  jp.get("INPUT[2].PARAM[0].PARAMNAME"));
        assertEquals("",                            jp.get("INPUT[2].PARAM[0].DEFAULTVALUE"));
        assertEquals("Code client",                 jp.get("INPUT[2].PARAM[0].LABEL"));     
        
        
    }
    @Test
    public void test_GetOneBatch_07J() {
        Response res = get("/getOneBatch/07J");
        assertEquals(200, res.getStatusCode());
        String json = res.asString();
        JsonPath jp = new JsonPath(json);

        assertEquals("07J",                        jp.get("CODE"));
        assertEquals("Batch num 7 - extraction 7", jp.get("NAME"));
        assertEquals("USA",                        jp.get("DESCRIPTION"));
        assertEquals("Fichier xls",                jp.get("OUTPUT"));
        assertEquals("refMora",                    jp.get("INPUT.PARAM[0].PARAMNAME"));
        assertEquals("",                           jp.get("INPUT.PARAM[0].DEFAULTVALUE"));
        assertEquals("Référence Mora",             jp.get("INPUT.PARAM[0].LABEL"));   
        assertEquals("date1",                      jp.get("INPUT.PARAM[1].PARAMNAME"));
        assertEquals("",                           jp.get("INPUT.PARAM[1].DEFAULTVALUE"));
        assertEquals("Début de la période",        jp.get("INPUT.PARAM[1].LABEL"));   
        assertEquals("date2",                      jp.get("INPUT.PARAM[2].PARAMNAME"));
        assertEquals("",                           jp.get("INPUT.PARAM[2].DEFAULTVALUE"));
        assertEquals("Fin de la période",          jp.get("INPUT.PARAM[2].LABEL"));   
    }
    //pass
    
    @Test
    public void test_GetOneBatch_08M() {
        expect().
        statusCode(200).
        body(
            "CODE",                             equalTo("08M"),
            "NAME",                             equalTo("Batch num 8 - extraction 8"),
            "DESCRIPTION",                      equalTo("USA"),
            "OUTPUT",                           equalTo("Fichier xls"),
            "INPUT.PARAM.get(0).PARAMNAME",     equalTo("codeClient"),
            "INPUT.PARAM.get(0).DEFAULTVALUE",  equalTo(""),
            "INPUT.PARAM.get(0).LABEL",         equalTo("Code client")
            ).
        when().
        get("/getOneBatch/08M");
    }
    
    //pass
    
    //Or we can use JsonPath
    @Test
    public void test_GetOneBatch_09T() {
        Response res = get("/getOneBatch/09T");
        assertEquals(200, res.getStatusCode());
        String json = res.asString();
        JsonPath jp = new JsonPath(json);
        assertEquals("09T",                         jp.get("CODE"));
        assertEquals("Batch num 8 - extraction 8",  jp.get("NAME"));
        assertEquals("USA",                         jp.get("DESCRIPTION"));
        assertEquals("Fichier xls",                 jp.get("OUTPUT"));
        assertEquals("codeClient",                  jp.get("INPUT.PARAM[0].PARAMNAME"));
        assertEquals("",                            jp.get("INPUT.PARAM[0].DEFAULTVALUE"));
        assertEquals("Code client",                 jp.get("INPUT.PARAM[0].LABEL"));              

    }

     
    /*JsonPath allows us to use Groovy closures to perform searches on the returned JSON structure.
    @Test
    public void testFindUsingGroovyClosure() {
        String json = get("/getOneBatch/07J").asString();
        JsonPath jp = new JsonPath(json);
        jp.setRoot("person");
        Map person = jp.get("find {e -> e.email =~ /test@/}");
        assertEquals("test@hascode.com", person.get("email"));
        assertEquals("Tim", person.get("firstName"));
        assertEquals("Testerman", person.get("lastName"));
    }        
    */       
            
    @Test
    public void test_Batch_not_found()
    {
        expect().
        statusCode(404).
        when().  
        get("/abc");
    }

   
}