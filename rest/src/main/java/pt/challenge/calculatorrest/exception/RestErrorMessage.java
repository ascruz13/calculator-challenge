package pt.challenge.calculatorrest.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class RestErrorMessage {
	
	@Getter
	private int statusCode;
	@Getter
	private String reason;
	@Getter
	private String message;

}
