package Topic0;

public class ConnectionBuilder extends ConnectionAbstract{
	
	public ConnectionBuilder() {
		
	}

	@Override
	protected Connection createConnection(String db) {
		if (db.equalsIgnoreCase("Oracle")) {
			return new OracleConnection();
		}
		else if (db.equalsIgnoreCase("MySQL")) {
			return new MySQLConnection();
		}
		else{
			return new MariaDBConnection();
		}
	}
}