package my.winapp.springdatabootrabbitmqsender.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import my.winapp.springdatabootrabbitmqsender.util.Constants;

@Configuration
@EnableTransactionManagement
@ComponentScan("my.winapp.springdatabootrabbitmqsender")
@PropertySource({"classpath:rabbitmq.properties"})
@EnableRabbit
public class RabbitConfiguration {
	
	@Autowired
	Environment env;
	
	@Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        	connectionFactory.setHost(env.getProperty(Constants.RABBIT_HOST));
        	connectionFactory.setPort(env.getProperty(Constants.RABBIT_PORT, Integer.class));
        	connectionFactory.setUsername(env.getProperty(Constants.RABBIT_USERNAME));
        	connectionFactory.setPassword(env.getProperty(Constants.RABBIT_PASSWORD));
        return connectionFactory;
    }
	
	@Bean
	public Queue queue() {
		return new Queue("hello1");
	}

}
