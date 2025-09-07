import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;

public class Service {
    private final String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final SecureRandom random = new SecureRandom();

    private HashMap<String, Person> akun = new HashMap<>();

    public String generateId(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARSET.charAt(random.nextInt(CHARSET.length())));
        }
        return sb.toString();
    }

    public boolean cekUser(String username) {
        return akun.containsKey(username);
    }

    public boolean addAkun(String username, String password) {
        if (cekUser(username)) {
            return false;
        }

        String encryptedPassword = simpleEncrypt(password);
        String id = generateId(6);

        Person newAkun = new Person(id, username, encryptedPassword);
        akun.put(username, newAkun);
        return true;
    }

    private String simpleEncrypt(String password) {
        // Implementasi enkripsi dasar
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public boolean login(String username, String password) {
        Person user = akun.get(username);
        String encryptedInput = simpleEncrypt(password);

        return user.getPassword().equals(encryptedInput);
    }

    public HashMap<String, Person> getAll() {
        return new HashMap<>(akun);
    }

    

}
