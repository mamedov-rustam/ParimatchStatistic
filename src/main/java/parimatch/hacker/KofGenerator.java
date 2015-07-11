package parimatch.hacker;

import java.util.Random;

/**
 * Created by rustam on 11.07.15.
 */
public class KofGenerator {
    public static double generate() {
        Random random = new Random();
        double pice = (random.nextInt(22) * 5) / 100d;
        return 1.5 + pice;
    }
}
