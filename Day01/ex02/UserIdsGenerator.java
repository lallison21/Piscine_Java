//package Day01.ex02;

public class UserIdsGenerator {
	private Integer id = 0;

	private static UserIdsGenerator userIdsGenerator;

	public static UserIdsGenerator getInstance() {
		if (userIdsGenerator == null)
			userIdsGenerator = new UserIdsGenerator();
		return userIdsGenerator;
	}

	public Integer generateId() {
		return ++id;
	}

	public Integer getId() {
		return id;
	}
}