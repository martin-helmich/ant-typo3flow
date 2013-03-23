package de.mittwald.ant.flow;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

public abstract class AbstractFlowTask extends Task
{
	protected String	path	= "./flow";

	abstract protected List<String> getFlowCommandStrings();

	public void setPath(String p)
	{
		path = p;
	}
	
	protected void validateAttributes() throws BuildException
	{
	}

	public void execute() throws BuildException
	{
		this.validateAttributes();

		try
		{
			List<String> command = new ArrayList<String>(10);
			String line;
			
			command.add(path);
			command.addAll(getFlowCommandStrings());

			ProcessBuilder builder = new ProcessBuilder(command);

			Process process = builder.start();
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
