package Topic0;

public class Connect implements ConnectAbstract{

	@Override
	public void connectDB() {
		if (ConnectionManager.checkConnection())
			new ConnectProxy().connectDB();
		else
			new ConnectNoProxy().connectDB();
		
	}

}
