import java.util.Vector<E>;

class Elevator
{

    // Speed of the Elevator
    public volatile double speed;

    //Height in-comparison to the building with the bottom of the elevator
    public double height;

    //Boolean for if already occupado
    public boolean occupied;

    // Int value of direction: -1 is down, 0 is stopped and 1 is up
    public volatile int direction;

    //Acceleration of the Elevators
    private double acceleration = 0.5;

    //Max speed
    private double MAX_SPEED = 3;

    // Destinations of Elevator in m
    private Vector<int> destinations;

    //Default Constructor
    Elevator()
    {
        occupied = false;
        speed = 0;
        height = 0;
        direction = 0;
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

    public Vector<int> getDestinations()
    {
        return destinations;
    }

    public void moveUp(int floor)
    {
        direction = 1;
        destinations.add(floor * 3);
        /////////////////////////////////////////////////////////////////////////////////////// FIX TIMING
        while (height < newDest * 3)
        {
            speed + 0.5;
            height + speed;
        }
        direction = 0;
        destinations.remove(floor * 3);
    }
    public void moveDown(int floor)
    {
        destinations.add(floor * 3);
        direction = -1;
        /////////////////////////////////////////////////////////////////////////////////////// FIX TIMING
        while (height > newDest * 3)
        {
            speed + 0.5;
            height - speed;
        }
        direction = 0;
        destinations.remove(floor * 3);
    }

    public boolean getStopped()
    {
        if (direction = 0){
            return true;
        } else {
            return false;
        }
    }
}
