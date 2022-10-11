package com.spring.puzzle.others.resttemplate.example2;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class TestRestTemplate {


    public static void main(String[] args) {
        String url = "http://localhost:8080/hi?para1=1#2";
        HttpEntity<?> entity = new HttpEntity<>(null);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);

        System.out.println(response.getBody());

    }

    /**
     *通过这个例子我们可以知道，当 URL 中含有特殊字符时，一定要注意 URL 的组装方式，
     * 尤其是要区别下面这两种方式：
     * UriComponentsBuilder#fromHttpUrl
     * UriComponentsBuilder#fromUriString
     */

    public static void main2(String[] args) {
        String url = "http://localhost:8080/hi?para1=1#2";
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        URI uri = builder.build().encode().toUri();
        HttpEntity<?> entity = new HttpEntity<>(null);

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET,entity,String.class);

        System.out.println(response.getBody());
    }

}
