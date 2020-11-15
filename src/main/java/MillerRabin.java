import java.util.Random;
import java.math.BigInteger;


public class MillerRabin {

    public boolean isPrime(long n, int iteration) {

        if (n == 0 || n == 1)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;
        long s = n - 1;
        while (s % 2 == 0)
            s /= 2;

        Random rand = new Random();
        for (int i = 0; i < iteration; i++) {
            long r = Math.abs(rand.nextLong());
            long a = r % (n - 1) + 1;
            long temp = s;
            long mod = modPow(a, temp, n);


            while (temp != n - 1 && mod != 1 && mod != n - 1) {
                mod = mulMod(mod, mod, n);
                temp *= 2;
            }

            if (mod != n - 1 && temp % 2 == 0)
                return false;
        }
        return true;
    }

    //    (a ^ b) % c
    public long modPow(long a, long b, long c) {
        long res = 1;
        for (int i = 0; i < b; i++) {
            res *= a;
            res %= c;
        }
        return res % c;
    }

    //     (a * b) % c
    public long mulMod(long a, long b, long mod) {
        return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).mod(BigInteger.valueOf(mod)).longValue();
    }


    public static void main(String[] args) {
        MillerRabin mr = new MillerRabin();
        System.out.println("\n Miller-Rabin test implementation: \n");
        long num = 5510389;
        int k = 120;
        boolean prime = mr.isPrime(num, k);
        if (prime)
            System.out.println("Rounds: " + k + ", number " + num + " is prime");
        else
            System.out.println("Rounds: " + k + ", number " + num + " is composite");

        long num1 = 51;
        boolean prime1 = mr.isPrime(num1, k);
        if (prime1)
            System.out.println("Rounds: " + k + ", number " + num1 + " is prime");
        else
            System.out.println("Rounds: " + k + ", number " + num1 + " is composite");


    }
}