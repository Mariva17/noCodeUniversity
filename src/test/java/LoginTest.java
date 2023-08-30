import api.ApiBase;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import utils.PropertiesLoader;

@DisplayName("Authorization Tests")
public class LoginTest extends BaseTest {

//    private String userStudent = PropertiesLoader.loadProperties("userStudent");
//
//    private String studentPassword = PropertiesLoader.loadProperties("studentPassword");
//
//    private String userTeacher = PropertiesLoader.loadProperties("userTeacher");
//
//    private String teacherPassword = PropertiesLoader.loadProperties("teacherPassword");

    Faker faker = new Faker();

    public String fullName = randomString();
    public String email = faker.internet().emailAddress();
    public String password = faker.internet().password(6, 12);
    static String endpoint = "/users/";


    @Test
    @DisplayName("Authorization of Student with valid data")
    public void successLoginOfStudent() {
        String createdEmail = email;
        String usersPassword = password;
        homePage.goToTheRegistrationPage();
        registrationPage.registrationOfStudent(fullName, createdEmail, usersPassword);
        header.pushButtonAvatar();
        header.pushButtonSignOut();
        loginPage.enterEmail(createdEmail);
        loginPage.enterPassword(usersPassword);
        loginPage.pushSignInButton();
        header.pushButtonAvatar();
        header.pushButtonMyProfile();
        userProfilePage.checkFieldRole("student");
        ApiBase apiBase = new ApiBase();
        apiBase.deleteRequest(endpoint+createdEmail, 200);
    }

    @Test
    @DisplayName("Authorization of Teacher with valid data")
    public void successLoginOfTeacher() {
        String createdEmail = email;
        String usersPassword = password;
        homePage.goToTheRegistrationPage();
        registrationPage.registrationOfTeacher(fullName, createdEmail, usersPassword);
        header.pushButtonAvatar();
        header.pushButtonSignOut();
        loginPage.enterEmail(createdEmail);
        loginPage.enterPassword(usersPassword);
        loginPage.pushSignInButton();
        mainTeacherPage.buttonAddCourseIsVisible();
        ApiBase apiBase = new ApiBase();
        apiBase.deleteRequest(endpoint+createdEmail, 200);
    }

    @Test
    @DisplayName("Unsuccessful authorization of user with invalid password")
    public void invalidPassword() {
        String createdEmail = email;
        String usersPassword = password;
        homePage.goToTheRegistrationPage();
        registrationPage.registrationOfStudent(fullName, createdEmail, usersPassword);
        header.pushButtonAvatar();
        header.pushButtonSignOut();
        loginPage.enterEmail(createdEmail);
        loginPage.enterPassword("123457");
        loginPage.pushSignInButton();
        loginPage.checkErrorMessage("Invalid email or password");
        ApiBase apiBase = new ApiBase();
        apiBase.deleteRequest(endpoint+createdEmail, 200);
    }

    @Test
    @DisplayName("Unsuccessful authorization of user with invalid email")
    public void invalidEmail() {
        String createdEmail = email;
        String usersPassword = password;
        homePage.goToTheRegistrationPage();
        registrationPage.registrationOfStudent(fullName, createdEmail, usersPassword);
        header.pushButtonAvatar();
        header.pushButtonSignOut();
        loginPage.enterEmail("marg@gmail.com");
        loginPage.enterPassword(usersPassword);
        loginPage.pushSignInButton();
        loginPage.checkErrorMessage("Invalid email or password");
        ApiBase apiBase = new ApiBase();
        apiBase.deleteRequest(endpoint+createdEmail, 200);
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
        String createdEmail = email;
        String usersPassword = password;
        homePage.goToTheRegistrationPage();
        registrationPage.registrationOfStudent(fullName, createdEmail, usersPassword);
        header.pushButtonAvatar();
        header.pushButtonSignOut();
        loginPage.enterEmail("");
        loginPage.enterPassword(usersPassword);
        loginPage.pushSignInButton();
        loginPage.checkErrorMessage("Invalid email or password");
        ApiBase apiBase = new ApiBase();
        apiBase.deleteRequest(endpoint+createdEmail, 200);
    }

    @Test
    @DisplayName("Unsuccessful authorization of user with empty field Password")
    public void emptyInputFieldPassword() {
        String createdEmail = email;
        String usersPassword = password;
        homePage.goToTheRegistrationPage();
        registrationPage.registrationOfStudent(fullName, createdEmail, usersPassword);
        header.pushButtonAvatar();
        header.pushButtonSignOut();
        loginPage.enterEmail(createdEmail);
        loginPage.enterPassword("");
        loginPage.pushSignInButton();
        loginPage.checkErrorMessage("Invalid email or password");
        ApiBase apiBase = new ApiBase();
        apiBase.deleteRequest(endpoint+createdEmail, 200);
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
