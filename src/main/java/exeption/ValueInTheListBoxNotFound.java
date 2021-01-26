package exeption;

public class ValueInTheListBoxNotFound extends Exception {

	private String exceptionmessage;

	public ValueInTheListBoxNotFound(String message) {
		exceptionmessage = message;
	}

	public String getmessage() {
		return exceptionmessage;
	}

}
