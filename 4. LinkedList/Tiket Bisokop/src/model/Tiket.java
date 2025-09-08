package model;

import java.util.Objects;

public class Tiket {
    private String noTiket;
    private String idPerson;
    private int jumlah;
    private double harga;

    public Tiket(String noTiket, String idPerson, int jumlah, double harga, Room room) {
        this.noTiket = noTiket;
        this.idPerson = idPerson;
        this.jumlah = jumlah;
        this.harga = harga;  
    }

    public String getNoTiket() { return noTiket; }
    public String getIdPerson() { return idPerson; }
    public int getJumlah(){ return jumlah; }
    public double getHarga() { return harga; }
    

    public void setNoTiket(String noTiket) { this.noTiket = noTiket; } 
    public void setIdPerson(String idPerson) { this.idPerson = idPerson; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }
    public void setHarga(double harga) { this.harga = harga; }

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
