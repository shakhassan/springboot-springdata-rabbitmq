/** 
 * Reference : https://github.com/spring-guides/gs-messaging-rabbitmq 
 * **/


package my.winapp.springdatabootrabbitmqsender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import my.winapp.springdatabootrabbitmqsender.sender.Sender;

@EnableAutoConfiguration
@SpringBootApplication
public class SpringBootRabbitMQApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRabbitMQApplication.class, args);		
	}

	@Autowired
	Sender sender;
	
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("RabbitMQ Sender Spring Data Boot Main Class");
		sender.send();
		
	}
	

}
