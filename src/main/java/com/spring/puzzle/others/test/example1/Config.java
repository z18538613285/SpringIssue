package com.spring.puzzle.others.test.example1;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
/**
 *
 * 我们一般都不会使用本案例的方式（即 locations = {"spring.xml"}，无任何“前
 * 缀”的方式），毕竟它已经依赖于使用的 ApplicationContext。而 classPath 更为普适
 * 些，而一旦你按上述方式修正后，你会发现它加载的资源已经不再是
 * ServletContextResource，而是和应用程序一样的 ClassPathResource，这样自然可以加
 * 载到了。
 */

@ImportResource(locations = {"spring.xml"})
//@ImportResource(locations = {"classpath:spring.xml"})
public class Config {
}