import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import utils.PropertiesLoader;

@DisplayName("Authorization Tests")
public class LoginTest extends BaseTest {

    private String userStudent = PropertiesLoader.loadProperties("userStudent");

    private String studentPassword = PropertiesLoader.loadProperties("studentPassword");

    private String userTeacher = PropertiesLoader.loadProperties("userTeacher");

    private String teacherPassword = PropertiesLoader.loadProperties("teacherPassword");

    @Test
    @DisplayName("Authorization of Student with valid data")
    public void successLoginOfStudent() {
        homePage.goToTheLoginPage();
        loginPage.enterEmail(userStudent);
        loginPage.enterPassword(studentPassword);
        loginPage.pushSignInButton();
        mainStudentPage.checkButtonStudentDirectory();
    }

    @Test
    @DisplayName("Authorization of Teacher with valid data")
    public void successLoginOfTeacher() {
        homePage.goToTheLoginPage();
        loginPage.enterEmail(userTeacher);
        loginPage.enterPassword(teacherPassword);
        loginPage.pushSignInButton();
        mainTeacherPage.buttonAddCourseIsVisible();
    }

    @Test
    @DisplayName("Unsuccessful authorization of user with invalid password")
    public void invalidPassword() {
        homePage.goToTheLoginPage();
        loginPage.enterEmail(userStudent);
        loginPage.enterPassword("123457");
        loginPage.pushSignInButton();
        loginPage.checkErrorMessage("Invalid email or password");
    }

    @Test
    @DisplayName("Unsuccessful authorization of user with invalid email")
    public void invalidEmail() {
        homePage.goToTheLoginPage();
        loginPage.enterEmail("marg@gmail.com");
        loginPage.enterPassword(studentPassword);
        loginPage.pushSignInButton();
        loginPage.checkErrorMessage("Invalid email or password");
    }
    @Test
    @DisplayName("Unsuccessful authorization of user with empty fields")
    public void emptyInputFields() {
        homePage.goToTheLoginPage();
        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.pushSignInButton();
        loginPage.checkErrorMessage("Invalid email or password");
    }
    @Test
    @DisplayName("Unsuccessful authorization of user with empty field Email")
    public void emptyInputFieldEmail() {
        homePage.goToTheLoginPage();
        loginPage.enterEmail("");
        loginPage.enterPassword(studentPassword);
        loginPage.pushSignInButton();
        loginPage.checkErrorMessage("Invalid email or password");
    }

    @Test
    @DisplayName("Unsuccessful authorization of user with empty field Password")
    public void emptyInputFieldPassword() {
        homePage.goToTheLoginPage();
        loginPage.enterEmail(userStudent);
        loginPage.enterPassword("");
        loginPage.pushSignInButton();
        loginPage.checkErrorMessage("Invalid email or password");
    }

    @Test
    @DisplayName("Button Sign Up leads to the Registration page")
    public void checkButtonSignUp() {
        homePage.goToTheLoginPage();
        loginPage.pushSignUpButton();
        registrationPage.checkFormOfRegistration();
    }
    @Test
    @DisplayName("Button Forgot password leads to the Forgot password page where input field Email is displayed")
    public void forgotPassword() {
        homePage.goToTheLoginPage();
        loginPage.followTheForgotPasswordLink();
        forgotPassword.urlIsCorrect();
        forgotPassword.checkInputFieldEmail();
    }


}
