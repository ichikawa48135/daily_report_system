package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class EncryptUtil {

    public static String getPasswordEncrypt(String planin_p,String salt){
        String ret ="";

        if(planin_p != null && !planin_p.equals("")){
            byte[] bytes;
            String password = planin_p + salt;

            try{

                bytes = MessageDigest.getInstance("SHA-256").digest(password.getBytes());
                ret = DatatypeConverter.printHexBinary(bytes);
            }catch(NoSuchAlgorithmException ex){}

        }
        return ret;

    }
}
