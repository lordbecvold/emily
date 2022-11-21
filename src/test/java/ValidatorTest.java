import org.junit.Assert;
import org.junit.Test;
import xyz.becvold.emily.EmilyCore;
import xyz.becvold.emily.utils.StringUtils;

/**
 * @author Lukáš Bečvář on 18.11.22
 * @project Emily
 */
public class ValidatorTest {

    public EmilyCore core = new EmilyCore();
    public StringUtils stringUtils = new StringUtils();

    @Test
    public void unaccentTest() {
        String unaccent = StringUtils.unaccent("ěščřžýáíé");
        Assert.assertEquals("escrzyaie", unaccent);
    }

    @Test
    public void inputValidateTest() {
        String input = stringUtils.validateInput("ŠĚŘÍK");
        Assert.assertEquals("serik", input);
    }
}