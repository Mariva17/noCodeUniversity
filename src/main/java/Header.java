import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Header {

    private SelenideElement buttonCourses = $(byXpath("//span[contains(text(), 'Courses')]"));
    private SelenideElement buttonDropDownCourseList = $(byXpath("//span[contains(text(), 'Course list')]"));
    private SelenideElement buttonAddCourse = $(byAttribute("href", "/add-course"));

    private SelenideElement buttonAvatar = $(byCssSelector("button[class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-17qbyv7']"));

    private SelenideElement buttonMyProfile = $(byXpath("//span[contains(text(), 'My Profile')]"));

    private SelenideElement buttonSignOut = $(byXpath("//span[contains(text(), 'Sign Out')]"));
    private SelenideElement buttonProfessors = $(byAttribute("href", "/#teacher-spotlight-heading")).lastChild();

    private SelenideElement buttonStudentDirectory = $(byAttribute("href", "/student-directory"));
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
    public void pushTheButtonProfessors() {
      //  sleep(3000);
      //  buttonProfessors.shouldBe(visible);
        buttonProfessors.click();

    }

    public void pushTheButtonCourses() {
        sleep(3000);
        buttonCourses.shouldBe(visible).click();
    }
    public void pushTheButtonCourseList() {
        sleep(2000);
        buttonDropDownCourseList.shouldBe(visible).click();
    }
    public void pushTheButtonStudentDirectory() {
        buttonStudentDirectory.shouldBe(visible).click();
    }

    public void checkUpdatedProfileByAvatar(String name) {
        avatar.shouldHave(attributeMatching("alt", name));
    }



}
