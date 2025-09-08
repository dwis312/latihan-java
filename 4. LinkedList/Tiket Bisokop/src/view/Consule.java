package view;

import java.util.List;
import java.util.Scanner;

import controller.Controller;
import model.Bioskop;

public class Consule {
    private Controller ctrl;
    private int pilihan;
    private Scanner input = new Scanner(System.in);

    public Consule(Controller ctrl) {
        this.ctrl = ctrl;
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
        System.out.println("4. Pembayaran tiket");
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
                
                break;
            case 4:
                
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

    public int detailTiket(String nama, List<Bioskop> bioskop) {
        clearScreen();

        System.out.println("\n====== Pesan Tiket ======");
        System.out.println("Pesanan Atas Nama: " + nama);
        System.out.println("\nPilih Film: ");
        for (int i = 0; i < bioskop.size(); i++) {
            System.out.println(bioskop.get(i).getRoom());
        }
        System.out.print("\nPilihan :");
        int numPilihan = inputInt();
        return numPilihan;
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
