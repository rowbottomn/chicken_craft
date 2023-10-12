import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MouseCursor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MouseCursor extends Actor
{
    Chicken chicken;
    Chicken lastChicken;
    MouseInfo info;
    GreenfootImage img = getImage();
    
    public MouseCursor(){
        img.setTransparency(120);
        
    }
    
    /**
     * Act - do whatever the MouseCursor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        info = Greenfoot.getMouseInfo();
        if (info == null){
            return;
            
        }
        
        setLocation(info.getX(), info.getY());
        //try to get a chicken object
        chicken = (Chicken)getOneIntersectingObject(Chicken.class);
        getWorld().showText(""+chicken, 100,100);
        
        if (chicken != null){
            if (chicken != lastChicken){
                chicken.selected = true;
                if(lastChicken != null){
                    lastChicken.selected = false;
                }
                lastChicken = chicken;
            }
        }
        else {
            if(lastChicken != null){
              lastChicken.selected = false;
              getWorld().showText(""+lastChicken.selected, 100,300);
              lastChicken = null;
              
            }
            else{
                lastChicken = null;
            }
        }
        /*
        if(chicken != null && info.getButton()== 0){
            chicken.hit();
        }
        */
    }
}
