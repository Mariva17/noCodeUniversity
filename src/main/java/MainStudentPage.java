import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class MainStudentPage {

    private SelenideElement buttonAvatar = $(byCssSelector("button[class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-17qbyv7']"));

    private SelenideElement buttonMyProfile = $(byCssSelector("span[class='sw-font-size-m sw-text-color-424242 sw-font-family-default sw-font-weight-normal sw-letter-spacing-normal MuiBox-root css-2rlxtj']"));

    private SelenideElement buttonStudentDirectoryOnHeader = $(byAttribute("href", "/student-directory"));
    private SelenideElement buttonSignOut = $(byXpath("//span[contains(text(), 'Sign Out')]"));


    public void pushButtonAvatar() {
        buttonAvatar.shouldBe(visible).click();
    }

    public void pushButtonMyProfile() {
        buttonMyProfile.shouldBe(visible).click();
    }


    public void pushButtonSignOut() {
        buttonSignOut.shouldBe(visible).click();
    }


    public void checkButtonStudentDirectory() {
        buttonStudentDirectoryOnHeader.shouldBe(visible);
    }


}
