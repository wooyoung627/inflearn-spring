package hello.springbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Spring Boot를 쓰면 @SpringBootApplication안에 @ComponentScan이 있어 알아서 스캔해준다.
@SpringBootApplication
public class SpringbasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbasicApplication.class, args);
    }

}
