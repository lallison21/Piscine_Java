public class Program {
	public static void main(String[] args) {
		User user1 = new User("Lokh", 777);
		User user2 = new User("Pidr", 666);
		User user3 = new User("Solo-", 3228);

		System.out.println(user1.getId());
		System.out.println(user2.getId());
		System.out.println(user3.getId());
		System.out.println(UserIdsGenerator.getInstance().getId());
	}
}