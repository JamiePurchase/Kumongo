package states.menu;

import java.awt.Graphics;
import states.Menu;

public class Options extends MenuInterface
{
    
    public Options(Menu menu)
    {
        super(menu, true);
    }
    
    public void initOptions()
    {
        //this.addOption(new MenuEntry("TITLE_CAMPAIGN", "CAMPAIGN", 975, 330));
    }
    
    public void inputKeyEscape()
    {
        this.getMenuState().interfaceMenu(new Title(this.getMenuState()));
    }
    
    public void inputKeySelect(int option)
    {
        //
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