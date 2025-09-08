package service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.Bioskop;
import model.Person;
import model.Room;

public class Service {
    private final String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final SecureRandom random = new SecureRandom();
    private Queue<Person> person = new LinkedList<>();
    private List<Bioskop> bioskop = new ArrayList<>();

    private String generateNik(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARSET.charAt(random.nextInt(CHARSET.length())));
        }
        return sb.toString();
    }

    public void generateCinema() {
        String idBioskop = generateNik(6);
        Bioskop newBioskop = new Bioskop(idBioskop, Room.Cinema1);
        bioskop.add(newBioskop);
        Bioskop newBioskop2 = new Bioskop(idBioskop, Room.Cinema2);
        bioskop.add(newBioskop2);
        Bioskop newBioskop3 = new Bioskop(idBioskop, Room.Cinema3);
        bioskop.add(newBioskop3);
        Bioskop newBioskop4 = new Bioskop(idBioskop, Room.Cinema4);
        bioskop.add(newBioskop4);
    }

    public Queue<Person> getPerson() {
        return person;
    }

    public List<Bioskop> getBioskop() {
        return bioskop;
    }

    public boolean addPerson(String nama) {
        String newIdPerson = generateNik(6);
        Person newPerson = new Person(newIdPerson, nama);
        return person.offer(newPerson);
    }

    public void orderTiket() {
        
    }

}
