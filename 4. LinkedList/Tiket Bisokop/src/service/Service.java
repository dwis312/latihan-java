package service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.Cinema;
import model.Person;
import model.Room;
import model.Tiket;

public class Service {
    private final String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final SecureRandom random = new SecureRandom();
    private Queue<Person> person = new LinkedList<>();
    private List<Cinema> cinema = new ArrayList<>();

    private String generateNumber(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARSET.charAt(random.nextInt(CHARSET.length())));
        }
        return sb.toString();
    }

    public void generateCinema() {
        cinema.add(new Cinema(Room.Cinema1));
        cinema.add(new Cinema(Room.Cinema2));
        cinema.add(new Cinema(Room.Cinema3));
        cinema.add(new Cinema(Room.Cinema4));
    }

    public Queue<Person> getPerson() {
        return person;
    }

    public List<Cinema> getCinema() {
        return cinema;
    }

    public boolean addPerson(String nama) {
        String newIdPerson = generateNumber(6);
        Person newPerson = new Person(newIdPerson, nama);
        return person.offer(newPerson);
    }

    public boolean orderTiket(Person person, int pilihanCinema) {
        if (pilihanCinema < 0 || pilihanCinema >= cinema.size()) {
            return false;
        }

        Cinema selectCinema = cinema.get(pilihanCinema);
        if (selectCinema.getKursiTersedia() > 0) {
            String noTiket = generateNumber(8);
            double hargaTiket = 50000;
            Tiket newTiket = new Tiket(noTiket, person.getIdPerson(), hargaTiket, selectCinema.getRoom());

            if (selectCinema.pesanTiket(newTiket)) {
                return true;
            }
        }
        return false;
    }

}
