package main.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionTest {

	@Test
	void ForwardTest() {

		// Example forward taken from https://www.investopedia.com/terms/f/forwardprice.asp

		double spot = 100d; // A security is trading at $100
		double timeToMaturity = 1d; // An investor wants to enter into a forward contract that expires in one year
		double compoundingRate = 0.06d; // The current annual risk-free interest rate is 6%

		assertEquals(106.18d, new Forward(spot, 0, 0, compoundingRate, 0, timeToMaturity).price(), 0.01);
	}

	@Test
    void CallTest() {

	    //Pricing test for calls as calculated by http://www.tradingtoday.com/black-scholes
        double strike = 80;
        double stockPrice = 100;
        double timeInDays = 60;
        double volatility = 0.02;
        double riskFreeInterestRate = 0.05;

        assertEquals(20.0066, new Call(stockPrice, strike, volatility, riskFreeInterestRate, 0, timeInDays).price());
    }

	@Test
	void PutCallParityTest() {

		// Price of a call minus the price of a put should equal the value of a forward

		double spot = 100d;
		double strike = 105d;
		double volatility = 0d;
		double compoundingRate = 0.06d;
		double dividendRate = 0d;
		double timeToMaturity = 1d;

		double callPrice = new Call(spot, strike, volatility, compoundingRate, dividendRate, timeToMaturity).price();
		double putPrice = new Put(spot, strike, volatility, compoundingRate, dividendRate, timeToMaturity).price();
		double forwardPrice = new Forward(spot, strike, volatility, compoundingRate, dividendRate, timeToMaturity).price();

		assertEquals(spot - strike * Math.exp(-compoundingRate - timeToMaturity), callPrice - putPrice);
	}
}