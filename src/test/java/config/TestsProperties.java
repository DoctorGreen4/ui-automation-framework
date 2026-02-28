package config;

import org.aeonbits.owner.Config;

/**
 * Интерфейс конфигурации для тестов с использованием библиотеки Owner.
 * Загружает параметры из файла tests.properties
 *
 * @author Кирилл Широков
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("file:src/main/resources/tests.properties")
public interface TestsProperties extends Config {


    @Key("base.url")
    String baseUrl();

    @Key("browser")
    String browser();

    @Key("headless")
    Boolean headless();


    @Key("implicit.wait")
    long defaultTimeout();
}
