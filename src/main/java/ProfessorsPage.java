import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ProfessorsPage {

    private SelenideElement inputSearch = $(byCssSelector("input[id=':r0:']"));

    private SelenideElement nameOfSelectedProfessor = $(byXpath("//*[@class='field-teacher-spotlight-logged-in-0-heading3-_i7tulsj9u MuiBox-root css-blhqza']"));

    private SelenideElement profileImage = $(byXpath("(//*[@class='static-image'])[4]"));
    private SelenideElement buttonViewProfile = $(byXpath("(//a[@type='button'])[4]"));


    public void fillTheSearchField(String name) {
        inputSearch.shouldBe(visible);
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
        buttonViewProfile.click();
    }

}
