package styles;

import gfx.Colour;
import java.awt.Color;
import java.awt.Font;

public class Style
{
    
    public static Color colour(String ref)
    {
        if(ref.equals("MONGO_BUBBLE")) {return Colour.getColourRGB(11, 124, 159);}
        if(ref.equals("MONGO_CYAN")) {return Colour.getColourRGB(12, 96, 122);}
        if(ref.equals("MONGO_SHADOW")) {return Colour.getColourRGB(74, 74, 74);}
        if(ref.equals("PARCHMENT")) {return Colour.getColourRGB(226, 214, 165);}
        return Color.BLACK;
    }
    
    public static Font font(String ref)
    {
        if(ref.equals("INTRO_TEXT")) {return new Font("Segoe Print", Font.PLAIN, 34);}
        if(ref.equals("MODAL_STANDARD")) {return new Font("Segoe Print", Font.PLAIN, 18);}
        if(ref.equals("TITLE_OPTION")) {return new Font("Segoe Script", Font.BOLD, 28);}
        if(ref.equals("STANDARD")) {return new Font("Segoe Print", Font.PLAIN, 26);}
        return new Font("Times New Roman", Font.PLAIN, 14);
    }
    
}