package hendrix.projectEuler.utils;

import java.util.HashSet;

public class Prime {
    private final HashSet<Integer> nonPrimes = new HashSet<>();

    public Prime() {
    }

    public boolean isPrime(int num) {
        if (nonPrimes.contains(num)) {
            return false;
        } else if (!PrimeTools.isPrime(num)) {
            nonPrimes.add(num);
            return false;
        } else
            return true;
    }

}
