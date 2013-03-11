package crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: sgomez
 * Date: 3/8/13
 * Time: 7:27 PM
 * To change this template use File | Settings | File Templates.
 */
public enum EncryptionType {
    // the hash to use to encrypt the dummy password
    MD5("MD5");

    public final String algorithm;

    private EncryptionType(String algorithm){
        this.algorithm = algorithm;
    }
}
