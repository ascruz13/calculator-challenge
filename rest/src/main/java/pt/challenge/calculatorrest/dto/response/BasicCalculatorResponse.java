package pt.challenge.calculatorrest.dto.response;

import java.math.BigDecimal;

import lombok.Getter;

public class BasicCalculatorResponse {
	
	@Getter
	private final BigDecimal result;
	
	public BasicCalculatorResponse(BigDecimal result) {
		this.result = result;
	}
	
	public BasicCalculatorResponse(String result) {
		this.result = new BigDecimal(result);
	}

	/*
	 * public BigDecimal getResult() { return result; }
	 */

}
