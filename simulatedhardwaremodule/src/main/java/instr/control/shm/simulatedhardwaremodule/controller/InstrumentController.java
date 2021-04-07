package instr.control.shm.simulatedhardwaremodule.controller;

import instr.control.shm.simulatedhardwaremodule.helpers.InstrStats;
import instr.control.shm.simulatedhardwaremodule.model.CommandSet;
import instr.control.shm.simulatedhardwaremodule.model.InstrumentAction;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class InstrumentController {

    public static void setCurrentReturnValue(int currentReturnValue) {
        currentReturnValue1 = currentReturnValue;
    }
    public static void setHardwareStatus(String hardwareStatus) {
        hardwareStatus1 = hardwareStatus;
    }

    public static void setTimeRemaining(long timeRemaining) {
        timeRemaining1 = timeRemaining;
    }

    private static long timeRemaining1;


    private static int currentReturnValue1;
    private static String hardwareStatus1 = "Stopped";
    private String connectionStatus = "NotConnected";


    @GetMapping("/instrumentStats")
    @CrossOrigin("*")
    @ResponseBody
    public InstrStats returnModuleStatus() {
        return new InstrStats(this.currentReturnValue1, this.timeRemaining1, this.hardwareStatus1, this.connectionStatus);
    }

    @PostMapping("/instrumentControl")
    @CrossOrigin("*")
    public int controlModule(@RequestBody CommandSet commandSet){
        String command = commandSet.getAction();
        int duration = commandSet.getDuration();
        if(commandSet.getAction().equalsIgnoreCase("Start")){
            InstrumentAction ia = new InstrumentAction();
            ia.setDuration(duration);
            ia.run();
            hardwareStatus1 = "Stopped";
        }
        else if(commandSet.getAction().equalsIgnoreCase("Stop")){

        }
        return currentReturnValue1;
    }

    public int getCurrentReturnValue() {

        return currentReturnValue1;
    }



}