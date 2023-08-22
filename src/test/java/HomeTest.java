import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@DisplayName("Home page test")
public class HomeTest extends BaseTest {

    @Test
    @DisplayName("Icon of logo should be correct")
    public void checkLogoIsCorrect() {
        homePage.logoShodBeDisplayed();
        homePage.checkLogoImage();
    }

}
