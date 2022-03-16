package Core;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public class PropertiesReader {

    private final String user;
    private final String password;

    public PropertiesReader(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public static PropertiesReader readProperties(Path path) {
        try (FileInputStream readProperties = new FileInputStream(String.valueOf(path))) {
            Properties property = new Properties();
            property.load(readProperties);
            String user = property.getProperty("user");
            String password = property.getProperty("password");
            return new PropertiesReader(user, password);
        } catch (IOException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }
}
