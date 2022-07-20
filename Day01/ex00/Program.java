public class Program {
	public static void main(String[] args) {
		User user1 = new User(1, "Romul", 20000);
		User user2 = new User(2, "Richard", 40000);
		User user3 = new User(3, "Kamil", 90000);

		System.out.println("Used id:\t" + user1.getId() + "\tUser name:\t" + user1.getName()
				+ "\tUser balance:\t$" + user1.getBalance());
		System.out.println("Used id:\t" + user2.getId() + "\tUser name:\t" + user2.getName()
				+ "\tUser balance:\t$" + user2.getBalance());
		System.out.println("Used id:\t" + user3.getId() + "\tUser name:\t" + user3.getName()
				+ "\tUser balance:\t$" + user3.getBalance());

		System.out.println();

		Transaction transaction1 = new Transaction(user2, user3, Transaction.Category.DEBIT, 30000);

		System.out.println(transaction1.getId());
		System.out.println(transaction1.getRecipient().getId());
		System.out.println(transaction1.getSender().getId());
		System.out.println(transaction1.getCategory());
		System.out.println(transaction1.getAmount());

		System.out.println();

		Transaction transaction2 = new Transaction(user1, user3, Transaction.Category.DEBIT, -30000);

		System.out.println(transaction2.getId());
		System.out.println(transaction2.getRecipient().getId());
		System.out.println(transaction2.getSender().getId());
		System.out.println(transaction2.getCategory());
		System.out.println(transaction2.getAmount());

		System.out.println();

		Transaction transaction3 = new Transaction(user1, user3, Transaction.Category.CREDIT, 30000);

		System.out.println(transaction3.getId());
		System.out.println(transaction3.getRecipient().getId());
		System.out.println(transaction3.getSender().getId());
		System.out.println(transaction3.getCategory());
		System.out.println(transaction3.getAmount());

		System.out.println();

		Transaction transaction4 = new Transaction(user1, user3, Transaction.Category.CREDIT, -30000);

		System.out.println(transaction4.getId());
		System.out.println(transaction4.getRecipient().getId());
		System.out.println(transaction4.getSender().getId());
		System.out.println(transaction4.getCategory());
		System.out.println(transaction4.getAmount());
	}
}