import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import utils.PropertiesLoader;

@DisplayName("Profile of user edit Tests")
public class UserProfileTest extends BaseTest {

    private String userTeacher = PropertiesLoader.loadProperties("userTeacher");

    private String teacherPassword = PropertiesLoader.loadProperties("teacherPassword");

    private String changedFullName = "Mariva Baggi2";
    private String textAbout = randomString();

    private String photoPath = "src/test/data/Photo_Avatar.jpg";

    private String newPassword = "123456";


    @Test
    @DisplayName("Successful edit of User Profile details")
    public void editProfileDetails() {
        homePage.goToTheLoginPage();
        loginPage.successfulLogin(userTeacher, teacherPassword);
        header.pushButtonAvatar();
        header.pushButtonMyProfile();
        userProfilePage.checkFieldRole("teacher");
        userProfilePage.changeFullName(changedFullName);
        userProfilePage.checkEmailInProfile(userTeacher);
        userProfilePage.fillTextareaAbout(textAbout);
        userProfilePage.uploadAvatarFile(photoPath);
        userProfilePage.pushTheButtonUpdateProfile();
        header.pushTheButtonProfessors();
        professorsPage.fillTheSearchField(changedFullName);
        professorsPage.checkListOfTeachersIsDisplayed();
        professorsPage.checkNameOfSelectedProfessor(changedFullName);
    }

    @Test
    @DisplayName("Uploaded image of users profile is successful")
    public void uploadProfileImage() {
        homePage.goToTheLoginPage();
        loginPage.successfulLogin(userTeacher, teacherPassword);
        header.pushButtonAvatar();
        header.pushButtonMyProfile();
        userProfilePage.checkFieldRole("teacher");
        userProfilePage.checkEmailInProfile(userTeacher);
        userProfilePage.uploadAvatarFile(photoPath);
        userProfilePage.pushTheButtonUpdateProfile();
        header.pushTheButtonProfessors();
        professorsPage.fillTheSearchField(userTeacher);
        professorsPage.checkProfileImage();
    }

    @Test
    @DisplayName("Change of password of users profile is successful")
    public void changePasswordInProfile() {
        homePage.goToTheLoginPage();
        loginPage.successfulLogin(userTeacher, teacherPassword);
        header.pushButtonAvatar();
        header.pushButtonMyProfile();
        userProfilePage.checkFieldRole("teacher");
        userProfilePage.fillInputFieldOldPassword(teacherPassword);
        userProfilePage.fillInputFieldNewPassword(newPassword);
        userProfilePage.pushTheButtonChangePassword();
        header.pushButtonAvatar();
        header.pushButtonSignOut();
        loginPage.successfulLogin(userTeacher, newPassword);
        mainTeacherPage.buttonAddCourseIsVisible();
    }
    @Test
    @DisplayName("Change of password of users profile with empty new password is unsuccessful")
    public void unsuccessfulChangePasswordWithEmptyNewPassword() {
        homePage.goToTheLoginPage();
        loginPage.successfulLogin(userTeacher, teacherPassword);
        header.pushButtonAvatar();
        header.pushButtonMyProfile();
        userProfilePage.checkFieldRole("teacher");
        userProfilePage.fillInputFieldOldPassword(teacherPassword);
        userProfilePage.fillInputFieldNewPassword("");
        userProfilePage.pushTheButtonChangePassword();
        userProfilePage.checkErrorMessage("Password must contain at least 6 characters");
    }

    @Test
    @DisplayName("Change of password of users profile with empty old password is unsuccessful")
    public void unsuccessfulChangePasswordWithEmptyOldPassword() {
        homePage.goToTheLoginPage();
        loginPage.successfulLogin(userTeacher, teacherPassword);
        header.pushButtonAvatar();
        header.pushButtonMyProfile();
        userProfilePage.checkFieldRole("teacher");
        userProfilePage.fillInputFieldOldPassword("");
        userProfilePage.fillInputFieldNewPassword(newPassword);
        userProfilePage.pushTheButtonChangePassword();
        userProfilePage.checkErrorMessageWithInvalidOldPassword("Something went wrong, please try again.");
    }
    @Test
    @DisplayName("Change of password of users profile with invalid old password is unsuccessful")
    public void unsuccessfulChangePasswordWithInvalidOldPassword() {
        homePage.goToTheLoginPage();
        loginPage.successfulLogin(userTeacher, teacherPassword);
        header.pushButtonAvatar();
        header.pushButtonMyProfile();
   //     userProfilePage.checkFieldRole("teacher");
        userProfilePage.fillInputFieldOldPassword("1234567");
        userProfilePage.fillInputFieldNewPassword(newPassword);
        userProfilePage.pushTheButtonChangePassword();
        userProfilePage.checkErrorMessageWithInvalidOldPassword("Something went wrong, please try again.");
        userProfilePage.checkErrorMessageAdditional("The current password you have entered is incorrect. If you don't know your current password, please go to 'forgot-password' section and reset.");
    }

}
