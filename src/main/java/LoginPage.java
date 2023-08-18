import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement emailField = $(byCssSelector("[name='email']"));

    private SelenideElement passwordField = $(byCssSelector("[name='password']"));

    private SelenideElement buttonSignIn = $(byId("sw-sign-in-submit-btn"));

    private SelenideElement errorMessage = $(byCssSelector("[class='error-message login-error d-block']"));

    private SelenideElement buttonSignUp = $(byId("sw-go-to-sign-up-btn"));

    private SelenideElement forgotPasswordLink = $(byAttribute("href", "/forgot-password"));

    private SelenideElement hiddenPassword = $(byCssSelector("[class='fa show-password active fa-eye-slash']"));

    private SelenideElement showPassword = $(byCssSelector("[class='fa show-password active fa-eye']"));

    public void enterEmail(String userEmailValue) {
        emailField.shouldBe(visible);
        emailField.setValue(userEmailValue);
    }

    public void enterPassword(String passwordValue) {
        passwordField.setValue(passwordValue);
    }
    public void pushSignInButton() {
        buttonSignIn.click();
    }

    public void successfulLogin(String userEmailValue, String passwordValue) {
        enterEmail(userEmailValue);
        enterPassword(passwordValue);
        pushSignInButton();
    }

    public void checkErrorMessage(String expectedText) {
        errorMessage.shouldBe(visible);
        errorMessage.shouldHave(text(expectedText));
    }

    public void pushSignUpButton() {
        buttonSignUp.click();
    }

    public void followTheForgotPasswordLink() {
        forgotPasswordLink.shouldBe(visible);
        forgotPasswordLink.click();
    }

    public void checkPassword() {
        hiddenPassword.click();
        showPassword.shouldBe(visible);
    }


}
