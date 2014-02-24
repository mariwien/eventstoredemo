package no.kino.command;

/**
 * Created by mariwien on 24/02/14.
 */
public class ReserverSeter{
    private String forestilling;
    private int reserverteSeter;


    public ReserverSeter(String forestilling, int reserverteSeter) {

        this.forestilling = forestilling;
        this.reserverteSeter = reserverteSeter;
    }

    public String getForestilling() {
        return forestilling;
    }

    public int getReserverteSeter() {
        return reserverteSeter;
    }


}
