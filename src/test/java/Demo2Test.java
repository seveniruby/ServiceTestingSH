



package com.testerhome.startupapi;

/**
 * Created by seveniruby on 2017/3/21.
 */

import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestRest {
    @Test
    public void demo() {
        useRelaxedHTTPSValidation();
        given()
                .queryParam("access_token", "oQFNVByA0rzxEWIEQN0KSX_zK9DrehfKcKoBlYJp7Y0ifjpEzXb05-M_KAwKaPnOn2Vrp8bVM9QMi8euknX-UokGENRonTQKJmttZx0jbUV2A_zjLOkJYtQUbBa8_O3a56irahnK0ntt1r0P8GTeq7hVOqZ5l_eiFzxfizMc8264k8lsPn_cY26PLp0VWqvp10Lm82isb0ESktBjHK-8jg")
                .queryParam("agentid", "1000005")
                .queryParam("msgtype", "text")
                .queryParam("toparty", "")
                .queryParam("safe", "0")
                .queryParam("content", "èªå¨åç¨ä¾ï¼æ¬¢è¿å¤§å®¶å å¥TesterHomeææ¯Workshop &lt;a href=\&quot;https://testerhome.com\&quot;&gt;TesterHomneç¤¾åºè®ºå&lt;/a&gt;")
                .queryParam("totag", "")
                .queryParam("touser", "@all")
                .when().log().all().post("https://qyapi.weixin.qq.com:443/cgi-bin/message/send?access_token=oQFNVByA0rzxEWIEQN0KSX_zK9DrehfKcKoBlYJp7Y0ifjpEzXb05-M_KAwKaPnOn2Vrp8bVM9QMi8euknX-UokGENRonTQKJmttZx0jbUV2A_zjLOkJYtQUbBa8_O3a56irahnK0ntt1r0P8GTeq7hVOqZ5l_eiFzxfizMc8264k8lsPn_cY26PLp0VWqvp10Lm82isb0ESktBjHK-8jg")
                .then().log().all()
                .statusCode(200)
        ;

    }
}
