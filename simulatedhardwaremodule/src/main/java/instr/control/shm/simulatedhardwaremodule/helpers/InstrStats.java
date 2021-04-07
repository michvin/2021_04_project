package instr.control.shm.simulatedhardwaremodule.helpers;


public class InstrStats {

    private int currentReturnValue;
    private long timeRemaining;
    private String hardwareStatus;
    private String connectionStatus;

    public InstrStats(int currentReturnValue, long timeRemaining, String hardwareStatus, String connectionStatus){
        this.connectionStatus = connectionStatus;
        this.currentReturnValue = currentReturnValue;
        this.hardwareStatus = hardwareStatus;
        this.timeRemaining = timeRemaining;
    }


    public int getCurrentReturnValue() {
        return currentReturnValue;
    }

    public void setCurrentReturnValue(int currentReturnValue) {
        this.currentReturnValue = currentReturnValue;
    }

    public long getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(long timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public String getHardwareStatus() {
        return hardwareStatus;
    }

    public void setHardwareStatus(String hardwareStatus) {
        this.hardwareStatus = hardwareStatus;
    }

    public String getConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(String connectionStatus) {
        this.connectionStatus = connectionStatus;
    }





}
