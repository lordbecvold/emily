import org.junit.Assert;
import org.junit.Test;
import xyz.becvold.emily.utils.IntUtils;
import xyz.becvold.emily.utils.StringUtils;

/**
 * @author Lukáš Bečvář on 18.11.22
 * @project Emily
 */
public class UtilsTest {

    public StringUtils stringUtils = new StringUtils();
    public IntUtils intUtils = new IntUtils();

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
}
