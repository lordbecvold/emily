package xyz.becvold.emily.utils;

import java.text.Normalizer;

/**
 * @author Lukáš Bečvář on 18.11.22
 * @project Emily
 */
public class StringUtils {

    // remove special characters form string
    public String unaccent(String src) {
        return Normalizer.normalize(src, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    // input validate function
    public String validateInput(String input) {

        // replace special chars
        input = unaccent(input);

        // replace all to lower case
        input = input.toLowerCase();

        // remove comma
        input = input.replaceAll(",", "");

        // return valid input
        return input;
    }
}
