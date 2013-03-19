package de.mittwald.ant.flow;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import java.io.*;

public abstract class AbstractFlowTask extends Task
{
	abstract protected String getFlowCommandString();

	protected void validateAttributes() throws BuildException
	{
	}

	public void execute() throws BuildException
	{
		this.validateAttributes();

		try
		{
			String command = getFlowCommandString();
			String line;

			Process process = Runtime.getRuntime().exec("./flow " + command);
			BufferedReader bri = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			BufferedReader bre = new BufferedReader(new InputStreamReader(
					process.getErrorStream()));

			while ((line = bri.readLine()) != null)
			{
				System.out.println(line);
			}
			bri.close();

			while ((line = bre.readLine()) != null)
			{
				System.err.println(line);
			}
			bre.close();
			process.waitFor();

			if (process.exitValue() != 0)
			{
				throw new BuildException("TYPO3 Flow exited with code "
						+ process.exitValue() + "!");
			}
		}
		catch (InterruptedException e)
		{
			throw new BuildException("TYPO3 Flow was interrupted!");
		}
		catch (IOException e)
		{
			throw new BuildException("TYPO3 Flow raised error '"
					+ e.getMessage() + "'!");
		}
	}
}
