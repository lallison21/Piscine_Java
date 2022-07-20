import java.util.UUID;

public class Program {
	public static void main(String[] args) {

		TransactionsLinkedList transactionsLinkedList = new TransactionsLinkedList();

		User romul = new User("Romul", 1000);
		User kamil = new User("Kamil", 2000);

		Transaction t1 = new Transaction(kamil, romul, Transaction.Category.DEBIT, 500);
		Transaction t2 = new Transaction(kamil, romul, Transaction.Category.DEBIT, 500);
		Transaction t3 = new Transaction(romul, kamil, Transaction.Category.DEBIT, 500);
		Transaction t4 = new Transaction(romul, kamil, Transaction.Category.DEBIT, 500);

		transactionsLinkedList.addTransaction(t1);
		transactionsLinkedList.addTransaction(t2);
		transactionsLinkedList.addTransaction(t3);
		transactionsLinkedList.addTransaction(t4);

		System.out.println(transactionsLinkedList.getSize());

		System.out.println();

		Transaction[] transactions = transactionsLinkedList.toArray();

		for (int i = 0; i < transactionsLinkedList.getSize(); i++) {
			System.out.print(transactions[i].getId() + " ");
			System.out.println(transactions[i].getRecipient().getName());
		}

		System.out.println();

		transactionsLinkedList.removeTransactionById(t3.getId());

		Transaction[] transactions2 = transactionsLinkedList.toArray();

		System.out.println(transactionsLinkedList.getSize());

		System.out.println();

		for (int i = 0; i < transactionsLinkedList.getSize(); i++) {
			System.out.print(transactions2[i].getId() + " ");
			System.out.println(transactions2[i].getRecipient().getName());
		}

		System.out.println();

		transactionsLinkedList.removeTransactionById(t1.getId());

		Transaction[] transactions3 = transactionsLinkedList.toArray();

		System.out.println(transactionsLinkedList.getSize());

		for (int i = 0; i < transactionsLinkedList.getSize(); i++) {
			System.out.print(transactions3[i].getId() + " ");
			System.out.println(transactions3[i].getRecipient().getName());
		}

		transactionsLinkedList.removeTransactionById(UUID.randomUUID());
	}
}
