package main.java;

public class Forward extends Option {

	Forward(double spot, double strike, double volatility, double compoundingRate, double dividendRate, double timeToMaturity) {
		super(spot, strike, volatility, compoundingRate, dividendRate, timeToMaturity);
	}

	@Override
	public double price() {

		//Formula adapted from https://www.investopedia.com/terms/f/forwardprice.asp
		//Assuming no dividend rate

		return spot * Math.exp(compoundingRate * timeToMaturity);
	}
}
