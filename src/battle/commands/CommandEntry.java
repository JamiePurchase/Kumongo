package battle.commands;

public class CommandEntry
{
    private String commandCaption;
    
    public CommandEntry(String caption)
    {
        this.commandCaption = caption;
    }
    
    public String getCaption()
    {
        return this.commandCaption;
    }
    
}