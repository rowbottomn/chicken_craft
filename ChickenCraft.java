import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChickenCraft extends World
{
    private Chicken[] chickens;
    Chicken chicken;
    Chicken lastChicken;
    private int numChickens = 10;
    private MouseInfo mouseinfo;
    MouseCursor mouse;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public ChickenCraft()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1); 
        TitleScreen title = new TitleScreen();
        title.game = this;
        mouse = new MouseCursor();
        addObject(mouse, -100,-100);
        //load the chicken images
        for (int i = 0; i < Chicken.images.length; i++){
            Chicken.images[i] = new GreenfootImage("chicken_"+i+".png");
        }
        
        
        for (int i = 0; i < 10; i++){
            Chicken c = new Chicken();
            addObject(c, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
        Greenfoot.setWorld(title);
    }
    
    public void act(){
    
    }
}
