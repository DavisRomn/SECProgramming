import java.io.*;
import java.util.*;

class ElevatorThread extends Thread
{
    public Elevator e;

    ElevatorThread(Elevator el)
    {
        e = el;
    }
    @Override
    public void run()
    {
        while(true){
            for (int i = 0; i < e.destinations.size(); i++){
                if (e.destinations.get(i) > e.getHeight() / 3 && e.getDirection() == 1){
                    e.moveUp(e.destinations.get(i), i);
                } else if(e.destinations.get(i) < e.getHeight() / 3 && e.getDirection() == -1){
                    e.moveDown(e.destinations.get(i), i);
                } else if(e.destinations.get(i) > e.getHeight() / 3 && e.getDirection() == 0 && e.destinations.get(i) != e.getHeight() / 3){
                    e.moveUp(e.destinations.get(i), i);
                } else if(e.destinations.get(i) < e.getHeight() / 3 && e.getDirection() == 0 && e.destinations.get(i) != e.getHeight() / 3){
                    e.moveDown(e.destinations.get(i), i);
                }
            }
        }
    }
}
