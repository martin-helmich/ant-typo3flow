package de.mittwald.ant.flow;

import org.apache.tools.ant.BuildException;

public class DoctrineMigrateTask extends AbstractFlowTask
{
	private boolean quiet = false;
	private boolean dryRun = false;

	public void setQuiet(boolean quiet)
	{
		this.quiet = quiet;
	}

	public void setDryRun(boolean dryRun)
	{
		this.dryRun = dryRun;
	}

	public void execute() throws BuildException
	{
		String command = "doctrine:migrate";

		if (this.quiet)
		{
			command += " --quiet";
		}
		
		if (this.dryRun)
		{
			command += " --dryRun";
		}

		this.executeCommand(command);
	}
}
