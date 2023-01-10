package Tools;

public class Tool implements Itool{
	  private boolean bInstanceClassLevel;
	
	public Tool()
	{
		this.bInstanceClassLevel = false;
	}
	@Override
	public void setInstanceClassLevel() {
		 this.bInstanceClassLevel = true;
		
	}

	@Override
	public boolean isInstanceClassLevel() {
		 return this.bInstanceClassLevel;
		  
	}

	@Override
	public void closeTool() {
		
		
	}

}
