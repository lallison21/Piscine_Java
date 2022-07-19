import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if (num < 2) {
			sc.close();
			System.err.println("IllegalArgument");
			System.exit(-1);
		}
		int i;
		for (i = 2; i * i <= num; i++)
			if (num % i == 0)
				break ;
		if (i * i > num || num == 3)
			System.out.println("true " + --i);
		else
			System.out.println("false " + --i);
		sc.close();
	}
}