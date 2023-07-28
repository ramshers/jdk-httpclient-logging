package com.example.jdkhttpclientlogging;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
@Slf4j
public class JdkHttpclientLoggingApplicationTests {

  @Test
  void contextLoads() throws URISyntaxException, IOException, InterruptedException {

    System.err.println("default charset: " + Charset.defaultCharset());

    HttpRequest request = HttpRequest.newBuilder()
        .uri(new URI("https://postman-echo.com/get"))
        .version(HttpClient.Version.HTTP_2)
        .GET()
        .build();
    HttpResponse<String> response = HttpClient.newHttpClient()
        .send(request, HttpResponse.BodyHandlers.ofString());


    System.err.println("response: " + response);

    Assert.notNull("a");

  }

}
