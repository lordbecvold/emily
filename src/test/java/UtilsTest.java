import org.junit.Assert;
import org.junit.Test;
import xyz.becvold.emily.utils.ArraysHelper;
import xyz.becvold.emily.utils.StringUtils;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lukáš Bečvář on 18.11.22
 * @project Emily
 */
public class UtilsTest {

    public StringUtils stringUtils = new StringUtils();
    public ArraysHelper arraysHelper = new ArraysHelper();

    @Test
    public void unaccentTest() {
        String unaccent = stringUtils.unaccent("ěščřžýáíé");
        Assert.assertEquals("escrzyaie", unaccent);
    }

    @Test
    public void inputValidateTest() {
        String input = stringUtils.validateInput("ŠĚŘÍK");
        Assert.assertEquals("serik", input);
    }

    @Test
    public void arrayHelperContainsTest() {

        // create testing list
        List list = Arrays.asList("test1", "test2", "test3", "test4");

        // test function
        Assert.assertTrue(arraysHelper.inputContainsElement(list, "test1"));
        Assert.assertTrue(arraysHelper.inputContainsElement(list, "test2"));
        Assert.assertTrue(arraysHelper.inputContainsElement(list, "test3"));
        Assert.assertTrue(arraysHelper.inputContainsElement(list, "test4"));
        Assert.assertFalse(arraysHelper.inputContainsElement(list, "test5"));
    }

    @Test
    public void arrayHelperStartsWithTest() {

        // create testing list
        List list = Arrays.asList("test1", "test2", "test3", "test4");

        // test function
        Assert.assertTrue(arraysHelper.inputStartsWithElement(list, "test1, aaaa"));
        Assert.assertTrue(arraysHelper.inputStartsWithElement(list, "test2, bbbb"));
        Assert.assertTrue(arraysHelper.inputStartsWithElement(list, "test3, cccc"));
        Assert.assertTrue(arraysHelper.inputStartsWithElement(list, "test4. dddd"));
        Assert.assertFalse(arraysHelper.inputStartsWithElement(list, "test5, 3333"));
    }
}
