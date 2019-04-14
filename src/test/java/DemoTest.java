import com.github.mustachejava.DefaultMustacheFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoTest {

    @Test
    void demo(){
        assertTrue(false);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "测试中文",
            "おはようございます",
            "<script>alert(77)</script>",
            "欢迎大家加入TesterHome技术Workshop <a href=\"https://testerhome.com\">TesterHomne社区论坛</a>" })
    void sendMessage(String msg){
        HashMap<String, Object> data=new HashMap<String, Object>();
        data.put("touser", "@all");
        data.put("toparty", "");
        data.put("totag", "");
        data.put("msgtype", "text");
        data.put("agentid", Config.getInstance().agentId);
        data.put("safe", 0);

        HashMap<String, Object> content=new HashMap<String, Object>();
        content.put("content", msg);
        data.put("text", content);
        Message message=new Message();
        message.send(data).then().body("errcode", equalTo(0));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "测试中文",
            "おはようございます",
            "<script>alert(77)</script>",
            "欢迎大家加入TesterHome技术Workshop <a href=\"https://testerhome.com\">TesterHomne社区论坛</a>" })
    void sendMessage2(String msg){
        HashMap<String, Object> data=new HashMap<String, Object>();
        data.put("touser", "@all");
        data.put("toparty", "");
        data.put("totag", "");
        data.put("msgtype", "text");
        data.put("agentid", Config.getInstance().agentId);
        data.put("safe", 0);

        HashMap<String, Object> content=new HashMap<String, Object>();
        content.put("content", msg);
        data.put("text", content);
        new Message().send(data);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "测试中文",
            "おはようございます",
            "<script>alert(77)</script>",
            "欢迎大家加入TesterHome技术Workshop <a href=\"https://testerhome.com\">TesterHomne社区论坛</a>" })
    void sendMessage3(String msg){
        Message message=new Message();
        message.send("@all", msg, Config.getInstance().agentId)
                .then().body("errcode", equalTo(0));
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
