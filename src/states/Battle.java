package states;

import battle.commands.CommandModule;
import battle.entities.UnitAction;
import battle.entities.UnitEntity;
import battle.entities.UnitFace;
import battle.entities.UnitType;
import battle.message.MessageEntry;
import battle.message.MessageModule;
import gfx.Colour;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import network.NetworkService;

public class Battle extends State
{
    // Battle
    private int battleID;
    private int battleHostID;
    private int battleGuestID;
    private HashMap<String, UnitEntity> battleEntity;
    
    // Network
    private long networkRequestTime;
    
    // Commands
    private CommandModule commandModule;
    private UnitEntity commandEntity;
    
    // Messaage
    private MessageModule messageModule;
    private ArrayList<MessageEntry> messageLog;
    
    // World
    private int worldOffsetX, worldOffsetY;
    
    public Battle(int battleID, int hostID, int guestID)
    {
        // Battle
        this.battleID = battleID;
        this.battleHostID = hostID;
        this.battleGuestID = guestID;
        this.battleEntity = new HashMap();
        
        // Network
        this.networkRequestTime = 0;
        
        // Commands
        this.commandModule = null;
        this.commandEntity = null;
        
        // TEMP
        //this.commandModule = new CommandModule(this);
        
        // Message
        this.messageLog = new ArrayList();
        this.messageModule = new MessageModule();
        
        //this.messageLog.add(new MessageEntry(MessageType.SYSTEM, "HELLO"));
        //this.messageModule.setMessage(this.messageLog);
        
        // World
        this.worldOffsetX = 0;
        this.worldOffsetY = 0;
        
        // TEMP
        this.entityAdd(new UnitEntity(this, 0, 1, 4, 5, UnitFace.EAST, "Djarvir Sorceror", UnitType.MYSTIC, "Djarvir Sorceror", 100, 100, 100, 100, 100, UnitAction.IDLE), "H_DS1");
        this.entityAdd(new UnitEntity(this, 0, 1, 8, 6, UnitFace.EAST, "Hakuza Witch", UnitType.MYSTIC, "Hakuza Witch", 100, 100, 100, 100, 100, UnitAction.IDLE), "H_HW1");
        
        // TEMP
        this.entityAdd(new UnitEntity(this, 0, 2, 10, 3, UnitFace.WEST, "Djarvir Sorceror", UnitType.MYSTIC, "Djarvir Sorceror", 100, 100, 100, 100, 100, UnitAction.IDLE), "G_DS1");
        this.entityAdd(new UnitEntity(this, 0, 2, 9, 5, UnitFace.WEST, "Hakuza Witch", UnitType.MYSTIC, "Hakuza Witch", 100, 100, 100, 100, 100, UnitAction.IDLE), "G_HW1");
    }
    
    public void entityAdd(UnitEntity entity, String ref)
    {
        this.battleEntity.put(ref, entity);
    }
    
    public UnitEntity entityGet(String ref)
    {
        return this.battleEntity.get(ref);
    }
    
    private ArrayList<UnitEntity> entityList()
    {
        return new ArrayList<UnitEntity>(this.battleEntity.values());
    }

    public void inputKeyPress(String key)
    {
        //
    }

    public void inputKeyRelease(String key)
    {
        //
    }

    public void inputKeyType(String key)
    {
        //
    }

    public void inputMouseClickL(MouseEvent e)
    {
        //
    }

    public void inputMouseClickR(MouseEvent e)
    {
        //
    }

    public void inputMouseMove(MouseEvent e)
    {
        //
    }
    
    public void render(Graphics g)
    {
        // Background
        this.renderScene(g);
        
        // Entities
        this.renderEntity(g);
        
        // Account
        //Drawing.fillRect(g, new Rectangle(25, 25, 300, 50), Color.WHITE);
        //Drawing.fillRect(g, new Rectangle(1041, 25, 300, 50), Color.WHITE);
        
        // Message
        //this.messageModule.render(g);
        
        // Command
        if(this.commandModule != null) {this.commandModule.render(g);}
        
        // TEMP
        /*g.setColor(Color.WHITE);
        g.drawString("TIME: " + (System.nanoTime() / 1000000000), 100, 100);
        g.drawString("NEXT: " + this.networkRequestTime, 100, 150);
        
        for(int x = 0; x < this.tempString.size(); x++)
        {
            g.drawString(this.tempString.get(x), 200, (250 + (50 * x)));
        }*/
    }
    
    private void renderEntity(Graphics g)
    {
        for(int x = 0; x < this.battleEntity.size(); x++)
        {
            this.entityList().get(x).render(g);
        }
    }
    
    private void renderScene(Graphics g)
    {
        g.setColor(Colour.getColourRGB(193, 220, 119));
        g.fillRect(0, 0, 1366, 768);
    }

    public void tick()
    {
        this.tickEntity();
        //Engine.setState(new StateBuilder());
        //this.tickNetwork();
    }
    
    private void tickEntity()
    {
        for(int x = 0; x < this.battleEntity.size(); x++)
        {
            this.entityList().get(x).tick();
        }
    }
    
    private void tickNetwork()
    {
        long networkTime = System.nanoTime() / 1000000000;
        if(networkTime > this.networkRequestTime)
        {
            this.networkRequestTime = networkTime + 10;
            this.tickNetworkRequest();
        }
    }
    
    private void tickNetworkRequest()
    {
        //Server.something() ??
        //ArrayList<String> data = NetworkService.request("http://kumongo.co.nf/request.php?action=battletick&accountID=1&battleID=" + this.battleID);
        /* NOTE: need to use the network.Server static class instead!
        NOTE: send the accountID, battleID, last move and last chat
        the server will update the account last online datetime
        we will get back information about the last move and last chat */
    }
    
    public int worldOffsetX()
    {
        return this.worldOffsetX;
    }
    
    public int worldOffsetY()
    {
        return this.worldOffsetY;
    }
    
}