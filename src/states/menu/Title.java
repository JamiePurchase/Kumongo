package states.menu;

import java.awt.Graphics;
import states.Menu;

public class Title extends MenuInterface
{
    
    public Title(Menu menu)
    {
        super(menu, true);
    }
    
    public void initOptions()
    {
        this.addOption(new MenuEntry("TITLE_CAMPAIGN", "CAMPAIGN", 975, 330));
        this.addOption(new MenuEntry("TITLE_MULTIPLAYER", "MULTIPLAYER", 980, 390));
        this.addOption(new MenuEntry("TITLE_PROFILE", "PROFILE", 985, 450));
        this.addOption(new MenuEntry("TITLE_OPTIONS", "OPTIONS", 990, 510));
        this.addOption(new MenuEntry("TITLE_EXIT", "EXIT GAME", 995, 570));
    }
    
    public void inputKeyEscape()
    {
        System.exit(0);
    }
    
    public void inputKeySelect(int option)
    {
        if(option == 0) {this.getMenuState().interfaceMenu(new Campaign(this.getMenuState()));}
        if(option == 1) {this.getMenuState().interfaceMenu(new Multiplayer(this.getMenuState()));}
        if(option == 2) {this.getMenuState().interfaceMenu(new Profile(this.getMenuState()));}
        if(option == 3) {this.getMenuState().interfaceMenu(new Options(this.getMenuState()));}
        if(option == 4) {System.exit(0);}
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