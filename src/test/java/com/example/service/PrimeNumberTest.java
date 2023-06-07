package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrimeNumberTest {

	PrimeNumberGeneratorService service;
	
	@BeforeEach
	void setupBeforeEach() {
		service = new PrimeNumberGeneratorService();
	}
	
	@DisplayName("generate prime numbers up to 100")
	@Test
	void testGenerate() throws Exception {
		Integer[] arr1 = new Integer[] {7901, 7907, 7919};
		List<Integer> list1 = Arrays.asList(arr1);
		
		Integer[] arr2 = new Integer[] {3};
		List<Integer> list2 = Arrays.asList(arr2);
		
		Integer[] arr3 = new Integer[] {};
		List<Integer> list3 = Arrays.asList(arr3);
		
		assertEquals(list1, service.generate(7900, 7920));
		assertEquals(list1, service.generate(7920, 7900));
		assertEquals(list2, service.generate(3, 3));
		assertEquals(list3, service.generate(0, 0));
		
		assertThrows(Exception.class, () -> {service.generate(-50, 0);}, "Should throw exception");
	}
	
	@DisplayName("is prime")
	@Test
	void testIsPrime() throws Exception {
		assertEquals(false, service.isPrime(0), "0 is not a prime");
		assertEquals(false, service.isPrime(1), "1 is not a prime");
		assertEquals(true, service.isPrime(2), "2 is a prime");
		assertEquals(true, service.isPrime(3), "3 is a prime");
		assertEquals(false, service.isPrime(4), "4 is not a prime");
		assertEquals(true, service.isPrime(5), "5 is a prime");
		assertEquals(true, service.isPrime(11), "11 is a prime");
		assertEquals(true, service.isPrime(89), "89 is a prime");
		assertEquals(false, service.isPrime(100), "100 is not a prime");
	}
}
