package Topic0;

public abstract class BDBuilder {
	
	protected BD bd;
	
	public BD getBD() {
		return bd;
	}

	public void createbd() {
		bd = new BD();
	}
	
	public abstract void buildName();
	
	public abstract void buildHost();
}
