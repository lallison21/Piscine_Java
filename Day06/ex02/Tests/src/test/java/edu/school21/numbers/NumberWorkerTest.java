package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {

	NumberWorker numberWorker;

	@BeforeEach
	void BeforeEachMethod() {
		numberWorker = new NumberWorker();
	}

	@ParameterizedTest
	@ValueSource(ints = {95219, 11329, 10091, 2531, 4507})
	void isPrimeForPrimes(int number) {
		Assertions.assertTrue(numberWorker.isPrime(number));
	}

	@ParameterizedTest
	@ValueSource(ints = {5080, 6452, 52580, 20664, 41506})
	void isPrimeForNotPrimes(int number) {
		Assertions.assertFalse(numberWorker.isPrime(number));
	}

	@ParameterizedTest
	@ValueSource(ints = {-5081, 0, 1, -5, -121})
	void isPrimeForIncorrectNumbers(int number) {
		Assertions.assertThrows(IllegalNumberException.class, () -> numberWorker.isPrime(number));
	}

	@ParameterizedTest
	@CsvFileSource(resources = {"/data.csv"}, delimiter = ',')
	void digitsSum(int x, int y) {
		Assertions.assertEquals(numberWorker.digitsSum(x), y);
	}
}
