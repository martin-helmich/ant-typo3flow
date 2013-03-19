package de.mittwald.ant.flow;

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

	@Override
	protected String getFlowCommandString()
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

		return command;
	}
}
