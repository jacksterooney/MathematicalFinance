package main.java;

import static main.java.StandardFormulae.*;
import static main.java.StandardFormulae.pv;

public class Put extends Option {

	Put(double spot, double strike, double volatility, double compoundingRate, double dividendRate, double timeToMaturity) {
		super(spot, strike, volatility, compoundingRate, dividendRate, timeToMaturity);
	}

	@Override
	public double price() {

		// Uses the black-scholes model for european puts
		return cumulativeNormal(-d2(spot, strike, volatility, compoundingRate, timeToMaturity))
				* pv(strike, compoundingRate, timeToMaturity)
				- cumulativeNormal(-d1(spot, strike, volatility, compoundingRate, timeToMaturity))
				* spot;
	}
}
