package Topic0;

public abstract class ConnectionAbstract {
	
	public ConnectionAbstract() {
		
	}

	protected abstract Connection createConnection(String db);
}