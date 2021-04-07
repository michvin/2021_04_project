package instr.control.shm.simulatedhardwaremodule.model;

import instr.control.shm.simulatedhardwaremodule.controller.InstrumentController;

import java.util.Random;

public class InstrumentAction extends Thread{


    private int number = -2;
    private int duration = 0;
    public void run()
    {
        InstrumentController.setHardwareStatus("Started");
        long timeToStop = System.currentTimeMillis()+duration*1000;
        while(System.currentTimeMillis() < timeToStop) {
            InstrumentController.setTimeRemaining((timeToStop - System.currentTimeMillis())/1000);
            Random r = new Random();
            number = r.nextInt(101);//(int) Math.random(101);
            System.out.println("Thread is running..." + number);
            InstrumentController.setCurrentReturnValue(number);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public int getNumber() {
        return number;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
