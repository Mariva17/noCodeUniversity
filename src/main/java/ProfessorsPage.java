import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class ProfessorsPage {

    private SelenideElement inputSearch = $(byXpath("//input[@placeholder='Search by course name or professor']"));

    private SelenideElement nameOfSelectedProfessor = $(byXpath("//*[@class='field-teacher-spotlight-logged-in-0-heading3-_i7tulsj9u MuiBox-root css-blhqza']"));

    private SelenideElement profileImage = $(byXpath("(//*[@class='static-image'])[4]"));
    private SelenideElement buttonViewProfile = $(byXpath("(//a[@type='button'])[4]"));

    private SelenideElement professorsSpotlight = $(byCssSelector("[class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-4 test css-a98qzh']"));
    private ElementsCollection listOfTeachers = $$(byCssSelector("[class='field-teacher-spotlight-logged-in-0-text-_kbtr0o728 MuiBox-root css-blhqza']"));


    public void fillTheSearchField(String name) {
        inputSearch.shouldBe(enabled);
        inputSearch.setValue(name);

    }

    public void checkNameOfSelectedProfessor(String name) {
        nameOfSelectedProfessor.shouldBe(visible);
        nameOfSelectedProfessor.shouldHave(text(name));
    }
    public void checkProfileImage() {
        profileImage.shouldBe(visible);
    }

    public void goToTheProfileOfProfessor() {
        buttonViewProfile.shouldBe(visible);
        buttonViewProfile.click();
    }

    public void checkListOfTeachersIsDisplayed() {
        professorsSpotlight.shouldBe(visible);
    }
    public void checkListOfTeachers(String role) {
         fillTheSearchField("mal");
         sleep(3000);

        for (SelenideElement teacher : listOfTeachers) {
            teacher.shouldHave(text(role));
        }

    }

}
