package battle.message;

import gfx.Drawing;
import gfx.Fonts;
import gfx.Text;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MessageModule
{
    private final Rectangle moduleArea = new Rectangle(1041, 443, 300, 300);
    private ArrayList<MessageEntry> moduleMessage = new ArrayList();
    
    public MessageModule()
    {
        this.moduleMessage = new ArrayList();
    }
    
    public void render(Graphics g)
    {
        Drawing.fadeRect(g, this.moduleArea, Color.WHITE, 0.5f);
        for(int x = 0; x < this.moduleMessage.size(); x++)
        {
            Text.write(g, this.moduleMessage.get(x).getContent(), this.moduleArea.x + 25, this.moduleArea.y + 25 + (x * 50), "LEFT", Fonts.getFont("STANDARD"), Color.BLACK);
        }
        Drawing.drawRect(g, this.moduleArea, Color.BLACK);
    }
    
    public void setMessage(ArrayList<MessageEntry> message)
    {
        this.moduleMessage = message;
    }
    
}