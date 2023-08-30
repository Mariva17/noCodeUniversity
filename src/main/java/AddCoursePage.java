import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddCoursePage {

    private SelenideElement formAddCourse = $(byCssSelector("[class='form-inputs MuiBox-root css-v5uos8']"));
    private SelenideElement inputFieldCourseName = $(byCssSelector("[class='MuiInputBase-input MuiOutlinedInput-input css-q1sikp']"));
    private SelenideElement selectFieldFaculty = $(byId("course-documents-form-Faculty-1389247778"));
    private SelenideElement listOfFaculties = $(byCssSelector("[class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']"));

    private ElementsCollection facultiesName = $$(byXpath("//*[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-1v4ul8e']"));

    private SelenideElement inputFieldCourseDescription = $(byId("course-documents-form-Description-1634506682"));

    private SelenideElement fieldCoverPhoto = $(byCssSelector("input[type='file']"));
    private SelenideElement uploadedPhoto = $(byXpath("((//*[@class='url'])/span)[1]"));
    private SelenideElement fieldStartDate = $(byXpath("(//input[@type='text'])[2]"));
    private SelenideElement chooseStartDate = $(byCssSelector("[class='rdrDay rdrDayEndOfMonth']"));

    private SelenideElement fieldEndDate = $(byXpath("(//input[@type='text'])[3]"));
    private SelenideElement chooseMonth = $(byCssSelector("[class='CaretRight']"));

    private SelenideElement chooseEndDate = $(byXpath("(//*[@class='rdrDayNumber'])/span[contains(text(), '21')]"));
    private SelenideElement chooseErlierEndDate = $(byXpath("(//*[@class='rdrDayNumber'])/span[contains(text(), '10')]"));

    private SelenideElement buttonAdd = $x("//button[text()='Add']");

    private SelenideElement errorMessage = $x("//*[@class='form-error-text']");

    private ElementsCollection faculties = $$(byXpath("//*[@class='MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-1v4ul8e']/*[@class='MuiTouchRipple-root css-w0pj6f']"));

    public void formAddCourseIsDisplayed() {
        formAddCourse.shouldBe(visible);
    }

    public void enterCourseName(String nameOfCourse) {
        inputFieldCourseName.shouldBe(visible);
        inputFieldCourseName.setValue(nameOfCourse);
    }
    public String enterFacultyName(int numberFaculty) {
        selectFieldFaculty.click();
        facultiesName.get(numberFaculty).click();
        return selectFieldFaculty.getValue();
    }

    public void checkFacultyName(String facultyName) {
        selectFieldFaculty.shouldHave(exactText(facultyName));
    }

    public void enterCourseDescription(String text) {
        inputFieldCourseDescription.setValue(text);
    }

    public void uploadFile(String photoPath) {
        fieldCoverPhoto.uploadFile(new File(photoPath));
    }
    public void checkUploadedFile(String photo) {
        uploadedPhoto.shouldBe(visible);
        uploadedPhoto.shouldHave(matchText(photo));
    }



    public void enterStartDate() {
        fieldStartDate.click();
        chooseStartDate.click();
    }
    public void enterEndDate() {
        fieldEndDate.click();
        chooseMonth.click();
        chooseEndDate.click();
    }
    public void enterInvalidEndDate() {
        fieldEndDate.click();
        chooseErlierEndDate.click();
    }
    public void pushButtonAdd() {
        buttonAdd.shouldBe(visible);
        buttonAdd.click();
    }

    public void checkErrorMessage(String errorText) {
        buttonAdd.click();
        errorMessage.shouldBe(visible, exist);
        errorMessage.shouldHave(text(errorText));
    }

    public void checkQuantityOfFaculties(Integer quantityOfFaculties) {
        selectFieldFaculty.click();
        faculties.filterBy(visible).shouldHave(size(quantityOfFaculties));
    }

    public void urlIsCorrect() {
        sleep(3000);
        assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().contains("add-course"));
    }

}
