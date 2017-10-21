import java.io.*;
import java.util.*;

class Elevator extends Thread
{

    // Speed of the Elevator
    public volatile double speed;

    //Height in-comparison to the building with the bottom of the elevator
    public volatile double height;

    //Boolean for if already occupado
    public volatile boolean occupied;

    // Int value of direction: -1 is down, 0 is stopped and 1 is up
    public volatile int direction;

    //Acceleration of the Elevators
    private volatile double acceleration = 0.5;

    //Max speed
    private double MAX_SPEED = 3;

    // Destinations of Elevator in m
    private volatile Vector<Integer> destinations;

    private Thread movement;

    //Default Constructor
    Elevator()
    {
        occupied = false;
        speed = 0;
        height = 0;
        direction = 0;
        movement = new Thread();
        movement.start();
    }

    public void run()
    {
        while(true){

        }
    }

    // Returns the speed of the Elevator
    public double getSpeed()
    {
        return speed;
    }

    // Returns the height (Location) of the elevator
    public double getHeight()
    {
        return height;
    }

    //Get direction value
    public int getDirection()
    {
        return direction;
    }

    public Vector<Integer> getDestinations()
    {
        return destinations;
    }

    public void moveUp(int floor)
    {
        try{
            direction = 1;
            destinations.add(floor * 3);
            while (height < floor * 3)
            {
                speed += 0.5;
                height += speed;
                movement.sleep(1000);
            }
            direction = 0;
            destinations.remove(floor * 3);
        } catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    public void moveDown(int floor)
    {
        try{
            destinations.add(floor * 3);
            direction = -1;
            while (height > floor * 3)
            {
                speed += 0.5;
                height -= speed;
                movement.sleep(1000);
            }
            direction = 0;
            destinations.remove(floor * 3);
        } catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public boolean getStopped()
    {
        if (direction == 0){
            return true;
        } else {
            return false;
        }
    }
}
