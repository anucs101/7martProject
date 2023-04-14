package utilities;

import com.github.javafaker.Faker;

public class FakerUtility 
{
	
	public static String firstName() {
		Faker faker = new Faker();
		return faker.name().firstName();
	}
	
	public static String lastName() {
		Faker faker = new Faker();
		return faker.name().lastName();
	}
	public static String cityName() {
		Faker faker = new Faker();
		return faker.address().cityName();
	}
	public static String state() {
		Faker faker = new Faker();
		return faker.address().state();
	}
	 public static String emailID() {
		Faker faker = new Faker();
		return faker.bothify("????###@gmail.com");
	 }
}
