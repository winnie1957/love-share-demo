package net.codejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@EnableAutoConfiguration
//@ComponentScan("指定controller所在的package")
//默認情況下掃描的是當前package及其底下的子package
//下一行的註釋為@EnableAutoConfiguration + @ComponentScan
//@SpringBootApplication(scanBasePackages = {"指定controller所在的package"})
@SpringBootApplication(scanBasePackages = {"net.codejava.controller"})
public class LoveAndShareApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoveAndShareApplication.class, args);
	}

}
