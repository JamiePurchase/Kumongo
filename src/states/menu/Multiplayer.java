package states.menu;

import app.Engine;
import java.awt.Graphics;
import states.Battle;
import states.Menu;

public class Multiplayer extends MenuInterface
{
    
    public Multiplayer(Menu menu)
    {
        super(menu, true);
    }
    
    public void initOptions()
    {
        this.addOption(new MenuEntry("MULTIPLAYER_MATCH", "FIND MATCH", 975, 330));
        this.addOption(new MenuEntry("MULTIPLAYER_STATS", "QUARTERMASTER", 975, 390));
    }
    
    public void inputKeyEscape()
    {
        this.getMenuState().interfaceMenu(new Title(this.getMenuState()));
    }
    
    public void inputKeySelect(int option)
    {
        if(option == 0) {this.getMenuState().interfaceMenu(new Lobby(this.getMenuState()));}
    }
    
    public void renderContent(Graphics g)
    {
        //
    }
    
    public void tickContent()
    {
        //
    }
    
}