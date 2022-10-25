package guru.qa.utils;

import java.util.Random;

//import static com.sun.tools.classfile.Module_attribute.ProvidesEntry.length;

public class RandomUtils {
    public static String getRandomString(int lenght) {
            String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            StringBuilder result = new StringBuilder();
            Random rnd = new Random();
            {
                int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                result.append(SALTCHARS.charAt(index));
            }

            return result.toString();
    }

    public static String getRandomEmail(){
        return getRandomString(10) + "@qa.guru";
    }

    public static String getRandomNumber(){
        return getRandomString(10);
    }
}
