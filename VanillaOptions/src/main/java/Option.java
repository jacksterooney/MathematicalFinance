package main.java;

abstract class Option {

	double spot;
	double strike;
	double volatility;
	double compoundingRate;
	double dividendRate;
	double timeToMaturity;

	Option(double spot, double strike, double volatility, double compoundingRate, double dividendRate, double timeToMaturity) {
		this.spot = spot;
		this.strike = strike;
		this.volatility = volatility;
		this.compoundingRate = compoundingRate;
		this.dividendRate = dividendRate;
		this.timeToMaturity = timeToMaturity;
	}

	abstract double price();
}
