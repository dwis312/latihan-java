package model;

public class Bioskop {
    private String idBioskop;
    private Room room;

    public Bioskop(String idBioskop, Room room) {
        this.idBioskop = idBioskop;
        this.room = room;
    }

    public String getidBioskop() {
        return idBioskop;
    }

    public Room getRoom() {
        return room;
    }

    public void setidBioskop(String idBioskop) {
        this.idBioskop = idBioskop;
    }


    public void setRoom(Room room) {
        this.room = room;
    }
}
