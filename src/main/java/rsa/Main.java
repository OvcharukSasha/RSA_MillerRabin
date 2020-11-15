package rsa;

import java.math.BigInteger;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BigInteger p;
        BigInteger q;
        BigInteger e;
        final String message;

            p = new BigInteger("5700734181645378434561188374130529072194886062117");
            q = new BigInteger("35894562752016259689151502540913447503526083241413");
            e = new BigInteger("33445843524692047286771520482406772494816708076993");

            message = "This is a text to test";

//          p = new BigInteger("101");
//          q = new BigInteger("113");
//          e = new BigInteger("3533");


        RSA RSA = new RSA(p, q, e);
        System.out.println(RSA);

        List<BigInteger> encryption;
        List<BigInteger> signed;
        List<BigInteger> decimalMessage;

        encryption = RSA.encryptMessage(message);
        signed = RSA.signMessage(message);
        decimalMessage = RSA.messageToDecimal(message);


        List<BigInteger> decrypt = RSA.decrypt(encryption);
        List<BigInteger> verify = RSA.verify(signed);

        System.out.println();

        System.out.println("message(plain text)   = " + Utils.bigIntegerToString(decimalMessage));
        System.out.println("message(decimal)      = " + Utils.bigIntegerSum(decimalMessage));
        System.out.println("encripted(decimal)    = " + Utils.bigIntegerSum(encryption));

        System.out.println("decrypted(plain text) = " + Utils.bigIntegerToString(decrypt));
        System.out.println("decrypted(decimal)    = " + Utils.bigIntegerSum(decrypt));

        System.out.println("signed(decimal)       = " + Utils.bigIntegerSum(signed));

        System.out.println("verified(plain text)  = " + Utils.bigIntegerToString(verify));
        System.out.println("verified(decimal)     = " + Utils.bigIntegerSum(verify));
    }
}
