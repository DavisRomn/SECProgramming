import java.io.*;
import java.util.*;
import java.lang.Math.*;

class Scheduling
{
    // Vector of the Elevators
    private Vector<Elevator> Elevators;

    private int numberOfFLoors = 6;

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

    public void addElevatorDestination(int elevator, int floor){
        Elevators.get(elevator).addDestination(floor * 3);
    }

    public int elevatorToCall(int callDir, int callFloor)
    {
        Vector<Double> score = new Vector<Double>();
        int N = numberOfFLoors - 1;
        for(int i = 0; i < Elevators.size(); i++){
            double h = Elevators.get(i).getHeight() / 3;
            double d = Elevators.get(i).getDirection();
            if(callDir == 1 && d != 0){
                if(callFloor > h && d == 1){
                    score.add(i, N + 2.3 - (Math.abs(h - callFloor)));
                } else if (callFloor < h && d == -1){
                    score.add(i, N + 1.1 - (Math.abs(h - callFloor)));
                } else if (callFloor > h && d == -1){
                    score.add(i, 1.0);
                }
            } else if (callDir == -1 && d != 0) {
                if(callFloor < h && d == -1){
                    score.add(i, N + 2.3 - (Math.abs(h - callFloor)));
                } else if(callFloor > h && d == 1){
                    score.add(i, N + 1.1 - (Math.abs(h - callFloor)));
                } else if(callFloor < h && d == 1){
                    score.add(i, 1.0);
                }
            } else {
                score.add(i, N + 1.2 - (Math.abs(h - callFloor)));
            }
        }
        int elevatorReturn = 0;
        for(int i = 1; i < Elevators.size(); i++){
            if (score.get(i) > score.get(i - 1)){
                elevatorReturn = i;
            }
        }
        return elevatorReturn;
    }

    public static void main(String []arg)
    {
        Scheduling A = new Scheduling();
        A.addElevatorDestination(0, 3);
    }
}
