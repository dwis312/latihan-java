package model;

import java.util.Objects;

public class Tiket {
    private String noTiket;
    private String idPerson;
    private double harga;
    private Room room;

    public Tiket(String noTiket, String idPerson, double harga, Room room) {
        this.noTiket = noTiket;
        this.idPerson = idPerson;
        this.harga = harga;
        this.room = room;
    }

    public String getNoTiket() { return noTiket; }
    public String getIdPerson() { return idPerson; }
    public double getHarga() { return harga; }
    public Room getRoom() { return room; }
    

    public void setNoTiket(String noTiket) { this.noTiket = noTiket; } 
    public void setIdPerson(String idPerson) { this.idPerson = idPerson; }
    public void setHarga(double harga) { this.harga = harga; }
    public void setRoom(Room room) { this.room = room; }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Tiket tiket = (Tiket) o;
        return Objects.equals(noTiket, tiket.noTiket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noTiket);
    }

}
