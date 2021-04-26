package pt.challenge.calculator.operation;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Division implements Operation {
	
	public BigDecimal calculate(BigDecimal a, BigDecimal b) {
    	if (b.equals(BigDecimal.ZERO))
    		throw new IllegalArgumentException("Division by 0");
    	
		return a.divide(b, 3, RoundingMode.CEILING);
	}

}
