package pt.challenge.calculatorrest.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import pt.challenge.calculatorrest.dto.response.BasicCalculatorResponse;

@Service
public interface BasicCalculatorService {
	
	BasicCalculatorResponse sendOperation(String oper, BigDecimal operand1, BigDecimal operand2);

}
