package pt.challenge.calculator.operation;

import java.math.BigDecimal;

public class Multiplication implements Operation {
	
	public BigDecimal calculate(BigDecimal a, BigDecimal b) {
		return a.multiply(b);
	}

}
