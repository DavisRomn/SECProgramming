import java.util.Vector<E>;

class Scheduling
{
    // Vector of the Elevators
    private Vector<Elevator> Elevators;

    //
    private volatile Vector<Vector<int>> ElevatorDestinations;

    Scheduling()
    {
        for(int i = 0; i < 3; i++){
            Elevators.add(new Elevator());
        }
    }

    public void callUp(int elevatorNumber, int floor)
    {
        ElevatorDestinations.add(elevatorNumber).add(floor);
    }

    public void callDown(int elevatorNumber, int floor)
    {
        ElevatorDestinations.add(elevatorNumber).add(floor);
    }

    // Returns the height of the specified elevator in m
    public int getElevatorLocation(int elevatorNumber)
    {
        return Elevators.get(i).getHeight();
    }
}
