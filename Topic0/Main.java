package Topic0;

public class Main {

	public static void main(String[] args) {
		
		//PUNTO 1
		DBConnection connection = DBConnection.ConnectBD();
		
		System.out.println(connection.getConfig());
		System.out.println("----------------------");
		
		//PUNTO 2
		ConnectionBuilder myDB = new ConnectionBuilder();
		Connection DBconnection = myDB.createConnection("MySQL");
		
		System.out.println(DBconnection.ConnectDB());
		System.out.println("----------------------");
		//PUNTO 3
		ConnectionManager.connect();
		Connect connectionproxy = new Connect();
		connectionproxy.connectDB();
		System.out.println("----------------------");
			
		//PUNTO 4
		BDDirector bdDirector = new BDDirector();
		bdDirector.setBD(new MySQLBuilder());
		bdDirector.BuildBD();
		BD bd = bdDirector.getBD();
		
		System.out.println(bd.getName());
		System.out.println(bd.getHost());
		
	}

}
