package main.java;

public abstract class Option {

	public abstract double price(double spot, double strike, double volatility, double compoundingRate, double dividendRate,
			double timeToMaturity);
}
