package de.mittwald.ant.surf;

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
	protected String getFlowCommandString()
	{
		String command = dryRun ? "typo3.surf:surf:simulate"
				: "typo3.surf:surf:deploy";
		return command + " --disable-ansi " + deployment;
	}

}
