package com.Ultimatesoftware.IntegrationServices.Commands;

import org.axonframework.spring.config.EnableAxon;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommandsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommandsApplication.class, args);
	}

	@Bean
	public Exchange exchange() { return ExchangeBuilder.fanoutExchange("Integration").build(); }

	@Bean
	public Queue queue() { return QueueBuilder.durable("Integration").build(); }

	@Bean
	public Binding binding(){ return BindingBuilder.bind(queue()).to(exchange()).with("*").noargs(); }

	@Autowired
	public void configure(AmqpAdmin admin){
		admin.declareExchange(exchange());
		admin.declareQueue(queue());
		admin.declareBinding(binding());

	}
}
