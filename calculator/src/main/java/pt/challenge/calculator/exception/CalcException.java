package pt.challenge.calculator.exception;

public class CalcException extends RuntimeException {
	
	public CalcException() {
		super();
	}
	
	public CalcException(String s) {
		super(s);
	}
	
	public CalcException(String s, Throwable throwable) {
		super(s, throwable);
	}
	
	public CalcException(Throwable throwable) {
		super(throwable);
	}	

	private static final long serialVersionUID = 1L;

}
