package iscteiul.ista.blackbattleship.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import iscteiul.ista.blackbattleship.pages.UserStory11;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;

@Epic("Black Battleship")
@Feature("Profile and social navigation")
class UserStory11Test extends SelenideTestBase {

    private final UserStory11 page = new UserStory11();

    @Test
    @Story("Consult profile options from the account menu")
    @DisplayName("UserStoryTest11 - Open account menu and view profile option")
    void openAccountMenuAndViewProfileOption() {
        page.openBattleshipPage()
                .openAccountMenu()
                .navigateToProfile()
                .hoverShopLink();

        page.profileMenuItem().shouldBe(visible);
    }
}
