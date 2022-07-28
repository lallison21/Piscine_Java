package classes;

import java.util.StringJoiner;

public class Weapon {

	private String weaponModel;
	private Double cartridgeSize;
	private Integer cartridgeCount;
	private Integer	maxMagazineVolume;
	private Integer cartridgeInMagazine;
	private Integer fireRate;

	public Weapon() {

		this.weaponModel = "Default weapon model";
		this.cartridgeSize = 0.0;
		this.cartridgeCount = 0;
		this.maxMagazineVolume = 0;
		this.cartridgeInMagazine = 0;
		this.fireRate = 0;
	}

	public Weapon(String weaponModel, Double cartridgeSize, Integer cartridgeCount, Integer fireRate) {

		this.weaponModel = weaponModel;
		this.cartridgeSize = cartridgeSize;
		this.cartridgeCount = cartridgeCount;
		this.fireRate = fireRate;
	}

	public Integer refuelMagazine(Integer refuelingCartridgeCount) {

		if (maxMagazineVolume - cartridgeInMagazine < refuelingCartridgeCount) {
			System.out.println("Нou have loaded "
					+ (maxMagazineVolume - cartridgeInMagazine)
					+ " rounds of ammunition into the ammunition magazine");
			this.cartridgeInMagazine = maxMagazineVolume;
		} else {
			System.out.println("Нou have loaded "
					+ refuelingCartridgeCount
					+ " rounds of ammunition into the ammunition magazine");
			this.cartridgeInMagazine += refuelingCartridgeCount;
		}

		return cartridgeInMagazine;
	}

	public Integer fireAShot(Integer shotCount) {

		if (cartridgeInMagazine - shotCount < 0) {
			this.cartridgeInMagazine = 0;
			System.out.println("The ammunition magazine is empty. The number of cartridges in the magazine is "
					+ cartridgeInMagazine + " pieces");
		} else {
			this.cartridgeInMagazine -= shotCount;
			System.out.println("The number of cartridges in the magazine is " + cartridgeInMagazine + " pieces");
		}
		return cartridgeInMagazine;
	}

	@Override
	public String toString() {

		return new StringJoiner(", ", User.class.getSimpleName() + "[","]")
				.add("weaponModel='" + weaponModel + "'")
				.add("cartridgeSize=" + cartridgeSize)
				.add("cartridgeCount=" + cartridgeCount)
				.add("maxMagazineVolume=" + maxMagazineVolume)
				.add("cartridgeInMagazine=" + cartridgeInMagazine)
				.add("fireRate=" + fireRate)
				.toString();
	}
}
