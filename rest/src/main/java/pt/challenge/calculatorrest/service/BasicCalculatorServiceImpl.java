package pt.challenge.calculatorrest.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import pt.challenge.calculatorrest.dto.response.BasicCalculatorResponse;
import pt.challenge.calculatorrest.exception.RestException;

@ComponentScan
@Service
public class BasicCalculatorServiceImpl implements BasicCalculatorService {
	
	@Value("${spring.rabbitmq.template.exchange}")
    private String exchange;
    @Value("${spring.rabbitmq.template.routing-key}")
    private String routingkey;

    @Autowired
	private RabbitTemplate rabbitTemplate;

	public BasicCalculatorResponse sendOperation(String oper, BigDecimal operand1, BigDecimal operand2) {
		String message = String.format("%s,%s,%s", oper, operand1, operand2);

		String response = null;
		try {
			response = send(message);
		} catch (Exception e) {
			logger.error("An error occurred while invoking the call method.", e);
			throw new RestException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to complete request.");
		}

		if (response.startsWith("ERROR"))
			throw new RestException(HttpStatus.BAD_REQUEST, response);

		return new BasicCalculatorResponse(response);
	}

	public String send(String message) {

		String response = (String) rabbitTemplate.convertSendAndReceive(exchange, routingkey, message);

		return response;
	}

	private static final Logger logger = LoggerFactory.getLogger(BasicCalculatorServiceImpl.class);

}
