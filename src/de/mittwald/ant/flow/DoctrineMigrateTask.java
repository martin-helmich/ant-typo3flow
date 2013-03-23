package de.mittwald.ant.flow;

import java.util.ArrayList;
import java.util.List;

public class DoctrineMigrateTask extends AbstractFlowTask
{
	private boolean	quiet	= false;
	private boolean	dryRun	= false;

	public void setQuiet(boolean quiet)
	{
		this.quiet = quiet;
	}

	public void setDryRun(boolean dryRun)
	{
		this.dryRun = dryRun;
	}

	@Override
	protected List<String> getFlowCommandStrings()
	{
		List<String> commands = new ArrayList<String>(3);
		
		commands.add("doctrine:migrate");

		if (this.quiet)
		{
			commands.add("--quiet");
		}

		if (this.dryRun)
		{
			commands.add("--dryRun");
		}

		return commands;
	}
}
