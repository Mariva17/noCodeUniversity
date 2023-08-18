import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.Assert.assertTrue;

public class ProfileOfTeacherPage {

    private ElementsCollection courses = $$(byCssSelector("[class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3 css-iqrbd0']"));

    private SelenideElement nameOfCourse = $(byXpath("//h3[contains(text(), 'New Course-2')]"));


    public void urlIsCorrect() {
        assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("teacher-details?recordId"));
    }

    public void checkNameOfCourse(String expectedName) {
        for (SelenideElement course : courses) {
            course.shouldHave(text(expectedName));
        }
    }


}
