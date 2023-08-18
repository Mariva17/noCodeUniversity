import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertEquals;

public class UserProfilePage {

    private SelenideElement buttonAvatar = $(byCssSelector("button[class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-17qbyv7']"));

    private SelenideElement fieldUserRole = $(byCssSelector("[class='filter-option-inner-inner']"));

    private SelenideElement fieldFullName = $(byCssSelector("input[id='sw-form-capture-full_name-input']"));

    private SelenideElement fieldUserEmail = $(byCssSelector("input[id='sw-form-capture-email-input']"));

    private SelenideElement textareaAbout = $(byCssSelector("textarea[id='sw-form-capture-About']"));

    private SelenideElement avatarImage = $(byCssSelector("input[type='file']"));
    private SelenideElement buttonUpdateProfile = $(byCssSelector("[id='sw-update-profile-btn']"));


    private SelenideElement fieldOldPassword = $(byCssSelector("input[id='sw-form-password-input']"));

    private SelenideElement fieldNewPassword = $(byCssSelector("input[id='sw-new-password-input']"));

    private SelenideElement buttonChangePassword = $(byId("sw-change-password-btn"));

    private SelenideElement errorMessageChangePassword = $(byCssSelector("[class='validation-message d-none d-block']"));

    private SelenideElement errorMessageOldPassword = $(byCssSelector("[class='error-message password-errors d-block']"));

    private SelenideElement errorMessageAdditional = $(byCssSelector("[class='toast-message']"));



    public void checkFieldRole(String role) {

        fieldUserRole.shouldBe(exactText(role));
    }

    public void changeFullName(String name) {
        fieldFullName.getValue();
        fieldFullName.clear();
        fieldFullName.setValue(name);
    }

    public void checkEmailInProfile(String email) {
        assertEquals(fieldUserEmail.getValue(), email);

    }
    public void fillTextareaAbout(String textAbout) {
        textareaAbout.setValue(textAbout);
    }

    public void uploadAvatarFile(String photoPath) {
        avatarImage.uploadFile(new File(photoPath));
    }

    public void pushTheButtonUpdateProfile() {
        buttonUpdateProfile.click();
    }



    public void fillInputFieldOldPassword(String oldPassword) {
        fieldOldPassword.shouldBe(visible);
        fieldOldPassword.setValue(oldPassword);
    }

    public void fillInputFieldNewPassword(String newPassword) {
        fieldNewPassword.setValue(newPassword);
    }
    public void pushTheButtonChangePassword() {
        buttonChangePassword.click();
    }

    public void checkErrorMessage(String textError) {
        errorMessageChangePassword.shouldHave(text(textError));
    }

    public void checkErrorMessageWithInvalidOldPassword(String textError) {
        errorMessageOldPassword.shouldHave(text(textError));
    }

    public void checkErrorMessageAdditional(String textError) {
        errorMessageAdditional.shouldHave(text(textError));
    }


}
