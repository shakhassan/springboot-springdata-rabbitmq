package my.winapp.springdatabootrabbitmqsender.sender;

import java.util.UUID;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import my.winapp.springdatabootrabbitmqsender.domain.JSONCustomMessage;

@Component
public class Sender {
	
	//get properties from a .properties file
	@Autowired
	Environment env;
	
	@Autowired
	private RabbitTemplate template;

	@Autowired
	private Queue queue;
	
//	@Autowired
//	private JSONCustomMessage jSONCustomMessage;
	
	public void send() {
		
		//String message = "Hello World!";
		//UUID message = UUID.fromString("50b12d35-94fd-4297-bb18-e6040d7b7100");
		//UUID message = UUID.fromString("55b12d35-94fd-4297-bb18-e6040d7b7109");
		//UUID message = UUID.fromString("66b12d35-94fd-4297-bb18-e6040d7b7100");
		UUID message = UUID.fromString("19e12d35-94fd-4297-bb18-e6040d7b7929");
		
		// Test for Post without caption
		//UUID message = UUID.fromString("31b12d35-94fd-4297-bb18-e6040d7b7100");
		
		//1- hardcode queue name here
		//this.template.convertAndSend("hello1", message);
		
		//@Autowired Queue bean generated in Configuration class
		//this.template.setRoutingKey("rk1");
		
		//this.template.setExchange("amq.fanout");
		//this.template.convertAndSend("hello", message);
		
		this.template.convertAndSend(queue.getName(), message);
		
		/*####################################################
		 * SEND MESSAGE TO EXCHANGE > QUEUE (same routing key)
		 *####################################################		
		 */ 
		this.template.setExchange("ex.pushnoti");
		this.template.convertAndSend("rk2", message);
		
		System.out.println(" [x] Sent '" + message + "'");
		
		/*#######################
		 * STORE JSON IN RABBITMQ
		 *#######################
		 */
		UUID userUUID = UUID.fromString("19e12d35-94fd-4297-bb18-e6040d7b7929");
		String phoneNumber = "+60137777775";		
		this.template.convertAndSend(queue.getName(), new JSONCustomMessage(userUUID, phoneNumber).toString());
				
		System.out.println(" [x] Sent '" + userUUID + phoneNumber  + "'");
		
	}

}
