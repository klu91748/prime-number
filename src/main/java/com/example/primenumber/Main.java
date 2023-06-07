package com.example.primenumber;

import java.util.List;

import com.example.service.PrimeNumberGeneratorService;

public class Main {

	public static void main(String[] args) throws Exception {
		PrimeNumberGeneratorService service = new PrimeNumberGeneratorService();
		
		int value1 = Integer.parseInt(args[0]);
		int value2 = Integer.parseInt(args[1]);
		
		if (value1 < 0 || value2 < 0) {
			throw new Exception("Values should be greater than 0");
		}

		List<Integer> result = service.generate(value1, value2);
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
