import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    private SelenideElement formOfRegistration = $(byId("signup"));
    private SelenideElement selectRoleField = $(byCssSelector("[class='btn dropdown-toggle btn-light bs-placeholder']"));
    private SelenideElement selectElementTeacher = $(byId("bs-select-1-0"));
    private SelenideElement selectElementStudent = $(byId("bs-select-1-1"));
    private SelenideElement selectedRole = $(byCssSelector("[class='filter-option-inner-inner']"));
    private SelenideElement inputFieldFullName = $(byAttribute("placeholder", "Full Name"));
    private SelenideElement inputFieldEmail = $(byAttribute("placeholder", "Email"));
    private SelenideElement inputFieldPassword = $(byAttribute("placeholder", "Password"));
    private SelenideElement checkBoxAgree = $(byCssSelector("[class='checkmark position-relative sw-checkbox']"));
    private SelenideElement buttonSignUp  = $(byId("sw-sign-up-submit-btn"));

    private SelenideElement errorMessage = $(byCssSelector("[class='error-message required-errors d-block']"));
    private SelenideElement errorMessageOfPassword = $(byCssSelector("[class='validation-message d-none d-block']"));



    public void checkFormOfRegistration() {
        formOfRegistration.shouldBe(visible);
    }
    public void selectRoleStudent() {
        selectRoleField.shouldBe(visible).click();
        selectElementStudent.click();
    }
    public void selectRoleTeacher() {
        selectRoleField.shouldBe(visible).click();
        selectElementTeacher.click();
    }
    public void checkSelectedElement(String role) {
        selectedRole.shouldHave(text(role));
    }
    public void enterFullName(String fullName) {
        inputFieldFullName.setValue(fullName);
    }
    public void enterEmail(String email) {
        inputFieldEmail.setValue(email);
    }
    public void enterPassword(String password) {
        inputFieldPassword.setValue(password);
    }
    public void clickOnCheckBox() {
        checkBoxAgree.click();
    }
    public void pushButtonSignUp() {
        buttonSignUp.click();
    }
    public void checkErrorMessageOfRegistration(String errorText) {
        errorMessage.shouldBe(visible);
        errorMessage.shouldHave(text(errorText));
    }

    public void checkErrorMessageOfPasswordField(String errorText) {
        errorMessageOfPassword.shouldBe(visible);
        errorMessageOfPassword.shouldHave(text(errorText));
    }


}
