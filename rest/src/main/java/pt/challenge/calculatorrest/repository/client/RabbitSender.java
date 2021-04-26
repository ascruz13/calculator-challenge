package pt.challenge.calculatorrest.repository.client;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${spring.rabbitmq.template.exchange}")
	private String exchange;
	@Value("${spring.rabbitmq.template.routing-key}")
	private String routingkey;

	public String send(String message) {

		String response = (String) rabbitTemplate.convertSendAndReceive(exchange, routingkey, message);

		return response;
	}
}
