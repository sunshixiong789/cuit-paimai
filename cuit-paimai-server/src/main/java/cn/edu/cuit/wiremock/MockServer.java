package cn.edu.cuit.wiremock;

import com.github.tomakehurst.wiremock.client.WireMock;

/**
 * 使用wiremock伪造restful服务
 * @author sunshixiong
 * @date 2018/2/21 20:43
 */
public class MockServer {

    public static void main(String[] args) {

        WireMock.configureFor(8082);
        WireMock.removeAllMappings();
        WireMock.stubFor(WireMock
                .get(WireMock.urlEqualTo("/order/1"))
                .willReturn(WireMock
                        .aResponse()
                        .withBody("｛\"id\":1｝")
                        .withStatus(200)));
    }
}
