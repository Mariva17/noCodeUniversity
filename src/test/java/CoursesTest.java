import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import utils.PropertiesLoader;

@DisplayName("Page Courses Tests")
public class CoursesTest extends BaseTest {

    private String userTeacher = PropertiesLoader.loadProperties("userTeacher");

    private String teacherPassword = PropertiesLoader.loadProperties("teacherPassword");

    @Test
    @DisplayName("Faculties of Courses on the page Courses must matching with faculties on the page Add Course")
    public void checkingForMatchingNumberOfCourses() {
        homePage.goToTheLoginPage();
        loginPage.successfulLogin(userTeacher, teacherPassword);
        header.pushTheButtonCourses();
        header.pushTheButtonCourseList();
        Integer numberOfCourses = coursesPage.checkFacultiesOfCourses();
        header.goToThePageAddCourse();
        addCoursePage.checkQuantityOfFaculties(numberOfCourses);
    }

    @Test
    @DisplayName("Button Discover more must open more courses")
    public void checkButtonDiscoverMore() {
        homePage.goToTheLoginPage();
        loginPage.successfulLogin(userTeacher, teacherPassword);
        header.pushTheButtonCourses();
        header.pushTheButtonCourseList();
        coursesPage.checkNumberOfCourses(8);
        coursesPage.pushButtonDiscoverMore();
        coursesPage.checkNumberOfCourses(16);
    }

    @Test
    @DisplayName("Button Add Course must lead to the page Add Course")
    public void checkButtonAddCourse() {
        homePage.goToTheLoginPage();
        loginPage.successfulLogin(userTeacher, teacherPassword);
        header.pushTheButtonCourses();
        header.pushTheButtonCourseList();
        coursesPage.pushButtonAddCourse();
        addCoursePage.formAddCourseIsDisplayed();
    }

}
