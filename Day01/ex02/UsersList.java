//package Day01.ex02;

interface UsersList {
	void addUser(User user);
	User getUserById(Integer id);
	User getUserByIndex(Integer index);
	Integer getUserCount();
}