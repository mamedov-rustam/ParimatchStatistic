package parimatch.hacker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rustam on 11.07.15.
 */
public class Commands {
    private static List<String> commands;

    static {
        commands = new ArrayList<>();
        commands.add("Беларусь");
        commands.add("Пари-Матч");
        commands.add("Испания");
        commands.add("Украина");
        commands.add("Россия");
        commands.add("Аргентина");
        commands.add("Молдова");
        commands.add("Англия");
        commands.add("Португалия");
        commands.add("Бразилия");
        commands.add("Нигерия");
        commands.add("Германия");
        commands.add("Франция");
        commands.add("Грузия");
        commands.add("Италия");
        commands.add("Нидерланды");
    }

    public static List<String> all() {
        return commands;
    }
}
