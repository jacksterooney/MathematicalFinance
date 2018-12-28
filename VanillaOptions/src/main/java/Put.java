package main.java;

public class Put extends Option {

	@Override
	public double price(double spot, double strike, double volatility, double compoundingRate, double dividendRate,
			double timeToMaturity) {

		// Similar to call options, using put-call parity
		double d1 = StandardFormulae.d(1, spot, strike, volatility, compoundingRate, timeToMaturity);
		double d2 = StandardFormulae.d(2, spot, strike, volatility, compoundingRate, timeToMaturity);
		return -StandardFormulae.blackScholes(spot, strike, compoundingRate, timeToMaturity, -d1, -d2);
	}
}
