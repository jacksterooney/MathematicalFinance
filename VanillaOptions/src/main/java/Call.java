package main.java;

import static main.java.StandardFormulae.*;

public class Call extends Option {

	Call(double spot, double strike, double volatility, double compoundingRate, double dividendRate, double timeToMaturity) {
		super(spot, strike, volatility, compoundingRate, dividendRate, timeToMaturity);
	}

	@Override
	public double price() {

		// Uses the black-scholes model for european calls
		return cumulativeNormal(d1(spot, strike, volatility, compoundingRate, timeToMaturity))
				- cumulativeNormal(d2(spot, strike, volatility, compoundingRate, timeToMaturity))
				* pv(strike, compoundingRate, timeToMaturity);
	}
}
