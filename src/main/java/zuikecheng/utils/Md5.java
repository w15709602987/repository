package zuikecheng.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5 {

    public static String md5(String str){
        try {
            MessageDigest messageDigest=MessageDigest.getInstance("md5");
            byte[]arr=str.getBytes();
            byte[]sercet= messageDigest.digest(arr);
            return new BigInteger(1,sercet).toString(16);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
