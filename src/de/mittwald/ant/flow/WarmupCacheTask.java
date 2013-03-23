package de.mittwald.ant.flow;

import java.util.ArrayList;
import java.util.List;

public class WarmupCacheTask extends AbstractFlowTask
{

	@Override
	protected List<String> getFlowCommandStrings()
	{
		List<String> commands = new ArrayList<String>(1);
		
		commands.add("typo3.flow:cache:warmup");

		return commands;
	}
}
