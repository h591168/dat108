package no.hvl.Obligatorisk4.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;

public class PassordUtil {

    // Generate a random salt of even length
    public static String genererTilfeldigSalt() {
        SecureRandom sr;
        byte[] salt = new byte[16];

        try {
            sr = SecureRandom.getInstance("SHA1PRNG");
            sr.nextBytes(salt);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Feil ved generering av salt", e);
        }

        return DatatypeConverter.printHexBinary(salt);
    }

    // Hash the password using the provided salt
    public static String hashMedSalt(String passord, String salt) {
        if (passord == null || salt == null || salt.length() % 2 != 0) {
            throw new IllegalArgumentException("Passord og salt kan ikke være null, og salt må ha jevn lengde.");
        }

        char[] passchar = passord.toCharArray();
        byte[] saltbytes;

        try {
            saltbytes = DatatypeConverter.parseHexBinary(salt);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Saltet er ikke gyldig hex-streng.");
        }

        byte[] keyhash;

        try {
            PBEKeySpec pks = new PBEKeySpec(passchar, saltbytes, 1000, 256);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            keyhash = skf.generateSecret(pks).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException("Feil ved hashing av passord", e);
        }

        return DatatypeConverter.printHexBinary(keyhash);
    }

    // Validate the password with the provided salt and hash
    public static boolean validerMedSalt(String passord, String salt, String passordhash) {
        if (passord == null || salt == null || passordhash == null) {
            throw new IllegalArgumentException("Passord, salt og hash kan ikke være null.");
        }

        return passordhash.equals(hashMedSalt(passord, salt));
    }
}
