package org.mega.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing//이걸 써줘야 BaseTimeEntity를 할 수 있다.
@SpringBootApplication
public class Application {
    public static void main(String[] args) { SpringApplication.run(Application.class, args);}
}
