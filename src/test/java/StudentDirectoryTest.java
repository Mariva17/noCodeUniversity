import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import utils.PropertiesLoader;

@DisplayName("Student Directory page Tests")
public class StudentDirectoryTest extends BaseTest {

    private String userStudent = PropertiesLoader.loadProperties("userStudent");

    private String studentPassword = PropertiesLoader.loadProperties("studentPassword");


    @Test
    @DisplayName("In the list of students must be only students")
    public void checkStudentsListIsCorrect() {
        homePage.goToTheLoginPage();
        loginPage.successfulLogin(userStudent, studentPassword);
        header.pushTheButtonStudentDirectory();
        studentDirectoryPage.fillSearchField("ada");
        studentDirectoryPage.checkStudentsList();
    }

    @Test
    @DisplayName("Profile of student must contains one time image of student")
    public void checkStudentsProfileInformation() {
        homePage.goToTheLoginPage();
        loginPage.successfulLogin(userStudent, studentPassword);
        header.pushTheButtonStudentDirectory();
        studentDirectoryPage.fillSearchField("malov");
        studentDirectoryPage.pushTheButtonViewProfile();
        profileOfStudentPage.checkImageOfProfile(1);
    }
    @Test
    @DisplayName("Button BackToTheDirectory must leads to the Student Directory page")
    public void checkTheButtonBackToTheDirectory() {
        homePage.goToTheLoginPage();
        loginPage.successfulLogin(userStudent, studentPassword);
        header.pushTheButtonStudentDirectory();
        studentDirectoryPage.fillSearchField("malov");
        studentDirectoryPage.pushTheButtonViewProfile();
        profileOfStudentPage.pushTheButtonBackToDirectory();
        studentDirectoryPage.checkWelcomeTextOnThePage();
    }

}
