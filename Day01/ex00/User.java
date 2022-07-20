public class User {
	private Integer id;
	private String name;
	private Integer balance;

	public User (Integer id, String name, Integer balance) {
		this.id = id;
		this.name = name;
		if (balance < 0) {
			this.balance = 0;
		} else {
			this.balance = balance;
		}
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

	public void setId(Integer id) {
		this.id = id;
	}
}