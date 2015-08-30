package states.menu;

import app.Engine;
import debug.Console;
import gfx.Drawing;
import gfx.Text;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import network.Server;
import states.Battle;
import states.Menu;
import styles.Style;
import users.Account;

public class Lobby extends MenuInterface
{
    // Network
    private boolean networkActive;
    private final Rectangle networkModal = new Rectangle(483, 334, 400, 100);
    
    // Lobby
    private final Rectangle lobbyModal = new Rectangle(50, 180, 1266, 513);
    private boolean lobbyRequestActive;
    private long lobbyRequestTime;
    private int lobbyUserTotal;
    private ArrayList<Account> lobbyUserGroup;
    
    public Lobby(Menu menu)
    {
        super(menu, false);
        
        // Lobby
        this.lobbyRequestActive = false;
        this.lobbyRequestTime = 0;
        this.lobbyUserTotal = 0;
        this.lobbyUserGroup = null;
        
        // Network
        this.networkConnect();
    }
    
    public void initOptions()
    {
        // TEMP
        this.addOption(new MenuEntry("LOBBY_DEBUG", "DEBUG", 975, 330));
    }
    
    public void inputKeyEscape()
    {
        this.getMenuState().interfaceMenu(new Multiplayer(this.getMenuState()));
    }
    
    public void inputKeySelect(int option)
    {
        // TEMP
        if(option == 0) {Engine.setState(new Battle(1, 1, 2));}
    }
    
    private void networkConnect()
    {
        this.networkActive = false;
        /*if(Server.checkVersion(0)) {this.networkActive = true;}
        else
        {
            // NOTE: explain if the game needs updating
            // NOTE: catch errors when talking to server to know when internet is unavailable
            // offer to go back to single player
        }*/
        
        // TEMP
        this.networkActive = true;
        this.lobbyRequestActive = true;
    }
    
    public void renderContent(Graphics g)
    {
        if(!this.networkActive) {this.renderContentConnect(g);}
        else {this.renderContentLobby(g);}
    }
    
    private void renderContentConnect(Graphics g)
    {
        Drawing.fadeRect(g, this.networkModal, Color.BLACK, 0.5f);
        Drawing.drawRect(g, this.networkModal, Color.BLACK);
        Text.write(g, "Connecting to the Kumongo server...", 683, 390, "CENTER", Style.font("MODAL_STANDARD"), Color.BLACK);
    }
    
    private void renderContentLobby(Graphics g)
    {
        // TEMP
        this.lobbyUserTotal = 2;
        
        Drawing.fadeRect(g, this.lobbyModal, Color.BLACK, 0.5f);
        Drawing.drawRect(g, this.lobbyModal, Color.BLACK);
        Text.write(g, "ONLINE USERS: " + this.lobbyUserTotal, 100, 250, "LEFT", Style.font("STANDARD"), Color.BLACK);
        if(this.lobbyUserGroup != null)
        {
            for(int x = 0; x < this.lobbyUserGroup.size(); x++)
            {
                Text.write(g, this.lobbyUserGroup.get(x).getUsername(), 100, (x * 35) + 300, "LEFT", Style.font("STANDARD"), Color.BLACK);
            }
        }
    }
    
    public void tickContent()
    {
        if(this.lobbyRequestActive)
        {
            long requestTime = System.nanoTime() / 1000000000;
            if(requestTime > this.lobbyRequestTime)
            {
                this.lobbyRequestTime = requestTime + 10;
                this.tickContentRequest();
            }
        }
    }
    
    private void tickContentRequest()
    {
        //Server.lobby();
    }
    
}