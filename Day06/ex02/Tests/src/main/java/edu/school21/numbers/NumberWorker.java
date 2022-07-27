package edu.school21.numbers;

public class NumberWorker {

	public boolean isPrime(int number) {

		if (number < 2) {
			throw new IllegalNumberException("Number < 2");
		}
		int i;

		for (i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				break ;
			}
		}

		if (i * i > number || number == 3) {
			return true;
		} else {
			return false;
		}
	}

	public int digitsSum(int number) {

		int result;

		for (result = 0; number > 0; number /= 10) {
			result += number % 10;
		}
		return result;
	}
}

class IllegalNumberException extends RuntimeException {
	public IllegalNumberException(String string) {
		super(string);
	}
}
