package ru.soctech_it.pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPage {

    public void clickOnProjectsButton() {
        $$("#navbarSupportedContent ul li a").findBy(href("#project")).click();
    }

    public void checkClassShowIsHidden() {
        $(".show").shouldBe(hidden);
    }

    public void clickOnShowMoreButton() {
        $("#btn").click();
    }

    public void checkClassShowIsVisible() {
        $(".show").shouldBe(visible);
    }

    public void clickOnCareerButton() {
        $$("#navbarSupportedContent ul li a").findBy(href("#career-anchor")).click();
    }

    public void checkHeaderInCareer() {
        $(".facilities").shouldHave(text("Возможности для наших работников"));
    }

    public void clickOnOurVacanciesButton() {
        $$("#vacancy-btn").findBy(text("Наши вакансии на hh.ru")).click();
    }

    public void checkWebDriverWithHhUrl() {
        webdriver().shouldHave(url("https://hh.ru/employer/5520255?hhtmFrom=vacancy"));
    }

    public void clickOnContactsButton() {
        $$("#navbarSupportedContent ul li a").findBy(href("#contacts2-anchor")).click();
    }

    public void switchToYandexMapsIframe() {
        switchTo().frame($("#map-container iframe"));
    }

    public void checkTextInYandexMapsFrame() {
        $("body").shouldHave(text("Пробки"));
    }

    public void clickOnOpenYandexMapsButton() {
        $("body").$(byText("Открыть в Яндекс Картах")).click();
    }

    public void switchToNewPage() {
        switchTo().window(1);
    }

    public void checkWebDriverWithYandexMapsUrl() {
        webdriver().shouldHave(url("https://yandex.ru/maps/213/moscow/?" +
                "from=mapframe&ll=37.608149%2C55.767183&" +
                "mode=usermaps&source=mapframe&" +
                "um=constructor%3A6d7559b4826ecac0f347b1f4f56b865aef101b75df7c84ae25eed2c7a24ca0b5&" +
                "utm_source=mapframe&z=17"));
    }
}
