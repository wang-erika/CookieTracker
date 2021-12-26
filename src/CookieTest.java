import org.junit.Assert;
import org.junit.Test;

import java.io.File;


public class CookieTest {

    public String helper(String fileName) {
        ClassLoader cl = getClass().getClassLoader();
        File file = new File(cl.getResource(fileName).getFile());
       // System.out.println(file.getAbsolutePath());
        return file.getAbsolutePath();
    }

    @Test
    // Tests a successful case using the Test1.csv
    public void testCookiesSuccessfulCase() {
        try {
            String[] ret = Cookies.mostActiveCookie(helper("Test1.csv"), "2018-12-09");
            Assert.assertNotNull(ret);
            Assert.assertEquals(1, ret.length);
            Assert.assertEquals("abc", ret[0]);
        } catch (Exception e) {
            Assert.assertNull(e);
        }
    }
    @Test
    // Tests a case where the filename is invalid
    public void testCookiesInvalidFileName() {
        try {
            String[] ret = Cookies.mostActiveCookie(helper("not-exist-file.csv"), "2018-12-09");
        } catch (Exception e) {
            Assert.assertNotNull(e);
        }
    }
    @Test
    // Tests a case where the date is invalid
    public void testCookiesInvalidDateName() {
        Exception e1 = null;
        String[] ret = null;
        try {
            ret = Cookies.mostActiveCookie(helper("Test1.csv"), "2018-12-14");
        } catch (Exception e) {
            e1 = e;
        }
        Assert.assertNull(e1);
        Assert.assertNotNull(ret);
        Assert.assertEquals(0, ret.length);
    }
}
