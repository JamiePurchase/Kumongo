package states;

import gfx.Drawing;
import gfx.Text;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import states.menu.MenuInterface;
import states.menu.Title;
import styles.Style;

public class Menu extends State
{
    // Interface
    private MenuInterface interfaceMenu;
    
    // Background
    private int backgroundTick;
    private int backgroundAnim;
    private boolean backgroundLeft;
    
    // Details
    private String detailText;
    
    public Menu()
    {
        // Interface
        this.interfaceMenu = new Title(this);
        
        // Background
        this.backgroundTick = 0;
        this.backgroundAnim = 0;
        this.backgroundLeft = false;
        
        // Details
        this.detailText = "";
    }
    
    public void interfaceMenu(MenuInterface newMenu)
    {
        this.interfaceMenu = newMenu;
    }

    public void inputKeyPress(String key)
    {
        if(key.equals("UP") || key.equals("DOWN")) {this.interfaceMenu.inputKeyCursor(key);}
        if(key.equals("ENTER") || key.equals("SPACE")) {this.interfaceMenu.inputKeySelect(this.interfaceMenu.getCursorPos());}
        if(key.equals("ESCAPE")) {this.interfaceMenu.inputKeyEscape();}
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
        this.renderTitle(g);
        this.renderDetails(g);
        this.interfaceMenu.renderContent(g);
        this.interfaceMenu.renderOptions(g);
    }
    
    private void renderDetails(Graphics g)
    {        
        // Background
        Drawing.fadeRect(g, 0, 718, 1366, 50, Color.BLACK, 0.5f);
        
        // Line
        Drawing.drawLine(g, 0, 718, 1366, 718, Style.colour("MONGO_SHADOW"));
        
        // Text
        Text.write(g, this.detailText, 30, 750, "LEFT", Style.font("STANDARD"), Color.BLACK);
        
        // TEMP
        //Drawing.drawImageOpaque(g, Drawing.getImage("display/key_prompt.png"), 200, 718, 0.5f);
    }
    
    private void renderTitle(Graphics g)
    {
        // Background
        Drawing.fillRect(g, 0, 0, 1366, 768, Style.colour("PARCHMENT"));
        Drawing.drawImage(g, Drawing.getImage("map/1.png"), -backgroundAnim, 0);
        
        // Logo
        Drawing.drawImage(g, Drawing.getImage("display/logo.png"), 508, 50);
    }

    public void tick()
    {
        this.tickBackground();
        this.interfaceMenu.tick();
    }
    
    private void tickBackground()
    {
        if(this.backgroundLeft)
        {
            this.backgroundAnim -= 1;
            if(this.backgroundAnim < 1)
            {
                this.backgroundLeft = false;
            }
        }
        else
        {
            this.backgroundAnim += 1;
            if(this.backgroundAnim > 1634)
            {
                this.backgroundLeft = true;
            }
        }
    }
    
}