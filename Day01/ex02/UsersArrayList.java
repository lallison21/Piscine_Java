//package Day01.ex02;

public class UsersArrayList implements UsersList {
	public static final String USER_NOT_FOUND = "UserNotFoundException";

	private Integer arraySize = 10;
	private Integer userIndex = 0;

	private User[] users = new User[arraySize];

	@Override
	public void	addUser(User user) {
		if (userIndex == arraySize - 1) {
			Integer newArraySize = arraySize + arraySize / 2;
			User[] newUsers = new User[newArraySize];
			copyArray(users, newUsers);
			users = newUsers;
			arraySize = newArraySize;
		}
		users[userIndex++] = user;
	}

	@Override
	public User getUserById(Integer id) {
		for (int i = 0; i < arraySize; i++) {
			if (users[i] != null) {
				if (users[i].getId() == id) {
					return users[i];
				}
			}
		}
		throw new UserNotFoundException(USER_NOT_FOUND);
	}

	@Override
	public User getUserByIndex(Integer userIndex) {
		if (this.userIndex >= userIndex && userIndex >= 0) {
			return users[userIndex];
		}
		return null;
	}

	@Override
	public Integer getUserCount() {
		return userIndex;
	}

	private void copyArray(User[] from, User[] to) {
		for (int i = 0; i < arraySize; i++) {
			to[i] = from[i];
		}
	}
}