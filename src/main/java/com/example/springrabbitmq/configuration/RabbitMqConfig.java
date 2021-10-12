package com.example.springrabbitmq.configuration;



import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMqConfig {


    @Value("${spring-rabbit-queue}")
    private String queueName;

    @Value("${spring-rabbit-routing}")
    private String routingName;

    @Value("${spring-rabbit-exchange}")
    private String exchangeName;



    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

    @Bean
    public DirectExchange directExchange() {
    return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding binding(final Queue queue,  final DirectExchange exchange) {
        return BindingBuilder.bind(queue ).to(directExchange()).with(routingName);
    }

    @Bean RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate();
    }
}
