import api.ApiBase;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import utils.PropertiesLoader;

import static com.codeborne.selenide.Selenide.sleep;

@DisplayName("Add New Course Tests")
public class AddCourseTest extends BaseTest {

    Faker faker = new Faker();

    public String fullName = randomString();
    public String email = faker.internet().emailAddress();
    public String password = faker.internet().password(6, 12);
    static String endpoint = "/users/";

//    private String userTeacher = PropertiesLoader.loadProperties("userTeacher");
//
//    private String teacherPassword = PropertiesLoader.loadProperties("teacherPassword");

    private String photoOfCourse = "C:/Users/mariv/IdeaProjects/project_NoCodeUniversity/src/test/data/Photo_QA2.jpg";


    @After
    public void deleteCreatedUser() {
        ApiBase apiBase = new ApiBase();
        apiBase.deleteRequest(endpoint+email, 200);
    }
    @Test
    @DisplayName("Valid addition of a New Course")
    public void successfulCourseAddition() {
        String createdEmail = email;
        String usersPassword = password;
        homePage.goToTheRegistrationPage();
        registrationPage.registrationOfTeacher(fullName, createdEmail, usersPassword);
        header.goToThePageAddCourse();
        addCoursePage.formAddCourseIsDisplayed();
        String name = "Course-QA" + randomString();
        addCoursePage.enterCourseName(name);
        addCoursePage.enterFacultyName(1);
        addCoursePage.enterCourseDescription("New QA methods.");
        addCoursePage.uploadFile(photoOfCourse);
        addCoursePage.checkUploadedFile(".*Photo.*");
        addCoursePage.enterStartDate();
        addCoursePage.enterEndDate();
        addCoursePage.pushButtonAdd();
        profileOfTeacherPage.checkNameOfCourse(name);
    }
    @Test
    @DisplayName("Button Add doesn't lead to the page 404" )
    public void checkTheButtonAdd() {
        String createdEmail = email;
        String usersPassword = password;
        homePage.goToTheRegistrationPage();
        registrationPage.registrationOfTeacher(fullName, createdEmail, usersPassword);
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
        sleep(3000);
        addCoursePage.urlIsCorrect();
    }
    @Test
    @DisplayName("By empty field Course Name impossible addition of the new Course")
    public void emptyFieldCourseName() {
        String createdEmail = email;
        String usersPassword = password;
        homePage.goToTheRegistrationPage();
        registrationPage.registrationOfTeacher(fullName, createdEmail, usersPassword);
        header.goToThePageAddCourse();
        addCoursePage.formAddCourseIsDisplayed();
        addCoursePage.enterFacultyName(3);
        addCoursePage.enterCourseDescription("New methods in Sciences.");
        addCoursePage.uploadFile(photoOfCourse);
        addCoursePage.checkUploadedFile(".*Photo.*");
        addCoursePage.enterStartDate();
        addCoursePage.enterEndDate();
        addCoursePage.pushButtonAdd();
        addCoursePage.checkErrorMessage("Course name is required");
    }
    @Test
    @DisplayName("By empty field Faculty impossible addition of the new Course")
    public void emptyFieldFaculty() {
        String createdEmail = email;
        String usersPassword = password;
        homePage.goToTheRegistrationPage();
        registrationPage.registrationOfTeacher(fullName, createdEmail, usersPassword);
        header.goToThePageAddCourse();
        addCoursePage.formAddCourseIsDisplayed();
        addCoursePage.enterCourseName("New Course-3");
        addCoursePage.enterCourseDescription("New methods in Sciences.");
        addCoursePage.enterStartDate();
        addCoursePage.enterEndDate();
        addCoursePage.pushButtonAdd();
        addCoursePage.checkErrorMessage("Faculty is required");
    }
    @Test
    @DisplayName("By empty field Course Description impossible addition of the new Course")
    public void emptyFieldCourseDescription() {
        String createdEmail = email;
        String usersPassword = password;
        homePage.goToTheRegistrationPage();
        registrationPage.registrationOfTeacher(fullName, createdEmail, usersPassword);
        header.goToThePageAddCourse();
        addCoursePage.formAddCourseIsDisplayed();
        addCoursePage.enterCourseName("New Course-3");
        addCoursePage.enterFacultyName(2);
        addCoursePage.uploadFile(photoOfCourse);
        addCoursePage.checkUploadedFile(".*Photo.*");
        addCoursePage.enterStartDate();
        addCoursePage.enterEndDate();
        addCoursePage.pushButtonAdd();
        addCoursePage.checkErrorMessage("Course description is required");
    }
    @Test
    @DisplayName("By empty field StartDate impossible addition of the new Course")
    public void emptyFieldStartDate() {
        String createdEmail = email;
        String usersPassword = password;
        homePage.goToTheRegistrationPage();
        registrationPage.registrationOfTeacher(fullName, createdEmail, usersPassword);
        header.goToThePageAddCourse();
        addCoursePage.formAddCourseIsDisplayed();
        addCoursePage.enterCourseName("New Course-3");
        addCoursePage.enterFacultyName(4);
        addCoursePage.enterCourseDescription("New methods in Sciences.");
        addCoursePage.uploadFile(photoOfCourse);
        addCoursePage.checkUploadedFile(".*Photo.*");
        addCoursePage.enterEndDate();
        addCoursePage.pushButtonAdd();
        addCoursePage.checkErrorMessage("Course start date is required");
    }
    @Test
    @DisplayName("By empty field EndDate impossible addition of the new Course")
    public void emptyFieldEndDate() {
        String createdEmail = email;
        String usersPassword = password;
        homePage.goToTheRegistrationPage();
        registrationPage.registrationOfTeacher(fullName, createdEmail, usersPassword);
        header.goToThePageAddCourse();
        addCoursePage.formAddCourseIsDisplayed();
        addCoursePage.enterCourseName("New Course-3");
        addCoursePage.enterFacultyName(5);
        addCoursePage.enterCourseDescription("New methods in Sciences.");
        addCoursePage.uploadFile(photoOfCourse);
        addCoursePage.checkUploadedFile(".*Photo.*");
        addCoursePage.enterStartDate();
        addCoursePage.pushButtonAdd();
        addCoursePage.checkErrorMessage("Course end date is required");
    }
    @Test
    @DisplayName("EndDate of the new Course must be later, than StartDate of the Course")
    public void erlierThanStartDateDataInFieldEndDate() {
        String createdEmail = email;
        String usersPassword = password;
        homePage.goToTheRegistrationPage();
        registrationPage.registrationOfTeacher(fullName, createdEmail, usersPassword);
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
