package ru.soctech_it.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.soctech_it.helpers.Attach;
import ru.soctech_it.pages.MainPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    MainPage mainPage = new MainPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://soctech-it.ru/";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}