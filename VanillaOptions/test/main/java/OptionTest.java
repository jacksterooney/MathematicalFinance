package main.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionTest {

    @Test
    public void PutCallParityTest () {

        //Price of a call minus the price of a put should equal the value of a forward

        double spot = 5d;
        double strike = 7d;
        double volatility = 0.2d;
        double compoundingRate = 0.5d;
        double dividendRate = 0.7d;
        double timeToMaturity = 15d;

        double callPrice = new Call().price(spot, strike, volatility, compoundingRate, dividendRate, timeToMaturity);
        double putPrice = new Put().price(spot, strike, volatility, compoundingRate, dividendRate, timeToMaturity);
        double forwardPrice = new Forward().price(spot, strike, volatility, compoundingRate, dividendRate, timeToMaturity);

        assertEquals(forwardPrice, callPrice - putPrice);
    }
}