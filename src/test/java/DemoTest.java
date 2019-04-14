import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoTest {

    @Test
    void demo(){
        assertTrue(false);
    }

    @Test
    void sendMessage(){
        HashMap<String, Object> data=new HashMap<String, Object>();
        data.put("touser", "@all");
        data.put("toparty", "");
        data.put("totag", "");
        data.put("msgtype", "text");
        data.put("agentid", Config.getInstance().agentId);
        data.put("safe", 0);

        HashMap<String, Object> content=new HashMap<String, Object>();
        content.put("content", "欢迎大家加入TesterHome技术Workshop <a href=\\\"https://testerhome.com\\\">TesterHomne社区论坛</a>");
        data.put("text", content);
        given().log().all()
                .queryParam("access_token", Config.getInstance().token)
                .contentType(ContentType.JSON)
                .body(data)
        .when().post("https://qyapi.weixin.qq.com/cgi-bin/message/send")
        .then().log().all().statusCode(200).body(containsString("ok"));
    }


    @Test
    void post(){
        given().
                param("key1", "value1").
                param("key2", "value2").
                when().
                post("/somewhere").
                then().
                body(containsString("OK"));
    }


}
