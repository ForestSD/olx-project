package olxproject;

import olxproject.enumcategoris.CategoriesId;
import olxproject.interfacepage.Config;
import olxproject.interfacepage.OlxManager;
import olxproject.pages.MainPage;
import olxproject.pages.SearchPage;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) throws Exception {
        initDriver();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.olx.ua/");

        getConfig();

        OlxManager manager = new OlxManager(driver);
        MainPage mainPage = new MainPage(driver, manager);
        SearchPage searchPage = new SearchPage(driver);


        //mainPage.headerSearch("Iphone 6S");
        /*searchPage.priceTo("984");
        searchPage.sortListAdvert("Частное");
        searchPage.sortListByTheCriteria("Самые дешевые");
        searchPage.sortListCurrency("€");
        searchPage.waitAlertWindow();
        searchPage.checkBoxSearchInDescriptionTitle(true);
        searchPage.checkBoxSearchOnlyByPhoto(true);
        searchPage.checkBoxSearchByDelivery(true);
        searchPage.priceFromAndTo("893");
        searchPage.checkHeading("Недвижимость");
        searchPage.clickOnHeaderLogoMainPage();
        mainPage.choosingTheRightCity("Харьковская","Харьков");
        mainPage.listCategories("Детский Мир", "Игрушки");
        searchPage.checkBoxSearchByDelivery(true);
        searchPage.clickOnHeaderLogoMainPage();
        */


        OlxManager manager = new OlxManager(driver, driver1);
        manager.login(user, pass);
        List<Product> products = manager.listProductsByCategory("детский мир");
        ProductDetails details = manager.getDetails(products.get(0));

        manager.findProducts("", 23, SortType.LOW_PRICE, )

    }

    private static void initDriver() {
        File driverFile = new File("geckodriver.exe");
        driverFile.deleteOnExit();
        System.out.println("copy driver to " + driverFile.getAbsolutePath());
        try {
            byte[] bytes = IOUtils.toByteArray(Main.class.getClassLoader()
                    .getResourceAsStream("geckodriver.exe"));
            IOUtils.write(bytes, new FileOutputStream(driverFile));
        } catch (Exception ignored) {}

        System.setProperty("webdriver.gecko.driver", driverFile.getAbsolutePath());
    }

    public static void getConfig(){
        InputStream resourceAsStream = Main.class.getClassLoader().getResourceAsStream("config.yml");
        try {
            String stringConfig = IOUtils.toString(resourceAsStream);
            Config config = new Config(stringConfig);

            List<CategoriesId> values = CategoriesId.values();

            for (String key : config.getMap().keySet()) {
                String buttonName = config.getOrSet(key + ".button-name", "button");
                List<String> names = config.getOrSet(key + ".names", Collections.emptyList());
                CategoriesId categoriesId = new CategoriesId(key, buttonName, names);
                values.add(categoriesId);
                System.out.println("Загрузили категорию " + categoriesId);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
