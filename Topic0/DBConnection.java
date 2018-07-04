package Topic0;

public class DBConnection {

	private static DBConnection instanceState = null;
	private String db_connection;
	private String db_host = "BD_HOST";
	private String db_usr = "admin";
	private String db_pass = "secret";
	

	private DBConnection() {
		this.db_connection = "HOST: "+ this.db_host + "\nUSER: "+ this.db_usr + "\nPASSWORD: " + this.db_pass;
	}

	public static DBConnection ConnectBD() {
		if (instanceState == null) {
			instanceState = new DBConnection();
		}
		return instanceState;
	}

	public String getConfig() {
		return this.db_connection;
	}
}
