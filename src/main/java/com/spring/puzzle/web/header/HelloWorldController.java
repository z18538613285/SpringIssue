package com.spring.puzzle.web.header;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@Slf4j
public class HelloWorldController {

    /**
     wrong to use map to received the headers, cant got the multivalue for one header:
     GET http://localhost:8080/hi1
     myheader: h1
     myheader: h2

     要完整接收到所有的 Header，不能直接
     使用 Map 而应该使用 MultiValueMap。

     另外假
     设我们定义的是 HttpHeaders（也是一种 MultiValueMap），我们会直接创建一个
     HttpHeaders 来存储所有的 Header
    */
    @RequestMapping(path = "/hi1", method = RequestMethod.GET)
    public String hi1(@RequestHeader() HttpHeaders map){
        return map.toString();
    };


    /**
     header's key case sensitive issue, MultiValueMap should be case sensitive.
     GET http://localhost:8080/hi2
     myheader: myheadervalue

     存取 Map 的 Header 是没有忽略大小写的
     从 Map 中获取的 Header 也没有忽略大小写

     在实际使用时，虽然 HTTP 协议规范可以忽略大小写，但
     是不是所有框架提供的接口方法都是可以忽略大小写的。这点你一定要注意！
     */
    @RequestMapping(path = "/hi2", method = RequestMethod.GET) // 使用 HTTP Headers 来接收请求
    public String hi2(@RequestHeader("MyHeader") String myHeader, @RequestHeader MultiValueMap  map){
        return myHeader + " compare with : " + map.get("MyHeader");
    };

    /**
     write to content type into response, can't work:
     GET http://localhost:8080/hi3

     不是所有的 Header 在响应中都能随意指定，虽然表面看起来能生效，但是最后返回给
     客户端的仍然不是你指定的值。例如，在 Tomcat 下，CONTENT_TYPE 这个 Header
     就是这种情况。

     1、修改请求中的 Accept 头，约束返回类型
     2、标记返回类型
     */
/*
    @RequestMapping(path = "/hi3", method = RequestMethod.GET, produces = {"application/json"})
*/

    @RequestMapping(path = "/hi3", method = RequestMethod.GET )
    public String hi3(HttpServletResponse httpServletResponse){
        httpServletResponse.addHeader("myheader", "myheadervalue");
        // 试图在 Controller 中随意自定义 CONTENT_TYPE 等
        httpServletResponse.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        return "ok";
    };


}
