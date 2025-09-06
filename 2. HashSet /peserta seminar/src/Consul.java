import java.util.HashSet;
import java.util.Scanner;

public class Consul {
    private Scanner input = new Scanner(System.in);
    private int pilihan = -1;
    private boolean exit = false;

    private Helper helper = new Helper();

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
        System.out.println("\n====== Manajemen Peserta Seminar ======");
        System.out.println("1. Tambah Peserta");
        System.out.println("2. Hapus Peserta");
        System.out.println("3. Tampilkan Seluruh Peserta");
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
                hapusData();
                break;
            case 3:
                allData();
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
        System.out.println("\n====== Tambah Peserta ======");
        
        System.out.print("\nMasukan Nama        : ");
        String nama = inputStr();

        
        System.out.print("Masukan Usia        : ");
        int usia = inputInt();

        System.out.println("Jenis Kelamin ");
        System.out.println("1. Pria");
        System.out.println("2. Wanita");
        System.out.print("Pilih jenis kelamin : ");
        int numPilih = inputInt();
        
        Gender gender;
        if (numPilih == 1) {
            gender = Gender.PRIA;
        } else if (numPilih == 2) {
            gender = Gender.WANITA;
        } else {
            System.out.println("Pilihan tidak valid. jenis kelamin daftarkan acak.");
            gender = Gender.PRIA;
        }
        
        if (helper.tambah(nama, usia, gender)) {
            System.out.println("Peserta berhasil ditambahkan.");
        } else {
            System.out.println("Nama peserta [" + nama + "] sudah terdaftar. gunakan nama lainnya.");
        }
        enterToContinue();
    }

    private void hapusData() {
        clearScreen();
        if (helper.getAll() != null) {
            System.out.println("\n====== Hapus Peserta ======");
            
            System.out.print("Masukan Nama: ");
            String nama = inputStr();
            
            Person ps = helper.cari(nama);
            if (ps != null) {
                System.out.println("Nama          : " + ps.getNama());
                System.out.println("Usia          : " + ps.getUsia());
                System.out.println("Jenis kelamin : " + ps.getGender());
                
                String konfirm;
                System.out.println("\nHapus ? (ya / batal)");
                konfirm = inputStr();

                if (konfirm.equalsIgnoreCase("ya")) {
                    helper.hapus(nama);

                    System.out.println("Peserta bernama [" + ps.getNama() + "] berhasil dihapus");
                } else if (konfirm.equalsIgnoreCase("batal")) {
                    System.out.println("Dibatalkan");
                } else {
                    System.out.println("konfirmasi tidak valid.");
                }
            } else {
                System.out.println("Peserta beranama " + nama + " tidak ditemukan.");
            }
        } else {
            System.out.println("Data masih kosong.");
        }
        enterToContinue();
    }
    
    private void allData() {
        clearScreen();
        HashSet<Person> allPeserta = helper.getAll();

        if (!allPeserta.isEmpty()) {
            System.out.println("\n====== List Peserta ======");
            System.out.println("");
            
            System.out.printf("| %-3s | %-10s | %-10s | %-7s | %-15s |\n","No","NIK","Nama","Usia", "Jenis Kelamin");
            System.out.println("-------------------------------------------");
            
            int i = 1;
            for (Person list: allPeserta) {
                System.out.printf("| %-3s | %-10s | %-10s | %-7s | %-15s |\n", i++,list.getNik(),list.getNama(),list.getUsia(), list.getGender());
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

}