import java.util.List;
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
        System.out.println("\n====== Manajemen Data Mahasiswa ======");
        System.out.println("1. Tambah mahasiswa");
        System.out.println("2. Hapus mahasiswa berdasarkan NIM");
        System.out.println("3. Tampilkan seluruh data mahasiswa");
        System.out.println("4. Cari mahasiswa berdasarkan NIM");
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
            case 4:
                cariData();
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
        System.out.println("\n====== Tambah Data Mahasiswa ======");
        
        System.out.print("\nMasukan nama: ");
        String nama = inputStr();

        
        System.out.print("Masukan ipk: ");
        double ipk = inputDouble();

        String pesan = helper.tambah(nama, ipk);
        System.out.println(pesan);
        enterToContinue();
    }

    private void hapusData() {
        clearScreen();
        if (helper.getAll() != null) {
            System.out.println("\n====== Hapus Data Mahasiswa ======");
            
            System.out.print("Masukan NIM Mahasiswa: ");
            String nim = inputStr();
            
            Mahasiswa mhs = helper.cariByNim(nim);
            if (mhs != null) {
                String nama = mhs.getNama();
                System.out.println("\nNIM Cocok       : " + mhs.getNim());
                System.out.println("Nama Mahasiswa  : " + nama);
                
                String konfirm;
                System.out.println("\nHapus ? (ya / batal)");
                konfirm = inputStr();

                if (konfirm.equalsIgnoreCase("ya")) {
                    helper.hapus(nim);

                    System.out.println("Mahasiswa bernama [" + nama + "] berhasil dihapus");
                } else if (konfirm.equalsIgnoreCase("batal")) {
                    System.out.println("Dibatalkan");
                } else {
                    System.out.println("konfirmasi tidak valid.");
                }
            } else {
                System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
            }
        } else {
            System.out.println("Data masih kosong.");
        }
        enterToContinue();
    }
    
    private void allData() {
        clearScreen();
        List<Mahasiswa> list = helper.getAll();

        if (list != null) {
            System.out.println("\n====== List Data Mahasiswa ======");
            System.out.println("");
            
            System.out.printf("| %-3s | %-10s | %-10s | %-7s |\n","No","NIM","Nama","IPK");
            System.out.println("-------------------------------------------");
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("| %-3s | %-10s | %-10s | %-7s |\n", i+1,list.get(i).getNim(),list.get(i).getNama(),list.get(i).getIpk());
            }
            System.out.println("-------------------------------------------");
        } else {
            System.out.println("Data masih kosong.");
        }
        enterToContinue();
    }

    private void cariData() {
        if (helper.getAll() != null) {
            Mahasiswa list;
            
            System.out.println("\n====== Cari Mahasiswa ======");

            System.out.print("\nMasukan NIM Mahasiswa: ");
            String nim = inputStr();
            
            list = helper.cariByNim(nim);
            
            if (list != null) {
                System.out.printf("| %-3s | %-10s | %-10s | %-7s |\n","No","NIM","Nama","IPK");
                System.out.println("-------------------------------------------");
                System.out.printf("| %-3s | %-10s | %-10s | %-7s |\n", 1,list.getNim(),list.getNama(),list.getIpk());
                System.out.println("-------------------------------------------");
                
            } else {
                System.out.println("Data tidak ditemukan.");
            }
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
