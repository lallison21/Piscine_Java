public class User {
	private Integer id;
	private String name;
	private Integer balance;
	private TransactionsList transactionsList;

	public User (String name, Integer balance) {
		this.id = UserIdsGenerator.getInstance().generateId();
		this.name = name;
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		if (balance < 0) {
			this.balance = 0;
		} else {
			this.balance = balance;
		}
	}

	public Integer getId() {
		return id;
	}

	public TransactionsList getTransactionsList() {
		return transactionsList;
	}

	public void setTransactionsList(TransactionsList transactionsList) {
		this.transactionsList = transactionsList;
	}
}