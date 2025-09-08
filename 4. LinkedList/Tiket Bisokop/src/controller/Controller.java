package controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import model.Bioskop;
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
        
        Person antrian = service.getPerson().poll();
        List<Bioskop> cinema = service.getBioskop();

        if (antrian != null) {
            if (!cinema.isEmpty()) {
                String namaAntrian = antrian.getNama();
                consule.detailTiket(namaAntrian, cinema);
            } else {
                System.out.println("kosong");
            }
        } else {
            consule.displayMsg("Antrian kosong! Tidak ada yang dilayani.");
        }
        
    }

}
