package com.spring.puzzle.others.resttemplate.example1;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class TestRestTemplate {


    public static void main(String[] args) {
        RestTemplate template = new RestTemplate();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("para1", "001");
        paramMap.put("para2", "002");

        /**
         *只有当我们发送的 Body 是 MultiValueMap 才能使用表
         * 单来提交。学到这里，你可能会豁然开朗。原来使用 RestTemplate 提交表单必须是
         * MultiValueMap，而我们案例定义的就是普通的 HashMap，最终是按请求 Body 的方式
         * 发送出去的。
         */


/*        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("para1", "001");
        paramMap.add("para2", "002");*/

        String url = "http://localhost:8080/hi";

        String result = template.postForObject(url, paramMap, String.class);
        System.out.println(result);

    }

}
