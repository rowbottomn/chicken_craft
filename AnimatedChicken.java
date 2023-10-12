import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnimatedChicken here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnimatedChicken extends Chicken
{
    
    private static int[] startingFrames = {0, 4, 8, 12, 16, 18, 20, 22, 24};
    private static int[] frameLengths = {4, 4, 4, 4, 4, 2, 2, 2, 4};
    //0-3 is idle, 4-7 is walking right
    //8-11 walk ing up right, 12-15, - walking left up, 
    //16-17 is sleeping left, 18-19 sleeping right, 20-21 sleeping away
    //22-23 sleeping towards
    //24-27 pecking
    int state = 0;//state 0 - 9
    int animationFrameRate = 20;
    
    public AnimatedChicken(){
        super();
    }
    
    /**
     * Act - do whatever the AnimatedChicken wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
        
    }
}
