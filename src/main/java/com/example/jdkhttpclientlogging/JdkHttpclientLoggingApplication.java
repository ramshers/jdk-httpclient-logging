package com.example.jdkhttpclientlogging;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class JdkHttpclientLoggingApplication {

  @SneakyThrows
  public static void main(String[] args) {

    SpringApplication.run(JdkHttpclientLoggingApplication.class, args);


    log.info("default charset: " + Charset.defaultCharset());

    HttpRequest request = HttpRequest.newBuilder()
        .uri(new URI("https://postman-echo.com/get"))
        .version(HttpClient.Version.HTTP_2)
        .GET()
        .build();
    HttpResponse<String> response = HttpClient.newHttpClient()
        .send(request, HttpResponse.BodyHandlers.ofString());


    log.info("response: " + response);

  }

}
