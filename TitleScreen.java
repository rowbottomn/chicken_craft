import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    ChickenCraft game;
    
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        showText("ChickenCraft", 800, 100);
        showText("Click to Continue", 800, 400);

    }
    
    public void act(){
        if (Greenfoot.mouseClicked(this)){
            
            Greenfoot.setWorld(game);
        }
        
    }
}
