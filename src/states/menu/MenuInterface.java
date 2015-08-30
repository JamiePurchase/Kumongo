package states.menu;

import gfx.Text;
import java.awt.Graphics;
import java.util.ArrayList;
import states.Menu;
import styles.Style;

public abstract class MenuInterface
{
    // Menu
    private Menu menuState;
    
    // Options
    private ArrayList<MenuEntry> optionEntry;
    private int optionCursorPos, optionCursorMax;
    private int optionCursorTick, optionCursorAnim;
    private boolean optionCursorLeft, optionRender;
    
    public MenuInterface(Menu menu, boolean render)
    {
        // Menu
        this.menuState = menu;
        
        // Options
        this.optionEntry = new ArrayList();
        this.optionCursorPos = 0;
        this.optionCursorTick = 0;
        this.optionCursorAnim = 0;
        this.optionCursorLeft = true;
        this.optionRender = render;
        if(this.optionRender) {this.initOptions();}
    }
    
    public void addOption(MenuEntry newOption)
    {
        this.optionEntry.add(newOption);
    }
    
    public int getCursorPos()
    {
        return this.optionCursorPos;
    }
    
    public Menu getMenuState()
    {
        return this.menuState;
    }
    
    public abstract void initOptions();
    
    public void inputKeyCursor(String key)
    {
        if(key.equals("UP") && this.optionCursorPos > 0) {this.optionCursorPos -= 1;}
        if(key.equals("DOWN") && this.optionCursorPos < this.optionEntry.size() - 1) {this.optionCursorPos += 1;}
    }
    
    public abstract void inputKeyEscape();
    
    public abstract void inputKeySelect(int option);
    
    public abstract void renderContent(Graphics g);
    
    public void renderOptions(Graphics g)
    {
        if(this.optionRender)
        {
            for(int x = 0; x < this.optionEntry.size(); x++)
            {
                this.optionEntry.get(x).render(g);
            }
            Text.writeShadow(g, "->", this.optionEntry.get(this.optionCursorPos).getPosX() - 55 - this.optionCursorAnim, this.optionEntry.get(this.optionCursorPos).getPosY(), 2, "LEFT", Style.font("TITLE_OPTION"), Style.colour("MONGO_BUBBLE"), Style.colour("MONGO_SHADOW"));
        }
    }
    
    public void setOptionRender(boolean active)
    {
        this.optionRender = active;
    }
    
    public void tick()
    {
        if(this.optionRender) {this.tickCursor();}
        this.tickContent();
    }
    
    public abstract void tickContent();
    
    private void tickCursor()
    {
        this.optionCursorTick += 1;
        if(this.optionCursorTick > 2)
        {
            this.optionCursorTick = 0;
            if(this.optionCursorLeft)
            {
                this.optionCursorAnim += 1;
                if(this.optionCursorAnim > 10)
                {
                    this.optionCursorLeft = false;
                }
            }
            else
            {
                this.optionCursorAnim -= 1;
                if(this.optionCursorAnim < 1)
                {
                    this.optionCursorLeft = true;
                }
            }
        }
    }
    
}