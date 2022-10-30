package recipes.exception;

@SuppressWarnings("serial")
public class DbException extends RuntimeException {

	public DbException() { //4 exception constructors 
	}

	public DbException(String message) {
		super(message);
	}

	public DbException(Throwable cause) {
		super(cause);
	}

	public DbException(String message, Throwable cause) {
		super(message, cause);
	}

}
