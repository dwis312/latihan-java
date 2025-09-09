package controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.Cinema;
import model.Person;
import service.Service;
import view.Consule;

public class Controller {
    private Consule consule;
    private Service service = new Service();
    

    private boolean exit;
    

    public void run() {
        service.generateCinema();
        consule = new Consule(this);
        
        while (!exit) {
            consule.menu();
            exit = consule.menuPilhan();
        }
        consule.closeScanner();
    }

    public void addPerson() {
        String nama = consule.pesanTiket();

        if (service.addPerson(nama)) {
            consule.displayMsg("Pesanan tiket atas nama " + nama + " berhasil dibuat.");
        } else {
            consule.displayMsg("Pesanan tiket atas nama " + nama + " gagal dibuat.");
        }

    }

    public void servicePerson() {
        Person antrian = service.getPerson().peek();
        
        if (antrian != null) {
            List<Cinema> cinema = service.getCinema();

            int pilihanCinema = consule.pilihCinema(antrian.getNama(), cinema);

            if (service.orderTiket(antrian, pilihanCinema)) {
                service.getPerson().poll();
                String namaAntrian = antrian.getNama();
                consule.displayMsg("Tiket berhasil dipesan untuk " + namaAntrian + ".");
            } else {
                consule.displayMsg("Gagal memesan tiket. Mungkin kursi sudah habis atau pilihan tidak valid.");
            }
        } else {
            consule.displayMsg("Antrian kosong! Tidak ada yang dilayani.");
        }
    }

    public void lihatAntrian() {
        Queue<Person> antrian = service.getPerson();
        Queue<String> namaAntrian = new LinkedList<>();

        for (Person person : antrian) {
            namaAntrian.add(person.getNama());
        }
        consule.daftarAntiran(namaAntrian);
    }

    public void lihatCinema() {
        List<Cinema> cinema = service.getCinema();
        consule.displayCinemas(cinema);
    }

}
