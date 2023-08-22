import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CoursesPage {

    private SelenideElement containerFaculties = $(byXpath("//*[@class='container MuiBox-root css-han2om']"));
    private ElementsCollection facultiesOfCourses = $$(byXpath("//*[@class='MuiButtonBase-root MuiChip-root MuiChip-outlined MuiChip-sizeSmall MuiChip-colorDefault MuiChip-clickable MuiChip-clickableColorDefault MuiChip-outlinedDefault tag css-kjxbns']/span[@class='MuiChip-label MuiChip-labelSmall css-u95dmd']"));

    private SelenideElement buttonDiscoverMore = $(byXpath("//button[contains(text(), 'Discover more')]"));

    private ElementsCollection courses = $$(byCssSelector("[class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3 css-iqrbd0']"));

    private SelenideElement buttonAddCourse = $(byAttribute("href", "/add-course"));

    public Integer checkFacultiesOfCourses() {
        containerFaculties.shouldBe(visible);
        sleep(3000);
        int numberOfCourses = facultiesOfCourses.filterBy(visible).size();
        return numberOfCourses;
    }
    public void pushButtonDiscoverMore() {
        buttonDiscoverMore.shouldBe(visible).click();
    }
    public void checkNumberOfCourses(int numberDisplayedCourses) {
        courses.filterBy(visible).shouldHave(size(numberDisplayedCourses));
    }

    public void pushButtonAddCourse() {
        buttonAddCourse.shouldBe(visible).click();
    }

}
