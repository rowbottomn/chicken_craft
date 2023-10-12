import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Chicken here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Chicken extends Actor
{
    int hearts = 4;
    int dirX = Greenfoot.getRandomNumber(3)-1;
    int dirY = 1;
    int animationTimer = 0;
    int speed = 3;
    boolean isHopping;
    int hopTimer = Greenfoot.getRandomNumber(6)+5;
    int numHops = Greenfoot.getRandomNumber(12)-5;
    //note that the world preloads the images into the array below ONCE
    static GreenfootImage[] images = new GreenfootImage[28];

    GreenfootImage img = getImage();
    GreenfootImage right;
    GreenfootImage left;
    
    StatusBar health;
    StatusBar happiness;
    StatusBar hunger = new StatusBar(this, 50, 0.1, -20, 20, 2);
    
    boolean selected = false;
    boolean dead = false;
    
    World world;
    
    public Chicken(){
        //load all the imag
        img.scale(60,60);
        left = new GreenfootImage(img);
        right = new GreenfootImage(img);
        right.mirrorHorizontally();
        health = new StatusBar(this, 4, 0, -20, 30, 0);
        happiness = new StatusBar(this, 50, 0.01, -20, 20, 1);
        hunger = new StatusBar(this, 50, 0.01, -20, 10, 2);
    }
    /**
     * Act - do whatever the Chicken wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (dead){
            setImage(images[17]);
            return;
        }
        if (world == null){
            world = getWorld();
            world.addObject(health, getX(), getY());
            world.addObject(happiness, getX(), getY());
            world.addObject(hunger, getX(), getY());
            
        }
        animationTimer ++;       
        
        if (animationTimer%140 == 0){
            //turn(Greenfoot.getRandomNumber(181)-90);
                
        }
        
        else if (animationTimer%(hopTimer*6) == 0){
            dirX = Greenfoot.getRandomNumber(3)-1;
            dirY = Greenfoot.getRandomNumber(3)-1;
            if (dirX>0){
              setImage(right);  
            }
            if (dirX<0){
              setImage(left);
            }
            //img.scale(Math.abs(img.getWidth()*dirX), img.getHeight());
            hopTimer = Greenfoot.getRandomNumber(6)+5;
            numHops = Greenfoot.getRandomNumber(12)-6;
            //isHopping = true;
        }
        if (numHops > 0){
            if (animationTimer%12 == 0){
                setLocation(getX()+dirX*1, getY()+dirY*2);    
            }
            else if (animationTimer%12 == 1){
                setLocation(getX()+dirX*3, getY()+2+dirY*2);    
            }
            else if (animationTimer%12 == 2){
                setLocation(getX()+dirX*3, getY()+4+dirY*2);    
            }
            else if (animationTimer%12 == 3){
                setLocation(getX()+dirX*3, getY()+dirY*2);    
            }
            else if (animationTimer%12 == 4){
                setLocation(getX()+dirX*3, getY()-2+dirY*2);    
            }
            else if (animationTimer%12 == 5){
                setLocation(getX()+dirX*3, getY()-4+dirY*2);    
                numHops--;
            }
            //else if (animationTimer%12 == 6){
            //    setLocation(getX()+1, getY());    
            //    numHops--;
            //}
        }
        
        else{
                //setLocation(getX()+dirX, getY());    
        }
        
        if (selected){
        
            getImage().scale(80,80); 
        }
        else{
            getImage().scale(60,60); 
        }
        
    }
    
    public void hit(){
        health.value --;
        happiness.value -=0.5;
    }
    
    public void feed(){
        hunger.value++;
        if(hunger.value > hunger.maxValue){
            health.value --;
            happiness.value-=0.5;
        }
    }
    
    public void play(){
        happiness.value++;
        if (happiness.value>happiness.maxValue){
            happiness.value=happiness.maxValue;
        }
    }
}
