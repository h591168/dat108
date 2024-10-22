package Util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PassordUtil {

    // Generer et tilfeldig salt på 16 bytes
    public static String genererTilfeldigSalt() {
        SecureRandom sr;
        byte[] salt = new byte[16];

        try {
            sr = SecureRandom.getInstance("SHA1PRNG");
            sr.nextBytes(salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return Base64.getEncoder().encodeToString(salt);  
    }

    // Hash passord med salt
    public static String hashMedSalt(String passord, String salt) {
        if (passord == null || salt == null) {
            throw new IllegalArgumentException();
        }

        char[] passchar = passord.toCharArray();
        byte[] saltbytes = Base64.getDecoder().decode(salt);  

        byte[] keyhash = null;

        try {
            PBEKeySpec pks = new PBEKeySpec(passchar, saltbytes, 1000, 256);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            keyhash = skf.generateSecret(pks).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }

        return Base64.getEncoder().encodeToString(keyhash);  }

    public static boolean validerMedSalt(String passord, String salt, String passordhash) {
        if (passord == null || salt == null || passordhash == null) {
            throw new IllegalArgumentException();
        }
        return passordhash.equals(hashMedSalt(passord, salt));
    }
}
