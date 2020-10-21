package com.yy.study;

import com.yy.study.initital.SecondInitital;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wyy
 * @date 2020/3/9 22:26
 */
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DemoApplication.class);
        springApplication.addInitializers(new SecondInitital());
        springApplication.run(args);
    }
}
