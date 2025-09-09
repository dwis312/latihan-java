package model;

import java.util.HashSet;
import java.util.Set;

public class Cinema {
    private final int KAPASITAS_MAKS = 40;
    private Room room;
    private int kursiTersedia;
    private Set<Tiket> tiketTerjual;

    public Cinema(Room room) {
        this.room = room;
        this.kursiTersedia = KAPASITAS_MAKS;
        this.tiketTerjual = new HashSet<>();
    }

    public boolean pesanTiket(Tiket tiket) {
        if (kursiTersedia > 0) {
            if (tiketTerjual.add(tiket)) { 
                kursiTersedia--;
                return true;
            }
        }
        return false;
    }

    public Room getRoom() {
        return room;
    }

    public int getKursiTersedia() {
        return kursiTersedia;
    }

    public Set<Tiket> getTiketTerjual() {
        return tiketTerjual;
    }

    public int getJumlahTiketTerjual() {
        return tiketTerjual.size();
    }
}
