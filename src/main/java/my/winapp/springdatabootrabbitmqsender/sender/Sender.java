package my.winapp.springdatabootrabbitmqsender.sender;

import java.util.UUID;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	
	//get properties from a .properties file
	@Autowired
	Environment env;
	
	@Autowired
	private RabbitTemplate template;

	@Autowired
	private Queue queue;
	
	public void send() {
		
		//String message = "Hello World!";
		//UUID message = UUID.fromString("50b12d35-94fd-4297-bb18-e6040d7b7100");
		UUID message = UUID.fromString("55b12d35-94fd-4297-bb18-e6040d7b7109");
		//UUID message = UUID.fromString("50b12d35-94fd-4297-bb18-e6040d7b7109");
		
		//1- hardcode queue name here
		//this.template.convertAndSend("hello1", message);
		
		//@Autowired Queue bean generated in Configuration class
		this.template.convertAndSend(queue.getName(), message);
		
		System.out.println(" [x] Sent '" + message + "'");
	}

}
