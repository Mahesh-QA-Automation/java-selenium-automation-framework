package config;

public final class ConfigReader {
    private ConfigReader() { }

    public static String get(String key, String defaultValue) {
        String value = System.getProperty(key);
        if (value == null || value.trim().isEmpty()) {
            value = System.getenv(key.toUpperCase().replace('.', '_'));
        }
        return value == null || value.trim().isEmpty() ? defaultValue : value.trim();
    }

    public static int getInt(String key, int defaultValue) {
        try {
            return Integer.parseInt(get(key, String.valueOf(defaultValue)));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid integer configuration: " + key, e);
        }
    }
}
