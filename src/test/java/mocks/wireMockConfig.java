package mocks;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class wireMockConfig {
    @Bean
    public WireMockServer wireMockServer (@Value("${wireMockPort}") int wireMockPort){
        WireMockServer wireMock = new WireMockServer(wireMockPort);
        wireMock.start();

        return wireMock;
    }
}
