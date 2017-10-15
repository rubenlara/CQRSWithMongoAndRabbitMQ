package com.Ultimatesoftware.Integrationservices.Queries;

import com.rabbitmq.client.Channel;
import org.axonframework.amqp.eventhandling.DefaultAMQPMessageConverter;
import org.axonframework.amqp.eventhandling.spring.SpringAMQPMessageSource;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.axonframework.serialization.Serializer;
import org.springframework.amqp.core.Message;

@SpringBootApplication
public class QueriesApplication {

	public static void main(String[] args) {

	    SpringApplication.run(QueriesApplication.class, args);
	    System.out.println("System intialized");
	}

	@Bean
	public SpringAMQPMessageSource IntegrationsQueue(Serializer serializer){
		return new SpringAMQPMessageSource(new DefaultAMQPMessageConverter(serializer)){
			@RabbitListener(queues = "Integration")
			@Override
			public void onMessage(Message message, Channel channel) throws Exception{
				super.onMessage(message, channel);
			}
		};
	}
}
