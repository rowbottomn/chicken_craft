import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StatusBar extends Actor
{
    static Color[] colors = {new Color(0, 255, 0),new Color(150, 150, 0),new Color(0, 150, 155)};
    Chicken owner;
    double value;
    int maxValue;
    int width = 50;
    int height = 10;
    int xOffset = 0;
    int yOffset = 0;
    Color col;
    double decayRate = 0.1;
    GreenfootImage img;
    
    World world;
    public StatusBar(Chicken owner){
        this.owner = owner;
    }
    public StatusBar(Chicken owner, int max, double decay, int x, int y, int c){
        this.owner = owner;
        maxValue = max;
        value = (double)max;
        decayRate = decay;
        xOffset = x;
        yOffset = y;
        col = colors[c];
        img = getImage();
        img.clear();
        img.setColor(col);
        img.scale(width, height);
        img.fill();
        setImage(img);
    }
    
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (world == null){
            world = getWorld();
        }
        if (value > 2){
            value -= decayRate;
            img.scale((int)(value*width/maxValue), height);
        }
        else{
            owner.dead = true;
        }
        if (owner.selected&&!owner.dead){
           setLocation(owner.getX()-(int)(value*width/2/maxValue), owner.getY()-yOffset );
           img.setTransparency(255); 
        }
        else{
            img.setTransparency(0); 
        }
    }
}
