import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.Assert.assertTrue;

public class ProfileOfTeacherPage {

    private ElementsCollection courses = $$(byCssSelector("[class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3 css-iqrbd0']"));

 //   private SelenideElement nameOfCourse = $(byXpath("//h3[contains(text(), 'New Course-2')]"));

    private ElementsCollection imageOfProfile = $$(byXpath("(//*[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 MuiGrid-grid-lg-12 css-mfstbn'])//*[contains(@class, 'static-image')]"));


    public void urlIsCorrect() {
        assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("teacher-details?recordId"));
    }

    public void checkNameOfCourse(String expectedName) {
        for (SelenideElement course : courses) {
            course.shouldHave(text(expectedName));
        }
    }

    public void checkImageOfProfile() {
        imageOfProfile.filterBy(visible).shouldHave(size(1));
    }



}
