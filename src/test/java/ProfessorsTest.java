import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import utils.PropertiesLoader;

@DisplayName("Professor spotlight page Tests")
public class ProfessorsTest extends BaseTest {

    private String userTeacher = PropertiesLoader.loadProperties("userTeacher");

    private String teacherPassword = PropertiesLoader.loadProperties("teacherPassword");


    @Test
    @DisplayName("In the list of teachers must be only teachers")
    public void checkingRoleInTeachersList() {
        homePage.goToTheLoginPage();
        loginPage.successfulLogin(userTeacher, teacherPassword);
        professorsPage.checkListOfTeachersIsDisplayed();
        professorsPage.checkListOfTeachers("teacher");
    }

    @Test
    @DisplayName("Profile of teacher must contains one time image of teacher")
    public void checkingImageOfProfile() {
        homePage.goToTheLoginPage();
        loginPage.successfulLogin(userTeacher, teacherPassword);
        professorsPage.checkListOfTeachersIsDisplayed();
        professorsPage.fillTheSearchField("roxan");
        professorsPage.checkNameOfSelectedProfessor("Roxane");
        professorsPage.goToTheProfileOfProfessor();
        profileOfTeacherPage.checkImageOfProfile();
    }

}
