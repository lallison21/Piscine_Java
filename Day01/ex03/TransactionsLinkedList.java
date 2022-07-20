import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
	public static final String TRANSACTION_NOT_FOUND = "TransactionNotFoundException";
	private Transaction head;
	private Transaction tail;
	private Integer linkedListSize = 0;

	@Override
	public void addTransaction(Transaction transaction) {
		if (this.head == null)
			this.head = transaction;
		else
			tail.setNext(transaction);
		tail = transaction;
		linkedListSize++;
	}

	@Override
	public void removeTransactionById(UUID uuid) {
		if (head != null) {
			Transaction tmp = head.getNext();
			Transaction prev = head;

			if (prev.getId() == uuid) {
				head = tmp;
				linkedListSize--;
				return;
			}

			while (tmp != null) {
				if (tmp.getId() == uuid) {
					prev.setNext(tmp.getNext());
					linkedListSize--;
					return;
				}
				tmp = tmp.getNext();
				prev = prev.getNext();
			}
		}
		throw new TransactionNotFoundException(TRANSACTION_NOT_FOUND);
	}

	@Override
	public Transaction[] toArray() {
		Transaction[] transactions = new Transaction[linkedListSize];
		Transaction tmp = head;

		for (Integer i = 0; i < linkedListSize; i++) {
			transactions[i] = tmp;
			tmp = tmp.getNext();
		}
		return transactions;
	}

	public Integer getSize() {
		return linkedListSize;
	}
}
