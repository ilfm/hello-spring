package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(HelloSpringApplication.class, args);
	}
	// @SpringBootApplication 실행이 되면서 톰캣 웹서버 내장하고 있다.
	// 그래서 자체적으로 띄어준다.

}
