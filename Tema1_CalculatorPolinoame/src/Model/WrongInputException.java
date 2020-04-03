package Model;

public class WrongInputException extends Exception{
	private String message = "Error exception";
	
	public WrongInputException(String s) {
		this.message = s;
	}
	
	public WrongInputException() {
		super("Input Exception. Please provide a valid input");
	}
	
	public String getMessage() {
		return this.message;
	}
}
