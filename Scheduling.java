import java.util.Vector;

class Scheduling
{
    // Vector of the Elevators
    private Vector<Elevator> Elevators;

    //
    private volatile Vector<Vector<Integer>> ElevatorDestinations;

    Scheduling()
    {
        Elevators = new Vector<Elevator>();
        ElevatorDestinations = new Vector<Vector<Integer>>();
        for(int i = 0; i < 3; i++){
            Elevators.add(new Elevator());
        }
    }

    public void callUp(int elevatorNumber, int floor)
    {
        ElevatorDestinations.get(elevatorNumber).add(floor);
    }

    public void callDown(int elevatorNumber, int floor)
    {
        //ElevatorDestinations.add(elevatorNumber).add(floor);
        ElevatorDestinations.get(elevatorNumber).add(floor);
    }

    // Returns the height of the specified elevator in m
    public double getElevatorLocation(int elevatorNumber)
    {
        return Elevators.get(elevatorNumber).getHeight();
    }
}
