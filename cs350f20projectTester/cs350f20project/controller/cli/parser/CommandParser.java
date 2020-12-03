package cs350f20project.controller.cli.parser;

import cs350f20project.controller.command.A_Command;
import cs350f20project.controller.command.meta.CommandMetaDoExit;

//Hello World
public class CommandParser {
	
	private MyParserHelper parserHelper;
	private String commandText;
	private A_Command command;

	public CommandParser(MyParserHelper parserHelper, String commandText)
	{
		this.parserHelper = parserHelper;
		this.commandText = commandText;
	}
	
	public void parse()
	{
		if (this.commandText.equalsIgnoreCase("@exit"))
		{
			A_Command command = new CommandMetaDoExit();
			this.parserHelper.getActionProcessor().schedule(command);
		}
		
		else if(this.commandText.contains("CREATE POWER"))
		{
			CreationalPower power = new CreationalPower(parserHelper, commandText.substring(13));
			power.parse();
		}
		
		else if(this.commandText.contains("CREATE STOCK"))
		{
			int k = this.commandText.indexOf("K")+2;
			CreationalStock stock = new CreationalStock(parserHelper, commandText.substring(k));
			stock.parse();
		}
			
	}
	
	public void commandSchedule()
	{
		this.parserHelper.getActionProcessor().schedule(this.command);
	}
	
	public String getCommand()
	{
		return this.commandText;
	}
	
	public void setCommandType(A_Command command)
	{
		this.command = command;
	}
	
	public MyParserHelper getHelper()
	{
		return this.parserHelper;
	}
	
}

