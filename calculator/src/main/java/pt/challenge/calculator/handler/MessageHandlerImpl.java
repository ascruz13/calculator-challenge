package pt.challenge.calculator.handler;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import pt.challenge.calculator.exception.CalcException;
import pt.challenge.calculator.operation.Operation;

@Component
@NoArgsConstructor
public class MessageHandlerImpl implements MessageHandler {

	public String process(String message) {
		String result = null;

		try {
			String[] arrMessage = message.split(",");

			Operation oper = createObject(arrMessage[0]);
			BigDecimal a = new BigDecimal(arrMessage[1]);
			BigDecimal b = new BigDecimal(arrMessage[2]);

			result = oper.calculate(a, b).toString();
		} catch (ArrayIndexOutOfBoundsException e) {
			String exceptionMessage = String.format("Message is malformatted. '%s'", message);
			logger.error(exceptionMessage);
			throw new CalcException(exceptionMessage + " Usage: 'OPER,A,B'", e);
		} catch (ClassNotFoundException e) {
			String exceptionMessage = String.format("Unknown operation. '%s'", message);
			logger.error(exceptionMessage);
			throw new CalcException(exceptionMessage, e);
		} catch (InstantiationException e) {
			String exceptionMessage = String.format("Unable to instantiate operation.", e.getMessage());
			logger.error(exceptionMessage);
			throw new CalcException(exceptionMessage, e);
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage());
			throw new CalcException(e);
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
			throw new CalcException(e);
		} catch (InvocationTargetException e) {
			logger.error(e.getMessage());
			throw new CalcException(e);
		} catch (NoSuchMethodException e) {
			logger.error(e.getMessage());
			throw new CalcException(e);
		} catch (SecurityException e) {
			logger.error(e.getMessage());
			throw new CalcException(e);
		}

		return result;
	}

	private static Operation createObject(String className) 
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?> clazz = Class.forName(operPackage + "." + className);
		return (Operation) clazz.getDeclaredConstructor().newInstance();
	}

	private static String operPackage = "pt.challenge.calculator.operation";

	private static final Logger logger = LoggerFactory.getLogger(MessageHandlerImpl.class);

}
