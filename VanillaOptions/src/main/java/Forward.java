package main.java;

public class Forward extends Option {

	@Override
	public double price(double spot, double strike, double volatility, double compoundingRate, double dividendRate,
			double timeToMaturity) {

		//Formula adapted from Theorem 2.1 on page 25
		return Math.exp(-compoundingRate * timeToMaturity)
				* (Math.exp((compoundingRate - dividendRate) * timeToMaturity) * spot - strike);
	}
}
