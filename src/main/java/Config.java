import static io.restassured.RestAssured.given;

public class Config {
    public String corpId="wwd6da61649bd66fea";
    public String contactSecret="C7uGOrNyxWWzwBsUyWEbLdbZBDrc71PNOhyQ_YYPhts";
    public Integer agentId=1000008;
    public String agentSecret="8M4gp1GknzgQrGxJzFPIA2ngSxnhfij-ecERlID2bGQ";
    public String token;

    static Config config;
    public static Config getInstance(){
        if(config==null){
            config=new Config();
            config.token=config.getToken();

        }
        return config;
    }

    private String getToken(){
        return given()
                .log().all()
                .queryParam("corpid", Config.getInstance().corpId)
                .queryParam("corpsecret", Config.getInstance().agentSecret)
        .when()
                .get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
        .then()
                .log().all()
                .statusCode(200)
        .extract().path("access_token");
    }
}
