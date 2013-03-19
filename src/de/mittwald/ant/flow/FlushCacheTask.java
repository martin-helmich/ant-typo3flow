package de.mittwald.ant.flow;

import org.apache.tools.ant.BuildException;

public class FlushCacheTask extends AbstractFlowTask
{
	private boolean force = false;
	
	public void setForce(boolean force)
	{
		this.force = force;
	}
	
	public void execute() throws BuildException
	{
		String command = "flow:cache:flush";
		
		if (this.force)
		{
			command += " --force";
		}
		
		this.executeCommand(command);
	}
}
