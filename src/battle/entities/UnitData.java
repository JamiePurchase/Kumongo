package battle.entities;

public class UnitData
{
    
    public static void setAnim(UnitEntity entity, String anim)
    {
        if(entity.getUnitName().equals("Djarvir Sorceror"))
        {
            if(anim.equals("IDLE")) {entity.setAnim(30, 4);}
        }
        if(entity.getUnitName().equals("Hakuza Witch"))
        {
            if(anim.equals("IDLE")) {entity.setAnim(30, 2);}
        }
    }
    
}