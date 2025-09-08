package model;
import java.util.Objects;

public class Person {
    private String idPerson;
    private String nama;

    public Person(String idPerson, String nama) {
        this.idPerson = idPerson;
        this.nama = nama;
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

    public String getIdPerson() {
        return idPerson;
    }
    
    public String getNama() {
        return nama;
    }

    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

}