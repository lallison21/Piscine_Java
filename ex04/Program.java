import java.util.Scanner;

public class Program {
	public static final int MAX_SIZE = 10;
	public static final int MAX_COUNT_SYMBOLS = 999;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		if (str.length() == 0)
			return;
		char[] charArr =  new char[str.length() + MAX_SIZE], strArr = str.toCharArray();
		int[] gradeArr = new int[str.length() + MAX_SIZE];
		char swapChar;
		int swapInt, first;

		sc.close();

		for (char c : strArr) {
			for (int i = 0; i < charArr.length; i++) {
				if (charArr[i] == c) {
					if (gradeArr[i] < MAX_COUNT_SYMBOLS)
						gradeArr[i]++;
					break;
				} else if (charArr[i] == 0) {
					charArr[i] = c;
					gradeArr[i]++;
					break;
				}
			}
		}

		for (int i = 0; gradeArr[i] != 0 && gradeArr[i + 1] != 0; i++) {
			if (gradeArr[i] == gradeArr[i + 1] && charArr[i] > charArr[i + 1]
					|| gradeArr[i] < gradeArr[i + 1]) {
				swapInt = gradeArr[i];
				swapChar = charArr[i];
				gradeArr[i] = gradeArr[i + 1];
				charArr[i] = charArr[i + 1];
				gradeArr[i + 1] = swapInt;
				charArr[i + 1] = swapChar;
				i = -1;
			}
		}

		first = gradeArr[0];
		for (int i = 0; i < MAX_SIZE; i++)
			if (gradeArr[i] * MAX_SIZE / first == MAX_SIZE)
				System.out.print(gradeArr[i] + "\t");
		System.out.println();

		for (int i = MAX_SIZE; i > 0; i--) {
			for (int j = 0; j < MAX_SIZE; j++) {
				if (gradeArr[j] * MAX_SIZE / first >= i)
					System.out.print("#\t");
				if (gradeArr[j] * MAX_SIZE / first == i - 1)
					if (gradeArr[j] != 0)
						System.out.print(gradeArr[j] + "\t");
			}
			System.out.println();
		}

		for (int i = 0; i < MAX_SIZE; i++)
			if (charArr[i] != 0)
				System.out.print(charArr[i] + "\t");
		System.out.println();
	}
}