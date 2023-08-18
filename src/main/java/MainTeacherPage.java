import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;

public class MainTeacherPage {

    private SelenideElement buttonAddCourse = $(byAttribute("href", "/add-course"));

    private SelenideElement buttonAvatar = $(byCssSelector("button[class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-17qbyv7']"));

    private SelenideElement buttonMyProfile = $(byCssSelector("span[class='sw-font-size-m sw-text-color-424242 sw-font-family-default sw-font-weight-normal sw-letter-spacing-normal MuiBox-root css-2rlxtj']"));



    public void buttonAddCourseIsVisible() {
        buttonAddCourse.shouldBe(visible);
    }

    public void goToThePageAddCourse() {
        buttonAddCourse.click();
    }

    public void pushButtonAvatar() {
        buttonAvatar.shouldBe(visible).click();
    }

    public void pushButtonMyProfile() {
        buttonMyProfile.shouldBe(visible).click();
    }


}
