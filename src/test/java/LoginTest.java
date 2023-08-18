import org.junit.Test;
import utils.PropertiesLoader;

public class LoginTest extends BaseTest {

    private String userStudent = PropertiesLoader.loadProperties("userStudent");

    private String studentPassword = PropertiesLoader.loadProperties("studentPassword");

    private String userTeacher = PropertiesLoader.loadProperties("userTeacher");

    private String teacherPassword = PropertiesLoader.loadProperties("teacherPassword");

    @Test
    public void successLoginOfStudent() {
        homePage.goToTheLoginPage();
        loginPage.enterEmail(userStudent);
        loginPage.enterPassword(studentPassword);
        loginPage.pushSignInButton();
        mainStudentPage.checkButtonStudentDirectory();
    }

    @Test
    public void successLoginOfTeacher() {
        homePage.goToTheLoginPage();
        loginPage.enterEmail(userTeacher);
        loginPage.enterPassword(teacherPassword);
        loginPage.pushSignInButton();
        mainTeacherPage.buttonAddCourseIsVisible();
    }

    @Test
    public void invalidPassword() {
        homePage.goToTheLoginPage();
        loginPage.enterEmail(userStudent);
        loginPage.enterPassword("123457");
        loginPage.pushSignInButton();
        loginPage.checkErrorMessage("Invalid email or password");
    }

    @Test
    public void invalidEmail() {
        homePage.goToTheLoginPage();
        loginPage.enterEmail("marg@gmail.com");
        loginPage.enterPassword(studentPassword);
        loginPage.pushSignInButton();
        loginPage.checkErrorMessage("Invalid email or password");
    }
    @Test
    public void emptyInputFields() {
        homePage.goToTheLoginPage();
        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.pushSignInButton();
        loginPage.checkErrorMessage("Invalid email or password");
    }
    @Test
    public void emptyInputFieldEmail() {
        homePage.goToTheLoginPage();
        loginPage.enterEmail("");
        loginPage.enterPassword(studentPassword);
        loginPage.pushSignInButton();
        loginPage.checkErrorMessage("Invalid email or password");
    }

    @Test
    public void emptyInputFieldPassword() {
        homePage.goToTheLoginPage();
        loginPage.enterEmail(userStudent);
        loginPage.enterPassword("");
        loginPage.pushSignInButton();
        loginPage.checkErrorMessage("Invalid email or password");
    }

    @Test
    public void checkButtonSignUp() {
        homePage.goToTheLoginPage();
        loginPage.pushSignUpButton();
        registrationPage.checkFormOfRegistration();
    }
    @Test
    public void forgotPassword() {
        homePage.goToTheLoginPage();
        loginPage.followTheForgotPasswordLink();
        forgotPassword.urlIsCorrect();
        forgotPassword.checkInputFieldEmail();
    }


}
