package de.mittwald.ant.flow;

import java.util.ArrayList;
import java.util.List;

public class FlushCacheTask extends AbstractFlowTask
{
	private boolean	force	= false;

	public void setForce(boolean force)
	{
		this.force = force;
	}

	@Override
	protected List<String> getFlowCommandStrings()
	{
		List<String> commands = new ArrayList<String>(2);
		
		commands.add("flow:cache:flush");

		if (this.force)
		{
			commands.add("--force");
		}

		return commands;
	}
}
