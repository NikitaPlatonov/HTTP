package ru.netology;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().setDefaultRequestConfig(RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(30000).setRedirectsEnabled(false).build()).build();
        HttpGet request = new HttpGet("https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats");
        CloseableHttpResponse response = httpClient.execute(request);
        String body = new String(response.getEntity().getContent().readAllBytes(), StandardCharsets.UTF_8);
        readJsonFormatToJavaObject(body);
    }

    public static void readJsonFormatToJavaObject(String body) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<CatFacts> catFacts = mapper.readValue(body, new TypeReference<List<CatFacts>>() {
        });

        catFacts.removeIf(facts -> facts.getUpvotes() == 0);

        System.out.println(catFacts.size());

        catFacts.forEach(System.out::println);


    }
}