package de.mittwald.ant.surf;

import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;

import de.mittwald.ant.flow.AbstractFlowTask;

public class DeployTask extends AbstractFlowTask
{
	protected String	deployment	= null;
	protected boolean	dryRun		= false;

	public void setDeployment(String deployment)
	{
		this.deployment = deployment;
	}

	public void setDryRun(boolean dryRun)
	{
		this.dryRun = dryRun;
	}

	protected void validateAttributes() throws BuildException
	{
		if (this.deployment == null)
		{
			throw new BuildException("Attribute 'deployment' is required!");
		}
	}

	@Override
	protected List<String> getFlowCommandStrings()
	{
		List<String> commands = new ArrayList<String>();
		
		commands.add(dryRun ? "typo3.surf:surf:simulate" : "typo3.surf:surf:deploy");
		commands.add("--disable-ansi");
		commands.add(deployment);
		
		return commands;
	}

}
