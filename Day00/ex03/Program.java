import java.util.Scanner;

public class Program {

	public static final int MAX_WEEK = 19;
	public static final int MIN_GRADE = 1;
	public static final int MAX_GRADE = 9;
	public static final String EXIT = "42";
	public static final int MAX_GRADE_ON_WEEK = 5;

	public static void errorMessage(Scanner sc) {
		System.out.println("IllegalArgument");
		sc.close();
		System.exit(-1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String week;
		int day, grade, minGrade = 0;
		long all = 0, rate = 1, stat;

		for (int i = 1; i < MAX_WEEK; i++) {
			week = sc.next();

			if (week.equalsIgnoreCase("Week")) {
				day = sc.nextInt();
				if (day != i) {
					errorMessage(sc);
				}
			} else if (week.equals(EXIT)) {
				break;
			} else {
				errorMessage(sc);
			}

			for (int j = 0; j < MAX_GRADE_ON_WEEK; j++) {
				grade = sc.nextInt();
				if (grade < MIN_GRADE || grade > MAX_GRADE) {
					errorMessage(sc);
				}
				if (j == 0) {
					minGrade = grade;
				} else if (grade < minGrade) {
					minGrade = grade;
				}
			}

			all += minGrade * rate;
			rate *= 10;
		}

		sc.close();

		for (int n = 1; all > 0; n++) {
			System.out.print("Week ");
			System.out.print(n);
			System.out.print(" ");
			stat = all % 10;
			for (int j = 0; j < stat; j++) {
				System.out.print("=");
			}
			System.out.println(">");
			all /= 10;
		}
	}
}