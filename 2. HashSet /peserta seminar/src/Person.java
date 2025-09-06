import java.util.Objects;

public class Person {
    private String nik;
    private String nama;
    private int usia;
    private Gender gender;

    public Person(String nik, String nama, int usia, Gender gender) {
        this.nik = nik;
        this.nama = nama;
        this.usia = usia;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Person person = (Person) o;
        return Objects.equals(nama, person.nama);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nama);
    }

    public String getNik() {
        return nik;
    }
    
    public String getNama() {
        return nama;
    }
    public int getUsia() {
        return usia;
    }

    public Gender getGender() {
        return gender;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setUsia(int usia) {
        this.usia = usia;
    }

    public void setgender(Gender gender) {
        this.gender = gender;
    }

}
