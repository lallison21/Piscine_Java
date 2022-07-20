//package Day01.ex02;

public class Program {
	public static void main(String[] args) {
		UsersArrayList usersArrayList = new UsersArrayList();

		System.out.println("Array size " + usersArrayList.getUserCount());

		usersArrayList.addUser(new User("Richard", 1000));
		usersArrayList.addUser(new User("Michael", 1000));
		usersArrayList.addUser(new User("Fred", 1000));
		usersArrayList.addUser(new User("Nick", 1000));
		usersArrayList.addUser(new User("Artur", 1000));

		System.out.println("Array size " + usersArrayList.getUserCount());

		usersArrayList.addUser(new User("Albert", 1000));
		usersArrayList.addUser(new User("Adolf", 1000));
		usersArrayList.addUser(new User("Putin", 1000));
		usersArrayList.addUser(new User("Macron", 1000));
		usersArrayList.addUser(new User("Alexandr", 1000));
		usersArrayList.addUser(new User("Ben", 1000));
		usersArrayList.addUser(new User("Steve", 1000));
		usersArrayList.addUser(new User("Alex", 1000));

		System.out.println("Array size " + usersArrayList.getUserCount());

		usersArrayList.addUser(new User("Bart", 1000));
		usersArrayList.addUser(new User("Michael", 1000));
		usersArrayList.addUser(new User("Fred", 1000));
		usersArrayList.addUser(new User("Nick", 1000));
		usersArrayList.addUser(new User("Artur", 1000));
		usersArrayList.addUser(new User("Richard", 1000));
		usersArrayList.addUser(new User("Gamer", 1000));
		usersArrayList.addUser(new User("Fred", 1000));
		usersArrayList.addUser(new User("Nick", 1000));
		usersArrayList.addUser(new User("Artur", 1000));
		usersArrayList.addUser(new User("Richard", 1000));

		System.out.println("Array size " + usersArrayList.getUserCount());

		for (int i = 0; i < usersArrayList.getUserCount(); i++) {
			System.out.println(usersArrayList.getUserById(i + 1).getName());
			System.out.println(usersArrayList.getUserByIndex(i));
		}

		System.out.println(usersArrayList.getUserById(666));
	}
}