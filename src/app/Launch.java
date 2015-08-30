package app;

import states.Init;

public class Launch
{
    
    public static void main(String[] args)
    {
        String name = "KUMONGO";
        String author = "Jamie Purchase";
        String version = "0.1.0";
        String path = "C:/Users/Jamie/Documents/NetBeansProjects/Games/Kumongo/src/res/";
        //Colours.loadColours();
        //Fonts.loadFonts();
        new Engine(name, author, version, path, new Init()).start(false);
    }
    
}