package com.everlaw;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Manages input and returns a move.
 * @author Jose Danado (jose.danado@gmail.com)
 */
public class Input {
    private Pattern pattern;

    public Input() {
        pattern = Pattern.compile("([a-h])([1-8])");
    }

    public Move getMove() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Matcher m = pattern.matcher(line);
        if (m.find( )) {
            return new Move(m.group(1), m.group(2));
        }else {
            System.out.println("Try entering a letter and number (e.g.) [a1]");
            return null;
        }
    }
}
