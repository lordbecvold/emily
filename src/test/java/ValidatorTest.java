import org.junit.Assert;
import org.junit.Test;
import xyz.becvold.emily.utils.StringUtils;

/**
 * @author Lukáš Bečvář on 18.11.22
 * @project Emily
 */
public class ValidatorTest {

    @Test
    public void unaccentTest() {
        String unaccent = StringUtils.unaccent("ěščřžýáíé");
        Assert.assertEquals("escrzyaie", unaccent);
    }
}
