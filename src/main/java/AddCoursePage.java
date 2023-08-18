import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class AddCoursePage {

    private SelenideElement formAddCourse = $(byCssSelector("[class='form-inputs MuiBox-root css-v5uos8']"));
    private SelenideElement inputFieldCourseName = $(byCssSelector("[class='MuiInputBase-input MuiOutlinedInput-input css-q1sikp']"));
    private SelenideElement selectFieldFaculty = $(byId("course-documents-form-Faculty-1389247778"));
    private SelenideElement listOfFaculties = $(byCssSelector("[class='MuiList-root MuiList-padding MuiMenu-list css-r8u8y9']"));
    private SelenideElement facultySciences = $(byAttribute("data-value", "Sciences"));
    private SelenideElement facultyBusinessSchool = $(byAttribute("data-value", "Business School"));
    private SelenideElement facultyEngineering = $(byAttribute("data-value", "Engineering"));
    private SelenideElement facultyLaw = $(byAttribute("data-value", "Law"));
    private SelenideElement facultyMedicine = $(byAttribute("data-value", "Medicine"));
    private SelenideElement facultyArtsDesignArchitecture = $(byAttribute("data-value", "Arts, Design & Architecture"));
    private SelenideElement inputFieldCourseDescription = $(byId("course-documents-form-Description-1634506682"));

    private SelenideElement fieldCoverPhoto = $(byCssSelector("input[type='file']"));
    private SelenideElement uploadedPhoto = $(byXpath("((//*[@class='url'])/span)[1]"));
    private SelenideElement fieldStartDate = $(byXpath("(//input[@type='text'])[2]"));
    private SelenideElement chooseStartDate = $(byCssSelector("[class='rdrDay rdrDayEndOfMonth']"));

    private SelenideElement fieldEndDate = $(byXpath("(//input[@type='text'])[3]"));
    private SelenideElement chooseMonth = $(byCssSelector("[class='CaretRight']"));

    private SelenideElement chooseEndDate = $(byXpath("(//*[@class='rdrDayNumber'])/span[contains(text(), '21')]"));

    private SelenideElement buttonAdd = $(byCssSelector("button[type='submit']"));

    private SelenideElement errorCourseName = $(byXpath("(//*[@class='form-error-text'])/span"));

    public void formAddCourseIsDisplayed() {
        formAddCourse.shouldBe(visible);
    }

    public void enterCourseName(String nameOfCourse) {
        inputFieldCourseName.shouldBe(visible);
        inputFieldCourseName.setValue(nameOfCourse);
    }
    public void enterFacultySciences() {
        selectFieldFaculty.click();
        facultySciences.click();
    }
    public void enterFacultyBusinessSchool() {
        selectFieldFaculty.click();
        facultyBusinessSchool.click();
    }
    public void enterFacultyEngineering() {
        selectFieldFaculty.click();
        facultyEngineering.click();
    }
    public void enterFacultyLaw() {
        selectFieldFaculty.click();
        facultyLaw.click();
    }
    public void enterFacultyMedicine() {
        selectFieldFaculty.click();
        facultyMedicine.click();
    }
    public void enterFacultyArtsDesignArchitecture() {
        selectFieldFaculty.click();
        facultyArtsDesignArchitecture.click();
    }
    public void checkFacultyName(String facultyName) {
        selectFieldFaculty.shouldHave(text(facultyName));
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


    //    public void setDateByName(SelenideElement name, String date) {
//        executeJavaScript(
//                String.format("$('[name=\"%s\"]').val('%s')",
//                        name, date)
//        );
//    }
    public void enterStartDate() {
        fieldStartDate.click();
        chooseStartDate.click();
    }
    public void enterEndDate() {
        fieldEndDate.click();
        chooseMonth.click();
        chooseEndDate.click();
    }
    public void pushButtonAdd() {
        buttonAdd.click();
    }
    public void checkErrorMessage(String errorMessage) {
        errorCourseName.shouldHave(text(errorMessage));
    }


}
