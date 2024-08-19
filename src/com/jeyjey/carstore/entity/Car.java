package com.jeyjey.carstore.entity;

import java.util.Objects;

public class Car {
	private String brand;
	private String model;
	private int year;
	private double price;

	public Car(String brand, String model, int year, double price) {
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.price = price;
	}

	// Getters
	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public int getYear() {
		return year;
	}

	public double getPrice() {
		return price;
	}

	// Setters
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	// hashCode method
	@Override
	public int hashCode() {
		return Objects.hash(brand, model, year, price);
	}

	// equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Car car = (Car) obj;
		return year == car.year && Double.compare(car.price, price) == 0 && Objects.equals(brand, car.brand)
				&& Objects.equals(model, car.model);
	}

	// toString method
	@Override
	public String toString() {
		return "Car{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + ", year=" + year + ", price=" + price
				+ '}';
	}
}
