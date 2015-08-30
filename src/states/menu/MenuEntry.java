package states.menu;

import gfx.Text;
import java.awt.Graphics;
import styles.Style;

public class MenuEntry
{
    private String entryRef;
    private String entryCaption;
    private int entryPosX, entryPosY;
    
    public MenuEntry(String ref, String caption, int posX, int posY)
    {
        this.entryRef = ref;
        this.entryCaption = caption;
        this.entryPosX = posX;
        this.entryPosY = posY;
    }
    
    public String getCaption()
    {
        return this.entryCaption;
    }
    
    public int getPosX()
    {
        return this.entryPosX;
    }
    
    public int getPosY()
    {
        return this.entryPosY;
    }
    
    public void render(Graphics g)
    {
        Text.writeShadow(g, this.entryCaption, this.entryPosX, this.entryPosY, 2, "LEFT", Style.font("TITLE_OPTION"), Style.colour("MONGO_BUBBLE"), Style.colour("MONGO_SHADOW"));
    }
    
}