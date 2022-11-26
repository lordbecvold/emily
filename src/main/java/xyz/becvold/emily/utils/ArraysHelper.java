package xyz.becvold.emily.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lukáš Bečvář on 26.11.22
 * @project Emily
 */
public class ArraysHelper {

    // init objects
    public StringUtils stringUtils = new StringUtils();

    // function for return list with validation for input recognition
    public List createFinalInputList(List inputList) {

        // create final input list
        List list = new ArrayList();

        // validate input & add to list
        for (Object element:inputList) {
            list.add(stringUtils.validateInput(element.toString()));
        }

        // return final list
        return list;
    }

    // check if element in list starts with input
    public boolean inputStartsWithElement(List list, String input) {

        // check all elements in list equals valid input
        for (Object element:list) {
            if (input.startsWith(element.toString())) {
                return true;
            }
        }

        // final return false
        return false;
    }

    // check if element in list contains input
    public boolean inputContainsElement(List list, String input) {

        // check all elements in list equals valid input
        for (Object element:list) {
            if (input.contains(element.toString())) {
                return true;
            }
        }

        // final return false
        return false;
    }
}
