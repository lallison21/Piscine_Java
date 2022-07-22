public class Program {

	public static boolean isPrint = false;

	public static synchronized void sayHen() {

		if (!isPrint) {
			try {
				Program.class.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Hen");

		isPrint = false;

		Program.class.notify();

	}

	public static synchronized void sayEgg() {

		if (isPrint) {
			try {
				Program.class.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Egg");

		isPrint = true;

		Program.class.notify();

	}

	public static void main(String[] args) {

		if (args.length != 1 || !args[0].startsWith("--count=")) {
			System.out.println("Error: Incorrect argument");
			System.exit(-1);
		}

		int count = Integer.parseInt(args[0].substring(8));

		Thread egg = new Egg(count);
		Thread hen = new Hen(count);

		egg.start();
		hen.start();

	}

}
