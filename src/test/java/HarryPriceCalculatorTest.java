import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class HarryPriceCalculatorTest {

    private HarryPriceCalculator harryPriceCalculator;
    private List<Integer> basket;

    @Before
    public void setUp(){
        harryPriceCalculator = new HarryPriceCalculator();
        basket = new ArrayList<>();
    }

    @Test
    public void anEmptyBasketReturnsZeroPounds(){
       assertThat(harryPriceCalculator.getBasketPrice(basket), equalTo(0.0));
    }

    @Test
    public void aBasketWithOneBookReturns8Pounds(){
        basket.add(1);
        assertThat(harryPriceCalculator.getBasketPrice(basket), equalTo(8.0));
    }

    @Test
    public void aBasketWithTwoDifferentBooksReturns(){
        basket.add(1);
        basket.add(2);
        assertThat(harryPriceCalculator.getBasketPrice(basket), equalTo(15.2));

    }

    @Test
    public void aBasketWithTwoDifferentBooksAndASameBook(){
        basket.add(1);
        basket.add(2);
        basket.add(1);
        assertThat(harryPriceCalculator.getBasketPrice(basket), equalTo(15.2 + 8));

    }

    @Test
    public void aBasketWithThreeDifferentBooksAndASameBook(){
        basket.add(1);
        basket.add(2);
        basket.add(1);
        basket.add(3);
        assertThat(harryPriceCalculator.getBasketPrice(basket), equalTo(29.6));
    }

    @Test
    public void aBasketWithFiveDifferentBooks(){
        basket.add(1);
        basket.add(2);
        basket.add(3);
        basket.add(4);
        basket.add(5);
        assertThat(harryPriceCalculator.getBasketPrice(basket), equalTo(30.0));
    }

    @Test
    public void aBasketWithFourDifferentBooks(){
        basket.add(1);
        basket.add(2);
        basket.add(3);
        basket.add(4);

        assertThat(harryPriceCalculator.getBasketPrice(basket), equalTo(25.6    ));
    }

    @Test
    public void aBasketWithFiveDifferentBooksPlusOne(){
        basket.add(1);
        basket.add(2);
        basket.add(3);
        basket.add(4);
        basket.add(5);
        basket.add(3);
        assertThat(harryPriceCalculator.getBasketPrice(basket), equalTo(30.0 + 8));
    }


}

