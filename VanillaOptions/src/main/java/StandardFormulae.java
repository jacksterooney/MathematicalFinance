package main.java;

public class StandardFormulae {

	/*
	 * Cumulative normal function, as described on page 417 of The Concepts and Practices of Quantitive Finance
	 */
	static double cumulativeNormal(double x) {

		if (x < 0) {
			return 1 - cumulativeNormal(-x);
		}

		double k = k(x);
		return 1 - (1 / Math.sqrt(2 * Math.PI)) * Math.exp(-x * x / 2) * k
				* (-0.356563782 + k * (1.781477937 + k * (-1.821255978 + k * (1.330274429))));
	}

	private static double k(double x) {
		return (1 / (1 + 0.2316419 * x));
	}

	/*
	 * Black-scholes formula, as described on page 61
	 */
	static double blackScholes(double spot, double strike, double compoundingRate, double timeToMaturity, double d1, double d2) {
		return spot * cumulativeNormal(d1) - strike * Math.exp(-compoundingRate * timeToMaturity) * cumulativeNormal(d2);
	}

	static double d(int index, double spot, double strike, double volatility, double compoundingRate, double timeToMaturity) {
		return Math.log(spot / strike) + (compoundingRate + Math.pow(-1, index - 1) * 0.5 * Math.pow(volatility, 2))
				* timeToMaturity / volatility * Math.sqrt(timeToMaturity);
	}
}
