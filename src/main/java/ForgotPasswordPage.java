import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

public class ForgotPasswordPage {

    private SelenideElement inputFieldEmail = $(byCssSelector("[placeholder='email']"));

    public void urlIsCorrect() {
        assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("forgot-password"));
    }

    public void checkInputFieldEmail() {
        inputFieldEmail.shouldBe(visible);
    }


}
