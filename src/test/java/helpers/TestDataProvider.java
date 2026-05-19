package helpers;

import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

public class TestDataProvider {
    public static Stream<Arguments> providerCheckingMarket() {
        return Stream.of(
                Arguments.of("Яндекс Маркет",
                        "Электроника",
                        "Ноутбуки",
                        "Ноутбуки",
                        10000,
                        50000,
                        List.of("asus"),
                        7)
        );
    }
}
