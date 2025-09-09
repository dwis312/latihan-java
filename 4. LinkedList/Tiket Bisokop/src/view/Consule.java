package view;

import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import controller.Controller;
import model.Cinema;

public class Consule {
    private Controller ctrl;
    private int pilihan;
    private Scanner input = new Scanner(System.in);

    public Consule(Controller ctrl) {
        this.ctrl = ctrl;
    }

    public void closeScanner() {
        if (input != null) {
            input.close();
            System.out.println("Menutup sumber daya.");
        }
    }

    public void displayMsg(String message) {
        System.out.println(message);
    }

    public void menu() {
        clearScreen();
        System.out.println("\n=== SISTEM ANTRIAN PEMBELIAN TIKET BIOSKOP ===");
        System.out.println("\nMenu");
        System.out.println("1. Pesan Tiket");
        System.out.println("2. Layani orang pertama");
        System.out.println("3. Lihat daftar antrian");
        System.out.println("4. Lihat daftar cinema");
        System.out.println("0. Keluar");
        System.out.print("\nPilihan :");
    }
    
    public boolean menuPilhan() {
        pilihan = inputInt();
        switch (pilihan) {
            case 1:
                ctrl.addPerson();
                enterToContinue();
                break;
            case 2:
                ctrl.servicePerson();
                enterToContinue();
                break;
            case 3:
                ctrl.lihatAntrian();
                enterToContinue();
                break;
            case 4:
                ctrl.lihatCinema();
                enterToContinue();
                break;
            case 0:
                System.out.println("Program berhenti.");
                return true;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                break;
        }
        return false;
    }

    public String pesanTiket() {
        clearScreen();
        System.out.println("\n====== Pesan Tiket ======");
        System.out.print("\nMasukkan nama: ");
        String nama = inputStr();
        return nama;
    }

    public int pilihCinema(String nama, List<Cinema> cinemas) {
        clearScreen();

        System.out.println("\n====== Pesan Tiket ======");
        System.out.println("Pesanan Atas Nama: " + nama);
        System.out.println("\nPilih Film: ");
        for (int i = 0; i < cinemas.size(); i++) {
            Cinema cinema = cinemas.get(i);
            System.out.println((i + 1) + ". " + cinema.getRoom().getDeskripsi() + " (Kursi tersedia: " + cinema.getKursiTersedia() + ")");
        }
        System.out.print("\nPilihan (1-" + cinemas.size() + ") :");
        int numPilihan = inputInt();
        return numPilihan - 1;
    }

    public void daftarAntiran(Queue<String> antrian) {
        clearScreen();
        System.out.println("\n====== Daftar Antrian ======");
        if (antrian.isEmpty()) {
            System.out.println("\nAntrian kosong.");
        } else {
            int count = 1;
            for (String nama : antrian) {
                System.out.println(count + ". " + nama);
                count++;
            }
        }
    }

    public void displayCinemas(List<Cinema> cinemas) {
        clearScreen();
        System.out.println("\n====== Daftar Cinema ======");
        for (Cinema cinema : cinemas) {
            System.out.println("Film: " + cinema.getRoom().getDeskripsi());
            System.out.println("  - Kursi Tersedia: " + cinema.getKursiTersedia());
            System.out.println("  - Kursi Terjual: " + cinema.getJumlahTiketTerjual());
            System.out.println("------------------------------------");
        }
    }

    public int inputInt() {
        boolean valid = false;
        int angka = -1;

        while (!valid) {
            try {
                String bukanNomor = input.nextLine();

                if (bukanNomor.trim().isEmpty()) {
                    System.out.println("Input tidak boleh kosong");
                } else {
                    angka = Integer.parseInt(bukanNomor);
                    valid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! harus angka");
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }

        }

        return angka;
    }

    public double inputDouble() {
        boolean valid = false;
        double angka = -1;

        while (!valid) {
            try {
                String bukanNomor = input.nextLine();

                if (bukanNomor.trim().isEmpty()) {
                    System.out.println("Input tidak boleh kosong");
                } else {
                    angka = Double.parseDouble(bukanNomor);
                    valid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! harus angka");
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }

        }

        return angka;
    }

    public String inputStr() {
        boolean valid = false;
        String stringInput = "";

        while (!valid) {
            stringInput = input.nextLine();
            if (stringInput.trim().isEmpty()) {
                System.out.println("Input tidak boleh kosong");
            } else {
                valid = true;
            }
        }

        return stringInput;
    }

    public void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.err.println("Gagal membersihkan layar.");
        }
    }

    public void enterToContinue() {
        System.out.println("\nTekan enter untuk kembali ke menu..");
        input.nextLine();
    }

}
