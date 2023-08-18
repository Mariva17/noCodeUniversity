import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private SelenideElement logo = $(byCssSelector("[class='sw-width-5xs']"));
    private SelenideElement buttonSignIn = $(byAttribute("href", "/sign-in"));
    private SelenideElement buttonSignUp = $(byAttribute("href", "/sign-up"));

    public void logoShodBeDisplayed() {
        logo.shouldBe(visible);
    }
    public void checkLogoImage() {
        logo.shouldHave(attributeMatching("src", ".*57723b6b-77df-40f3-b2ce-af8d5a40d680.svg.*"));
    }
    public void goToTheLoginPage() {
        buttonSignIn.click();

    }
    public void goToTheRegistrationPage() {
        buttonSignUp.click();
    }

}
