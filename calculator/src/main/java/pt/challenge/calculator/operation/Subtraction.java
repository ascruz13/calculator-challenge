package pt.challenge.calculator.operation;

import java.math.BigDecimal;

public class Subtraction implements Operation {
	
	public BigDecimal calculate(BigDecimal a, BigDecimal b) {
		return a.subtract(b);
	}

}
