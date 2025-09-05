import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    private static final String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom random = new SecureRandom();
    private ArrayList<Mahasiswa> mahasiswa = new ArrayList<>();
    
    
    public static String generateNim(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARSET.charAt(random.nextInt(CHARSET.length())));
        }
        return sb.toString();
    }
    
    public String tambah(String nama, double ipk) {
        StringBuilder pesan = new StringBuilder();

        String nim = generateNim(6);
        Mahasiswa newMahasiswa = new Mahasiswa(nim, nama, ipk);
        mahasiswa.add(newMahasiswa);
        pesan.append("Data berhasil ditambah.");

        return pesan.toString();
    }
    
    public void hapus(String nimMahasiswa) {
        for (int i = 0; i < mahasiswa.size(); i++) {
            String getNIm = mahasiswa.get(i).getNim();
            
            if (getNIm.equalsIgnoreCase(nimMahasiswa)) {
                mahasiswa.remove(i); 
            }
        }
    }

    public List<Mahasiswa> getAll() {
        if (!mahasiswa.isEmpty()) {
            return mahasiswa;
        }
        return null;
    }

    public Mahasiswa cariByNim(String nimMahasiswa) {
        for (int i = 0; i < mahasiswa.size(); i++) {
            String getNIm = mahasiswa.get(i).getNim();
            
            if (getNIm.equalsIgnoreCase(nimMahasiswa)) {
                return  mahasiswa.get(i);
            }
        }
        return null;
    }

}
