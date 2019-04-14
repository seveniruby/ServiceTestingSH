import com.github.mustachejava.DefaultMustacheFactory;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class Message {
    public Response send(HashMap<String, Object> data){
        //todo: xxx
        //return json
        return given().log().all()
                .queryParam("access_token", Config.getInstance().token)
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("https://qyapi.weixin.qq.com/cgi-bin/message/send")
                .then()
                .log().all().extract().response();
    }

    public Response send(String data){
        //todo: xxx
        //return json
        return given().log().all()
                .queryParam("access_token", Config.getInstance().token)
                .contentType(ContentType.JSON)
                .body(data)
                .when()
                .post("https://qyapi.weixin.qq.com/cgi-bin/message/send")
                .then()
                .log().all().extract().response();
    }


    public Response send(String to, String msg, Integer agentId){
        HashMap<String, Object> data=new HashMap<String, Object>();
        data.put("to", to);
        data.put("msg", msg);
        data.put("agentId", agentId);
        String body=template("data/message.json", data);

        return send(body);
    }
    String template(String path, HashMap<String, Object> data) {
        Writer writer = new StringWriter();
        new DefaultMustacheFactory()
                .compile(path).execute(writer, data);
        return writer.toString();
    }

}





