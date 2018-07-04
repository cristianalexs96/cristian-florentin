package Topic0;

public class ConnectionManager {
	private static boolean connection;
	
	public ConnectionManager() {
		connection = false;
	}
	
	public static void connect() {
		connection = true;
	}
	
	public static void disconnect() {
		connection = false;
	}
	
	public static boolean checkConnection() {
		return connection;
	}
	
}
