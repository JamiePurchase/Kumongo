package battle.commands;

import gfx.Drawing;
import gfx.Text;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import states.Battle;

public class CommandModule
{
    private Battle moduleBattle;
    private final Rectangle moduleArea = new Rectangle(25, 443, 300, 300);
    private ArrayList<CommandEntry> moduleCommand;
    private int moduleCursor;
    
    public CommandModule(Battle battle)
    {
        this.moduleBattle = battle;
        this.moduleCommand = new ArrayList();
        this.moduleCursor = 0;
    }
    
    public Rectangle getArea()
    {
        return this.moduleArea;
    }
    
    public void render(Graphics g)
    {
        Drawing.drawRect(g, this.moduleArea, Color.BLACK);
        for(int x = 0; x < this.moduleCommand.size(); x++)
        {
            Text.write(g, this.moduleCommand.get(x).getCaption(), this.moduleArea.x + 25, this.moduleArea.y + (30 * x));
        }
    }
    
}