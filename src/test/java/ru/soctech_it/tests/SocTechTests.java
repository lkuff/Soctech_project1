package ru.soctech_it.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SocTechTests extends TestBase{

    @BeforeEach
    void setUp() {
        open("https://soctech-it.ru/");
    }

    @DisplayName("Check that the header has elements")
    @ValueSource(strings = {
            "Главная", "Аккредитация в области ИТ", "Наши проекты", "Карьера", "Контакты"})
    @ParameterizedTest(name = "Check for the presence of the element {0} on the main page in the header")
    void checkElementTest(String element) {
        step("Check that the header has elements", () -> {
            $("#navbarSupportedContent").shouldHave(text(element));
        });
    }

    @DisplayName("Check 'Show more' button in 'Our projects' page")
    @Test
    public void checkShowMoreButtonInOurProjectsPage() {
        step("Click on 'Our projects' button", () -> {
            mainPage.clickOnProjectsButton();
        });
        step("Click on 'Show more' button", () -> {
            mainPage.checkClassShowIsHidden();
            mainPage.clickOnShowMoreButton();
            mainPage.checkClassShowIsVisible();
        });
    }

    @DisplayName("Check vacancies on hh.ru")
    @Test
    public void checkVacanciesOnHhRu() {
        step("Click on 'Career' button and check page has header 'opportunities for our employees'", () -> {
            mainPage.clickOnCareerButton();
            mainPage.checkHeaderInCareer();
        });
        step("Click on 'Our vacancies' button and check URL", () -> {
            mainPage.clickOnOurVacanciesButton();
            mainPage.checkWebDriverWithHhUrl();
        });
    }

    @DisplayName("Check address in Yandex maps")
    @Test
    public void checkAddressInYandexMaps() {
        step("Click on 'Contacts' button", () -> {
            mainPage.clickOnContactsButton();
        });
        step("Switch to iframe and check it has text 'Traffic'", () -> {
            mainPage.switchToYandexMapsIframe();
            mainPage.checkTextInYandexMapsFrame();
        });
        step("Click on 'Open in Yandex maps' button", () -> {
            mainPage.clickOnOpenYandexMapsButton();
        });
        step("Switch to new window and check URL", () -> {
            mainPage.switchToNewPage();
            mainPage.checkWebDriverWithYandexMapsUrl();
        });
    }
}
