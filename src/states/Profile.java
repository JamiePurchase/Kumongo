package states;

import gfx.Colour;
import gfx.Drawing;
import gfx.Text;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import styles.Style;

public class Profile extends State
{
    //
    
    public Profile()
    {
        //
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
        this.renderTitle(g);
        this.renderDetails(g);
    }
    
    private void renderDetails(Graphics g)
    {        
        // Background
        Drawing.fadeRect(g, 0, 718, 1366, 50, Color.BLACK, 0.5f);
        
        // Line
        Drawing.drawLine(g, 0, 718, 1366, 718, Style.colour("MONGO_SHADOW"));
        
        // Text
        Text.write(g, "HELLO", 30, 750, "LEFT", Style.font("STANDARD"), Color.BLACK);
    }
    
    private void renderTitle(Graphics g)
    {
        // Background
        Drawing.fillRect(g, 0, 0, 1366, 768, Style.colour("PARCHMENT"));
        
        // Logo
        Drawing.drawImage(g, Drawing.getImage("display/logo.png"), 508, 75);
        
        // Line
        Drawing.drawLine(g, 0, 718, 1366, 718, Color.BLACK);
    }

    public void tick()
    {
        //
    }
    
}