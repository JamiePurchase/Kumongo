package battle.entities;

import gfx.Drawing;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import states.Battle;

public class UnitEntity
{
    // Unit
    private Battle unitBattle;
    private int unitID;
    private int unitAccountID;
    private String unitName;
    private UnitType unitType;
    
    // Anim
    private String animPath;
    private int animTickNow, animTickMax;
    private int animFrameNow, animFrameMax;
    
    // Position
    private int positionX;
    private int positionY;
    private UnitFace positionF;
    
    // Stats
    private int statHealthNow, statHealthMax;
    private int statMysticNow, statMysticMax;
    private int statChargeNow;
    
    // Action
    private UnitAction actionState;
    private ArrayList<UnitAbility> actionAbility;
    private boolean actionReady;
    
    public UnitEntity(Battle battle, int unitID, int accountID, int posX, int posY, UnitFace posF, String name, UnitType type, String anim, int healthNow, int healthMax, int mysticNow, int mysticMax, int chargeNow, UnitAction action)
    {
        // Unit
        this.unitBattle = battle;
        this.unitID = unitID;
        this.unitAccountID = accountID;
        this.unitName = name;
        this.unitType = type;
        
        // Anim
        this.animPath = anim;
        UnitData.setAnim(this, "IDLE");
        
        // Position
        this.positionX = posX;
        this.positionY = posY;
        this.positionF = posF;
        
        // Stats
        this.statHealthNow = healthNow;
        this.statHealthMax = healthMax;
        this.statMysticNow = mysticNow;
        this.statMysticMax = mysticMax;
        this.statChargeNow = chargeNow;
        
        // Action
        this.actionState = action;
        this.actionAbility = null;
        this.actionReady = false;
    }
    
    private BufferedImage getAnimImage()
    {
        BufferedImage anim = Drawing.getImage(this.getAnimPath() + "Idle.png").getSubimage((this.animFrameNow * 70), 0, 70, 70);
        if(this.positionF == UnitFace.EAST) {anim = Drawing.flipImage(anim);}
        return anim;
    }
    
    private String getAnimPath()
    {
        return "unit/" + this.animPath + "/";
    }
    
    private int getAnimRenderX()
    {
        return (70 * this.positionX) - this.unitBattle.worldOffsetX();
    }
    
    private int getAnimRenderY()
    {
        return (70 * this.positionY) - this.unitBattle.worldOffsetY();
    }
    
    public String getUnitName()
    {
        return this.unitName;
    }
    
    public void render(Graphics g)
    {
        if(this.actionReady) {Drawing.drawImage(g, Drawing.getImage("unit/cursor/1.png"), this.getAnimRenderX(), this.getAnimRenderY());}
        Drawing.drawImage(g, this.getAnimImage(), this.getAnimRenderX(), this.getAnimRenderY());
    }
    
    public void setAnim(int tickMax, int frameMax)
    {
        // NOTE: consider more of this later
        this.animTickNow = 0;
        this.animTickMax = tickMax;
        this.animFrameNow = 0;
        this.animFrameMax = frameMax;
    }
    
    public void tick()
    {
        this.animTickNow += 1;
        if(this.animTickNow >= this.animTickMax)
        {
            this.animTickNow = 0;
            this.animFrameNow += 1;
            if(this.animFrameNow >= this.animFrameMax)
            {
                this.animFrameNow = 0;
            }
        }
    }
    
}