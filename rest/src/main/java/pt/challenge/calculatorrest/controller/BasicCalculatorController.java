package pt.challenge.calculatorrest.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.challenge.calculatorrest.dto.response.BasicCalculatorResponse;
import pt.challenge.calculatorrest.service.BasicCalculatorService;

@RestController
@RequestMapping("/api/v1")
public class BasicCalculatorController {
	
	@Autowired
	BasicCalculatorService calcService;

	@GetMapping("/sum")
    public ResponseEntity<BasicCalculatorResponse> add(@RequestParam(value="a") BigDecimal a, @RequestParam(value="b") BigDecimal b) {
		BasicCalculatorResponse calcResponse = calcService.sendOperation("Sum", a, b);
        return new ResponseEntity<BasicCalculatorResponse>(calcResponse, HttpStatus.OK);
    }
    
	@GetMapping("/sub")
    public ResponseEntity<BasicCalculatorResponse> subtract(@RequestParam(value="a") BigDecimal a, @RequestParam(value="b") BigDecimal b) {
    	BasicCalculatorResponse calcResponse = calcService.sendOperation("Subtraction", a, b);
        return new ResponseEntity<BasicCalculatorResponse>(calcResponse, HttpStatus.OK);
    }
    
	@GetMapping("/mul")
    public ResponseEntity<BasicCalculatorResponse> multiply(@RequestParam(value="a") BigDecimal a, @RequestParam(value="b") BigDecimal b) {
    	BasicCalculatorResponse calcResponse = calcService.sendOperation("Multiplication", a, b);
        return new ResponseEntity<BasicCalculatorResponse>(calcResponse, HttpStatus.OK);    	
    }
    
	@GetMapping("/div")
    public ResponseEntity<BasicCalculatorResponse> divide(@RequestParam(value="a") BigDecimal a, @RequestParam(value="b") BigDecimal b) {
    	BasicCalculatorResponse calcResponse = calcService.sendOperation("Division", a, b);
        return new ResponseEntity<BasicCalculatorResponse>(calcResponse, HttpStatus.OK);    	
    }
    
    @ExceptionHandler({IllegalArgumentException.class, NullPointerException.class})
    void handleBadRequests(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), "Invalid parameter.");
    }

}
