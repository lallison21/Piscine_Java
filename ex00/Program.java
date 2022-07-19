public class Program {
	public static void main(String[] args) {
		int num = 479598;
		System.out.println(num % 10 + num / 10 % 10 + num / 100 % 10 + num / 1000 % 10 + num / 10000 % 10 + num / 100000);
	}
}