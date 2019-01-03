package main.java;

public final class StandardFormulae {

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
	 * Black-scholes formula sub-equations, as described by
	 * https://en.wikipedia.org/wiki/Black%E2%80%93Scholes_model#Black%E2%80%93Scholes_formula
	 */
	static double d1(double spot, double strike, double volatility, double compoundingRate, double timeToMaturity) {
		return (1/(volatility * Math.sqrt(timeToMaturity))) *
				(Math.log(spot/strike) + (compoundingRate + Math.pow(volatility, 2) / 2) * timeToMaturity);
	}

	static double d2(double spot, double strike, double volatility, double compoundingRate, double timeToMaturity) {
		return d1(spot, strike, volatility, compoundingRate, timeToMaturity)
				- volatility * Math.sqrt(timeToMaturity);
	}

	static double pv(double strike, double compoundingRate, double timeToMaturity) {
		return strike * Math.exp(-compoundingRate * timeToMaturity);
	}
}
