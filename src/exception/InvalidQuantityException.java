package exception;

/**
 * @author Mohammad Mustafa
 * @since 2023
 * @Email mdmustafashaharad@gmail.com
 * @contact 9900651340
 */

// custom exception

public class InvalidQuantityException extends RuntimeException {
	
	private String message;
	
	public InvalidQuantityException(String message ) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}
