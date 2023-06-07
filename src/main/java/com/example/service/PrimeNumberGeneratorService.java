package com.example.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumberGeneratorService implements PrimeNumberGenerator{

	public List<Integer> generate(int startingValue, int endingValue) throws Exception {
		List<Integer> result = new ArrayList<>();
		
		if (startingValue > endingValue) {
			int temp = endingValue;
			endingValue = startingValue;
			startingValue = temp;
		}
		
		boolean[] primes = markPrimes(endingValue);
        
        for (int i = startingValue; i <= endingValue; i++) {
            if (primes[i]) {
            	result.add(i);
            }
        }
		return result;
	}

	public boolean isPrime(int value) throws Exception {		
        boolean[] primes = markPrimes(value);

		return primes[value];
	}
	
	private boolean[] markPrimes(int value) throws Exception {
		if (value < 0) {
			throw new Exception("Value should be greater than 0");
		}
        boolean[] primes = new boolean[value + 1];
        Arrays.fill(primes, true);
        
        primes[0] = false;
        
        if (value > 0) {
        	primes[1] = false;
        }
        
        for (int i = 2; i * i <= value; i++) {
            if (primes[i]) {
                for (int j = i; j * i <= value; j++) {
                    primes[i * j] = false;
                }
            }
        }
        
        return primes;
	}
	
}
