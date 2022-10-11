package com.spring.puzzle.web.body;
////refer to https://github.com/jiafu1115/springmvc
//不是每种类型的编码器都会与生俱来，而是
//        根据当前项目的依赖情况决定是否支持。要解析 JSON，我们就要依赖相关的包，

//返回的内容在依赖项改变的情况下确实可能
//发生变化

//造成 Body 缺失的原因了吧？
//1. 本身就没有 Body；
//        2. 有 Body，但是 Body 本身代表的流已经被前面读取过了。