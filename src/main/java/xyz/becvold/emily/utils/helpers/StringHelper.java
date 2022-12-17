package xyz.becvold.emily.utils.helpers;

import java.text.Normalizer;

/**
 * @author Lukáš Bečvář on 18.11.22
 * @project Emily
 */
public class StringHelper {

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

        // remove special chars
        input = input.replaceAll(",", "");
        input = input.replaceAll("!", "");
        input = input.replaceAll("'", "");
        input = input.replaceAll("\\.", "");
        input = input.replaceAll("\\?", "");

        // remove spaces
        input = input.replaceAll(" ", "");

        // return valid input
        return input;
    }
}
