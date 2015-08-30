package states;

import app.Engine;
import gfx.Colour;
import gfx.Drawing;
import gfx.Text;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import styles.Style;

public class Init extends State
{
    private int introStage;
    private int introTickNow;
    private int[] introTickMax;
    
    public Init()
    {
        this.introStage = 0;
        this.introTickNow = 0;
        this.introTickMax = new int[]{6, 120, 20, 120, 20};
        
        // TEMP
        this.introStage = 4;
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
        g.setColor(Colour.getColour("BLACK"));
        g.fillRect(0, 0, 1366, 768);
        
        // Intro
        if(this.introStage == 1)
        {
            Text.writeShadow(g, "Twisted Kinaesthetix", 500 + (this.introTickNow / 2), 300, 2, "CENTER", Style.font("INTRO_TEXT"), Color.WHITE, Style.colour("MONGO_SHADOW"));
            Text.writeShadow(g, "presents", 500 + (this.introTickNow / 2), 365, 2, "CENTER", Style.font("INTRO_TEXT"), Color.WHITE, Style.colour("MONGO_SHADOW"));
        }
        if(this.introStage == 3)
        {
            Text.writeShadow(g, "Java     Netbeans", 500 + (this.introTickNow / 2), 300, 2, "CENTER", Style.font("INTRO_TEXT"), Color.WHITE, Style.colour("MONGO_SHADOW"));
            Text.writeShadow(g, "PHP     mySQL", 550 + (this.introTickNow / 2), 365, 2, "CENTER", Style.font("INTRO_TEXT"), Color.WHITE, Style.colour("MONGO_SHADOW"));
        }
    }

    public void tick()
    {
        this.introTickNow += 1;
        if(this.introTickNow >= this.introTickMax[this.introStage])
        {
            this.introTickNow = 0;
            this.introStage += 1;
            if(this.introStage > 4) {Engine.setState(new Menu());}
        }
    }
    
}