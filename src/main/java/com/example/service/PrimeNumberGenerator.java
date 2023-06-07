package com.example.service;

import java.util.List;

public interface PrimeNumberGenerator {

	List<Integer> generate(int startingValue, int endingValue) throws Exception;
	boolean isPrime(int value) throws Exception;
}
