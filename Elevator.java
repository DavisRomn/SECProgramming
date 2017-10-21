import java.io.*;
import java.util.*;

class Elevator
{

    // Speed of the Elevator
    private volatile double speed;

    //Height in-comparison to the building with the bottom of the elevator
    private volatile double height;

    //Boolean for if already occupado
    private volatile boolean occupied;

    // Int value of direction: -1 is down, 0 is stopped and 1 is up
    private volatile int direction;

    //Acceleration of the Elevators
    private volatile double acceleration = 0.5;

    //Max speed
    private double MAX_SPEED = 3;

    // Destinations of Elevator in m
    public volatile Vector<Integer> destinations;

    private Thread movement;

    //Default Constructor
    Elevator()
    {
        occupied = false;
        speed = 0;
        height = 0;
        direction = 0;
        movement = new ElevatorThread(this);
        destinations = new Vector<Integer>();
        movement.start();
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

    public void addDestination(int dest)
    {
        if (!(dest == (int) (height / 3)) && !destinations.contains(dest)) {
            destinations.add(dest);
        }
    }

    public void moveUp(int floor, int ind)
    {
        try{
            direction = 1;
            while (height < floor * 3)
            {
                if (speed < MAX_SPEED){
                    speed += 0.5;
                }
                height += speed;
                if (height > floor * 3) {
                    height = floor * 3;
                }
                movement.sleep(995);
            }
            speed = 0;
            direction = 0;
            destinations.remove(ind);
        } catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    public void moveDown(int floor, int ind)
    {
        try{
            direction = -1;
            while (height > floor * 3)
            {
                if (speed < MAX_SPEED){
                    speed += 0.5;
                }
                height -= speed;
                if (height < floor * 3) {
                    height = floor * 3;
                }
                movement.sleep(995);
            }
            speed = 0;
            direction = 0;
            destinations.remove(ind);
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
