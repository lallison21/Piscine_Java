import java.util.Scanner;

public class Program {
	public static final int EXIT = 42;

	public static int itsPrime(int num) {
		if (num < 2) {
			return (1);
		}
		int i;
		for (i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				break;
			}
		}
		if (i * i > num || num == 3) {
			return (0);
		} else {
			return (1);
		}
	}

	public static int numSum(int num) {
		int sum;
		for (sum = 0; num > 0; num /= 10) {
			sum += num % 10;
		}
		return (sum);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cup, num = sc.nextInt();
		for (cup = 0; num != EXIT; num = sc.nextInt()) {
			if (itsPrime(numSum(num)) == 0) {
				cup++;
			}
		}
		System.out.println("Count of coffee-request - " + cup);
		sc.close();
	}
}