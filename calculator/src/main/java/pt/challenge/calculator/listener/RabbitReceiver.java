package pt.challenge.calculator.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pt.challenge.calculator.handler.MessageHandler;

@Component
public class RabbitReceiver implements RabbitListenerConfigurer {
	
	private static final Logger logger = LoggerFactory.getLogger(RabbitReceiver.class);
	
	@Autowired
	private MessageHandler messageHandler;
	
	@RabbitListener(queues = "${spring.rabbitmq.template.default-receive-queue}")
    public String receivedMessage(String msg) {
		String response = null;
		
		try {
			logger.info(String.format("<-- Message Received : %s", msg));
			
			response = messageHandler.process(msg);
			
			logger.info(String.format("--> Sending message : %s", response));
		}
		catch (Exception e){
			response = String.format("ERROR: %s", e.getMessage());
			logger.info(String.format("--> Sending message : %s", response));
		}
		
		return response;
		
    }

    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {}

}