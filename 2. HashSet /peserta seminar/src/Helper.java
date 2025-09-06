import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Iterator;

public class Helper {
    private final String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final SecureRandom random = new SecureRandom();
    private HashSet<Person> peserta = new HashSet<>();

    public String generateNik(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARSET.charAt(random.nextInt(CHARSET.length())));
        }
        return sb.toString();
    }

    public boolean tambah(String nama, int uisa, Gender gender) {
        String nik = generateNik(6);
        Person newPeserta = new Person(nik, nama, uisa, gender);
        return peserta.add(newPeserta);
    }

    public Person cari(String nama) {
        for (Person ps : peserta) {
            if (ps.getNama().equalsIgnoreCase(nama)) {
                return ps;
            }
        }
        return null;
    }

    public HashSet<Person> getAll() {
        return peserta;
    }

    public boolean  hapus(String nama) {
        Iterator<Person> iterator = peserta.iterator();

        while (iterator.hasNext()) {
            Person person = iterator.next();

            if (person.getNama().equalsIgnoreCase(nama)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

}
