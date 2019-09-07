package hendrix.projectEuler.utils;

import java.util.HashSet;

public class Prime {
    private final HashSet<Integer> primes = new HashSet<>();

    public Prime() {
    }

    public boolean isPrime(int num) {
        if (primes.contains(num)) {
            return true;
        } else if (PrimeTools.isPrime(num)) {
            primes.add(num);
            return true;
        } else
            return false;
    }

}
