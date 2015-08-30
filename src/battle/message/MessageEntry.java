package battle.message;

public class MessageEntry
{
    private MessageType messageType;
    private String messageContent;
    
    public MessageEntry(MessageType type, String body)
    {
        this.messageType = type;
        this.messageContent = body;
    }
    
    public String getContent()
    {
        return this.messageContent;
    }
    
    public MessageType getType()
    {
        return this.messageType;
    }
    
}