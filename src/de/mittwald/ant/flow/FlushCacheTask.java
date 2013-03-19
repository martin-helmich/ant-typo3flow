package de.mittwald.ant.flow;

public class FlushCacheTask extends AbstractFlowTask
{
	private boolean force = false;
	
	public void setForce(boolean force)
	{
		this.force = force;
	}
	
	@Override
	protected String getFlowCommandString()
	{
		String command = "flow:cache:flush";
		
		if (this.force)
		{
			command += " --force";
		}
		
		return command;
	}
}
