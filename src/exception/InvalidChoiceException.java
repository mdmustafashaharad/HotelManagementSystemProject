package exception;

/**
 * @author Mohammad Mustafa
 * @since 2023
 * @Email mdmustafashaharad@gmail.com
 * @contact 9900651340
 */

// custom exception

public class InvalidChoiceException extends RuntimeException {
	
	private String message;
	
	public InvalidChoiceException(String message) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
