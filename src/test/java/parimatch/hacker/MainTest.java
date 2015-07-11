package parimatch.hacker;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by rustam on 10.07.15.
 */
public class MainTest {
    public static final int START_MONEY = 200;
    public static final int MIN_BET = 4;
    private static GamesService gamesService;

    @Before
    public void init() throws IOException {
        String html = IOUtils.toString(new FileReader("res/34718.txt"));
        gamesService = new GamesService(html, null);
    }

    @Test
    public void totalTest() throws IOException {
        for (String command : Commands.all()) {
            try {
                totalTest(command);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("----------------------");
            }
        }
    }

    public static void totalTest(String command) throws IOException {
        Player player = new Player(START_MONEY, MIN_BET);
        List<MatchWithTotal> matchWithTotalList = gamesService.findMatches(command);

        System.out.println("---------- " + command + " ----------");

        for (MatchWithTotal matchWithTotal : matchWithTotalList) {
            double kof = matchWithTotal.getTotalOverKof();
            player.makeBet(kof);
            if (matchWithTotal.isTotalOver()) {
                System.out.println("Result: win");
                player.win();
            } else {
                System.out.println("Result: lose");
                player.upBet();
            }
            System.out.println("----------------------");
        }

        System.out.println("******************");
        double result = player.getMoney() - START_MONEY;
        if (result > 0) {
            System.out.printf("  We win: %.2f \n", result);
        } else {
            System.out.printf("  We loss: %.2f \n", Math.abs(result));
        }
        System.out.println("******************");
        System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
    }

    public static String ask(String ask) {
        System.out.print(ask + ": ");
        return new Scanner(System.in).nextLine();
    }
}
