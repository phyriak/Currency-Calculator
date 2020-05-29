import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class Calculator {

    public BigDecimal exchange(double amount, String currency) {
        if (BigDecimal.valueOf(amount).scale() > 2 || amount < 0) throw new RuntimeException("Bad format of amount!");
        XMLParser xmlReader = new XMLParser();
        Map<String, Double> map = xmlReader.read("rate.xml");
        BigDecimal result = null;
        for (Map.Entry<String, Double> element : map.entrySet()) {
            if (element.getKey().equals(currency.toUpperCase().trim()))
                result = BigDecimal.valueOf(amount*element.getValue());
        }
        if (result == null) throw new RuntimeException("Bad currency signature!");
        return result.setScale(2, RoundingMode.FLOOR);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.exchange(200.00, "usd"));
    }
}
