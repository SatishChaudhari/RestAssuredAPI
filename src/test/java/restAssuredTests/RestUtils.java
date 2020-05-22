package restAssuredTests;

import org.apache.commons.lang3.RandomStringUtils;

//RestUtils is use to generate random input data
public class RestUtils {
    public static String getFirstName() {
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return ("John" + generatedString);
    }

    public static String getLastName() {
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return ("Kenedy" + generatedString);
    }

    public static String getUserName() {
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        return ("John" + generatedString);
    }

    public static String getPassword() {
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        return ("John" + generatedString);
    }

    public static String getEmail() {
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        return (generatedString + "Gmail.com");
    }

    public static String getEmpName() {
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        return ("John" + generatedString);
    }

    public static String getSalary() {
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        return ("1000" + generatedString);
    }

    public static String getAge() {
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        return (generatedString + "Gmail.com");
    }

}
