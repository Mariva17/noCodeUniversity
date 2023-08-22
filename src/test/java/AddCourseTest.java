import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import utils.PropertiesLoader;

@DisplayName("Add New Course Tests")
public class AddCourseTest extends BaseTest {

    private String userTeacher = PropertiesLoader.loadProperties("userTeacher");

    private String teacherPassword = PropertiesLoader.loadProperties("teacherPassword");

    private String photoOfCourse = "C:/Users/mariv/IdeaProjects/project_NoCodeUniversity/src/test/data/Photo_QA2.jpg";
    @Test
    @DisplayName("Valid addition of a New Course")
    public void successfulCourseAddition() {
        homePage.goToTheLoginPage();
        loginPage.successfulLogin(userTeacher, teacherPassword);
        mainTeacherPage.buttonAddCourseIsVisible();
        header.goToThePageAddCourse();
        addCoursePage.formAddCourseIsDisplayed();
        String name = "Course-QA" + randomString();
        addCoursePage.enterCourseName(name);
        String faculty = addCoursePage.enterFacultyName(1);
        addCoursePage.enterCourseDescription("New QA methods.");
        addCoursePage.uploadFile(photoOfCourse);
        addCoursePage.checkUploadedFile(".*Photo.*");
        addCoursePage.enterStartDate();
        addCoursePage.enterEndDate();
        addCoursePage.pushButtonAdd();
        profileOfTeacherPage.checkNameOfCourse(name);
    }
    @Test
    @DisplayName("Button Add must lead to the page Profile Of Teacher" )
    public void checkTheButtonAdd() {
        homePage.goToTheLoginPage();
        loginPage.successfulLogin(userTeacher, teacherPassword);
        mainTeacherPage.buttonAddCourseIsVisible();
        header.goToThePageAddCourse();
        addCoursePage.formAddCourseIsDisplayed();
        String name = "Course-QA" + randomString();
        addCoursePage.enterCourseName(name);
        String faculty = addCoursePage.enterFacultyName(3);
        addCoursePage.enterCourseDescription("New methods in Sciences.");
        addCoursePage.uploadFile(photoOfCourse);
        addCoursePage.checkUploadedFile(".*Photo.*");
        addCoursePage.enterStartDate();
        addCoursePage.enterEndDate();
        addCoursePage.pushButtonAdd();
        profileOfTeacherPage.urlIsCorrect();
    }
//    @Test
//    public void emptyFieldCourseName() {
//        homePage.goToTheLoginPage();
//        loginPage.successfulLogin(userTeacher, teacherPassword);
//        mainTeacherPage.buttonAddCourseIsVisible();
//        header.goToThePageAddCourse();
//        addCoursePage.formAddCourseIsDisplayed();
//        addCoursePage.enterFacultyName(3);
//        addCoursePage.enterCourseDescription("New methods in Sciences.");
//        addCoursePage.uploadFile(photoOfCourse);
//        addCoursePage.checkUploadedFile(".*Photo.*");
//        addCoursePage.enterStartDate();
//        addCoursePage.enterEndDate();
//        addCoursePage.pushButtonAdd();
//        addCoursePage.checkErrorMessage("Course name is required");
//    }
//    @Test
//    public void emptyFieldFaculty() {
//        homePage.goToTheLoginPage();
//        loginPage.successfulLogin(userTeacher, teacherPassword);
//        mainTeacherPage.buttonAddCourseIsVisible();
//        header.goToThePageAddCourse();
//        addCoursePage.formAddCourseIsDisplayed();
//        addCoursePage.enterCourseName("New Course-3");
//        addCoursePage.enterCourseDescription("New methods in Sciences.");
//        addCoursePage.enterStartDate();
//        addCoursePage.enterEndDate();
//        sleep(2000);
//        addCoursePage.pushButtonAdd();
//        addCoursePage.checkErrorMessage("Faculty is required");
//    }
//    @Test
//    public void emptyFieldCourseDescription() {
//        homePage.goToTheLoginPage();
//        loginPage.successfulLogin(userTeacher, teacherPassword);
//        mainTeacherPage.buttonAddCourseIsVisible();
//        header.goToThePageAddCourse();
//        addCoursePage.formAddCourseIsDisplayed();
//        addCoursePage.enterCourseName("New Course-3");
//        addCoursePage.enterFacultyName(2);
//        addCoursePage.uploadFile(photoOfCourse);
//        addCoursePage.checkUploadedFile(".*Photo.*");
//        addCoursePage.enterStartDate();
//        addCoursePage.enterEndDate();
//        addCoursePage.pushButtonAdd();
//        addCoursePage.checkErrorMessage("Course description is required");
//    }
//    @Test
//    public void emptyFieldStartDate() {
//        homePage.goToTheLoginPage();
//        loginPage.successfulLogin(userTeacher, teacherPassword);
//        mainTeacherPage.buttonAddCourseIsVisible();
//        header.goToThePageAddCourse();
//        addCoursePage.formAddCourseIsDisplayed();
//        addCoursePage.enterCourseName("New Course-3");
//        addCoursePage.enterFacultyName(6);
//        addCoursePage.enterCourseDescription("New methods in Sciences.");
//        addCoursePage.uploadFile(photoOfCourse);
//        addCoursePage.checkUploadedFile(".*Photo.*");
//        addCoursePage.enterEndDate();
//        addCoursePage.pushButtonAdd();
//        addCoursePage.checkErrorMessage("Course start date is required");
//    }
//    @Test
//    public void emptyFieldEndDate() {
//        homePage.goToTheLoginPage();
//        loginPage.successfulLogin(userTeacher, teacherPassword);
//        mainTeacherPage.buttonAddCourseIsVisible();
//        header.goToThePageAddCourse();
//        addCoursePage.formAddCourseIsDisplayed();
//        addCoursePage.enterCourseName("New Course-3");
//        addCoursePage.enterFacultyName(5);
//        addCoursePage.enterCourseDescription("New methods in Sciences.");
//        addCoursePage.uploadFile(photoOfCourse);
//        addCoursePage.checkUploadedFile(".*Photo.*");
//        addCoursePage.enterStartDate();
//        addCoursePage.pushButtonAdd();
//        addCoursePage.checkErrorMessage("Course end date is required");
//    }
    @Test
    @DisplayName("EndDate of the new Course must be later, than StartDate of the Course")
    public void erlierThanStartDateDataInFieldEndDate() {
        homePage.goToTheLoginPage();
        loginPage.successfulLogin(userTeacher, teacherPassword);
        mainTeacherPage.buttonAddCourseIsVisible();
        header.goToThePageAddCourse();
        addCoursePage.formAddCourseIsDisplayed();
        addCoursePage.enterCourseName("New Course-Science");
        addCoursePage.enterFacultyName(4);
        addCoursePage.enterCourseDescription("New methods in Sciences.");
        addCoursePage.enterStartDate();
        addCoursePage.enterInvalidEndDate();
        addCoursePage.pushButtonAdd();
        addCoursePage.checkErrorMessage("Course end date must be later than start date");
    }

}
