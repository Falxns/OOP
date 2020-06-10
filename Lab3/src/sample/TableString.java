package sample;

import Tanks.Tanks;

public class TableString {
    private Tanks tank;
    private String tankName;
    public TableString(Tanks tank, String tankName){
        setTank(tank);
        setTankName(tankName);
    }
    public TableString() {};

    public Tanks getTank() {
        return tank;
    }

    public void setTank(Tanks tank) {
        this.tank = tank;
    }

    public void setTankName(String tankName) {
        this.tankName = tankName;
    }

    public String getTankName() {
        return tankName;
    }
}
