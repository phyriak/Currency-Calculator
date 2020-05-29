import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;

public class CalculatorTest {
    Calculator calculator=new Calculator();

    @Test
    public void shouldReturn10991USDWhenAmountIs10000andCurrencyIsUSD() {
        //given
        double amount=10000;
        String currency="USD";
        BigDecimal expected=new BigDecimal("10991.00");

        //when
        BigDecimal sut = calculator.exchange(amount, currency);

        //then
        assertEquals(expected,sut);
    }

    @Test
    public void shouldRoundAmountAfterChangeToTwoDecimalPlacesToFloor() {
        //given
        double amount=10;
        String currency="bgn";
        BigDecimal expected=new BigDecimal("19.55");

        //when
        BigDecimal sut = calculator.exchange(amount, currency);

        //then
        assertEquals(expected,sut);
    }

    @Test
    public void shouldReturn0USDWhenAmountIs0andCurrencyIsUSD() {
        //given
        double amount=0;
        String currency="USD";
        BigDecimal expected=new BigDecimal("0.00");

        //when
        BigDecimal sut = calculator.exchange(amount, currency);

        //then
        assertEquals(expected,sut);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRunTimeExceptionWhenCurrencySignatureIsIncorrect() {
        //given
        double amount=200;
        String currency="dvdcvd ";

        //when
        BigDecimal sut = calculator.exchange(amount, currency);
    }

    @Test
    public void shouldCalculateAmountWhenCurrencyIsPLNInLowerCaseAndHaveSpaces() {
        //given
        double amount=10000;
        String currency="pln  ";
        BigDecimal expected=new BigDecimal("44372.00");

        //when
        BigDecimal sut = calculator.exchange(amount, currency);

        //then
        assertEquals(expected,sut);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRunTimeExceptionWhenAmountIsLessOrEqualToZero() {
        //given
        double amount=-30;
        String currency="USD";

        //when
        BigDecimal sut = calculator.exchange(amount, currency);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowRunTimeExceptionWhenAmountHasMoreThenTwoDecimals() {
        //given
        double amount=200.345;
        String currency="USD";

        //when
        BigDecimal sut = calculator.exchange(amount, currency);
    }
}