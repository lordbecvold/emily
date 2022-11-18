package xyz.becvold.emily.utils;

import java.text.Normalizer;

/**
 * @author Lukáš Bečvář on 18.11.22
 * @project Emily
 */
public class StringUtils {

    // remove special characters form string
    public static String unaccent(String src) {
        return Normalizer.normalize(src, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
}
