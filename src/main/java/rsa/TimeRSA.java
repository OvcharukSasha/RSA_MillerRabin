package rsa;

import java.math.BigInteger;
import java.util.List;

import org.apache.commons.lang.time.StopWatch;

public class TimeRSA {

    public static void main(String[] args) {

        final String message = "This is a text to test the executed time for different sizes 123456789";
        BigInteger x;

//==============================
        BigInteger p1 = new BigInteger("99999570073418164537843456118837413052");
        BigInteger q1= new BigInteger("99999358945627520162596891515025409132");
        BigInteger e1 = new BigInteger("334458435246920472867715204824");
        StopWatch stopWatch1 = new StopWatch();
        stopWatch1.start();
        RSA RSAsmal = new RSA(p1, q1, e1);
        List<BigInteger> encryption = RSAsmal.encryptMessage(message);
        RSAsmal.decrypt(encryption);

        System.out.println("Size of p = " + p1.bitLength() + ", Size of q = " + q1.bitLength() +" :" + "\nElapsed time: " + stopWatch1.getTime() + " milli seconds\n");
        System.out.println("----------------------------------------------------");
//==============================

        BigInteger p2 = new BigInteger("9900734181645378434561118347878787787843971231218743578943589734578934578934589743587976326723673246734267423672346724367784379439874378778887788777874378");
        BigInteger q2 = new BigInteger("9900734181645378434561118347878787787843971231218743578943589734578934578934589743587976326723673246734267423672346724367784379439874378778887788777874378");
        BigInteger e2 = new BigInteger("334458435246920472867715204824067724948167348454898498548893894983749839898598398395893859894893859874590807");
        StopWatch stopWatch2 = new StopWatch();
        stopWatch2.start();
        RSA RSAmedium = new RSA(p2, q2, e2);
        List<BigInteger> encryptionMed = RSAmedium.encryptMessage(message);
        RSAmedium.decrypt(encryptionMed);
        System.out.println("Size of p = " + p2.bitLength() + ", Size of q = " + q2.bitLength() +" :" +  "\nElapsed time: " + stopWatch2.getTime() + " milli seconds\n");
        System.out.println("----------------------------------------------------");
//==============================


        BigInteger p3 = new BigInteger("99007341845894589459458945895489458945894589549845985489458945894589548498458945894598548954895489549858837413052907219488606098349834784578459839834094309430349843984854784587457845893489430943047873898979784389743874358955358893458975435879763623673246734267423672346724367784379439874378778887788777874382");
        BigInteger q3 = new BigInteger("99894596891515020954094590450994590540954904509450945090594094509540950954090945094509490459050499054540919999999999993984398349834984389348943893498348943784378745675956985687348734879839494393394834984378437474348948999993498349834895345944445598437598724892965837465743692498259384695246924989698234698249");
        BigInteger e3 = new BigInteger("3344584352469204728677152048240677458359385798378579837979847374398759834787443987574358345897349873478249481670807");
        StopWatch stopWatch3 = new StopWatch();
        stopWatch3.start();
        RSA RSAbig = new RSA(p3, q3, e3);
        List<BigInteger> encryptionBig = RSAbig.encryptMessage(message);
        RSAmedium.decrypt(encryptionBig);
        System.out.println("Size of p = " + p3.bitLength() + ", Size of q = " + q3.bitLength() +" :" + "\nElapsed time: " + stopWatch3.getTime() + " milli seconds\n");
        System.out.println("----------------------------------------------------");
//==============================


    }
}
