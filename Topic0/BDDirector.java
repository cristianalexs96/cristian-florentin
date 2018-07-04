package Topic0;

public class BDDirector {
	
	private BDBuilder bdbuilder;
	
	public void BuildBD() {
		bdbuilder.createbd();
		bdbuilder.buildName();
		bdbuilder.buildHost();
	}
	
	public void setBD(BDBuilder bd) {
		bdbuilder = bd;
	}
	
	public BD getBD() {
		return bdbuilder.getBD();
	}
	
}
