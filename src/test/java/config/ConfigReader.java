package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigReader {
    public static TestsProperties testsProperties = ConfigFactory.create(TestsProperties.class);
}
