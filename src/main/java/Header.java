import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class Header {

    private SelenideElement buttonAddCourse = $(byAttribute("href", "/add-course"));

    private SelenideElement buttonAvatar = $(byCssSelector("button[class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-17qbyv7']"));

    private SelenideElement buttonMyProfile = $(byXpath("//span[contains(text(), 'My Profile')]"));

    private SelenideElement buttonSignOut = $(byXpath("//span[contains(text(), 'Sign Out')]"));
    private SelenideElement buttonProfessors = $(byAttribute("href", "/#teacher-spotlight-heading"));

    private SelenideElement avatar = $(byCssSelector("button[type='button']:nth-child(1)"));




    public void goToThePageAddCourse() {
        buttonAddCourse.click();
    }
    public void pushButtonAvatar() {
        buttonAvatar.shouldBe(visible).click();
    }

    public void pushButtonMyProfile() {
        buttonMyProfile.shouldBe(visible).click();
    }

    public void pushButtonSignOut() {
        buttonSignOut.shouldBe(visible).click();
    }
    public void goToThePageProfessors() {
        buttonProfessors.click();
    }

    public void checkUpdatedProfileByAvatar(String name) {
        avatar.shouldHave(attributeMatching("alt", name));
    }



}
