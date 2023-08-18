import org.junit.Test;

public class HomeTest extends BaseTest {

    @Test
    public void checkLogoIsCorrect() {
        homePage.logoShodBeDisplayed();
        homePage.checkLogoImage();
    }

}
