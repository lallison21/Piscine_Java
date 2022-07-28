package classes;

import java.util.StringJoiner;

public class Car {

	private String carBrand;
	private String brandModel;
	private Integer tankVolume;
	private Integer consumption;
	private Integer fuelLevel;

	public Car() {

		this.carBrand = "Default car brand";
		this.brandModel = "Default brand model";
		this.tankVolume = 0;
		this.consumption = 0;
		this.fuelLevel = 0;
	}

	public Car(String carBrand, String brandModel, Integer tankVolume, Integer consumption, Integer fuelLevel) {

		this.carBrand = carBrand;
		this.brandModel = brandModel;
		this.tankVolume = tankVolume;
		this.consumption = consumption;
		this.fuelLevel = fuelLevel;
	}

	public Integer refueling(Integer refuelingVolume) {

		if (tankVolume - fuelLevel < refuelingVolume) {
			System.out.println("You could only fill up "
					+ (tankVolume - fuelLevel) + " liters of fuel");
			this.fuelLevel = tankVolume;
		} else {
			System.out.println("You filled up with " + refuelingVolume + " liters of fuel");
			this.fuelLevel += refuelingVolume;
		}

		return fuelLevel;
	}

	public Integer distance() {

		return fuelLevel / consumption * 100;
	}

	@Override
	public String toString() {

		return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
				.add("carBrand='" + carBrand + "'")
				.add("brandModel='" + brandModel + "'")
				.add("tankVolume=" + tankVolume)
				.add("consumption=" + consumption)
				.add("fuelLevel=" + fuelLevel)
				.toString();
	}
}
