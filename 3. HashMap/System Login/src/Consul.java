import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Consul {
    private Scanner input = new Scanner(System.in);
    private int pilihan = -1;
    private boolean exit = false;
    private final String ADMIN_USERNAME = "admin";
    private final String ADMIN_PASSWORD = "admin";

    private Service service = new Service();

    public Consul() {
        initializeAdminAccount();
    }

    public void run() {
        while (!exit) {
            menu();
            pilihan = inputInt();
            exit = pilihanMenu(pilihan);
        }
        System.out.println("Program berhenti.");
        input.close();
    }

    public void menu() {
        clearScreen();
        System.out.println("\n====== System Login Sederhana ======");
        System.out.println("1. Tambah Akun");
        System.out.println("2. Login");
        System.out.println("0. keluar");
        System.out.println("--------------------------------------");
        System.out.print("Pilihan anda: ");
    }

    public boolean pilihanMenu(int num) {
        boolean valid = false;

        switch (num) {
            case 1:
                tambahData();
                break;
            case 2:
                auth();
                break;
            case 0:
                valid = true;
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }

        return valid;
    }

    private void tambahData() {
        clearScreen();
        System.out.println("\n====== Tambah Akun ======");
        

        System.out.print("\nMasukan Username        : ");
        String username = inputStr();
        
        System.out.print("Masukan Password        : ");
        String password = inputStr();
        
        if (service.addAkun(username, password)) {
            System.out.println("Berhasil ditambahkan Akun baru.");
        } else {
            System.out.println("[" + username + "] sudah terdaftar. gunakan usernama lainnya.");
        }
        enterToContinue();
    }
    
    private void auth() {
        clearScreen();
        System.out.println("\n====== Login ======");

        System.out.print("\nMasukan Username        : ");
        String username = inputStr();
        
        System.out.print("Masukan Password        : ");
        String password = inputStr();

        if (service.cekUser(username)) {
            if (service.login(username, password)) {
                System.out.println("\nLogin berhasil! Selamat datang, " + username + "!");
                if (username.equals(ADMIN_USERNAME)) {
                    displayAkun(username, password);
                }
            } else {
                System.out.println("\nPassword salah");
            }
        } else {
            System.out.println("\nUsername tidak ditemukan!");
        }
        enterToContinue();
    }
    
    private void displayAkun(String username, String password) {
        clearScreen();
        HashMap<String, Person> allAkun = service.getAll();

        if (!allAkun.isEmpty()) {
            System.out.println("\n====== Daftar Akun ======");
            System.out.println("");
            
            System.out.printf("| %-3s | %-10s | %-10s | %-15s |\n","No","ID","Username","Password");
            System.out.println("-------------------------------------------");
            
            int i = 1;
            for (Map.Entry<String, Person> entry: allAkun.entrySet()) {
                Person person = entry.getValue();

                if (!person.getUsername().equals(ADMIN_USERNAME)) {
                    System.out.printf("| %-3s | %-10s | %-10s | %-15s |\n", i++,person.getId(),person.getUsername(),person.getPassword());
                }

                if (i == 1) {
                    System.out.println("|                  Tidak ada akun pengguna                  |");
                }
            }

            System.out.println("-------------------------------------------");
        } else {
            System.out.println("Data masih kosong.");
        }
        enterToContinue();

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

    private void initializeAdminAccount() {
        service.addAkun(ADMIN_USERNAME, ADMIN_PASSWORD);
    }

}