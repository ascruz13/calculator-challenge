package pt.challenge.calculatorrest.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class RestException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	private HttpStatus status;
	@Getter
	private String message;
	
}
