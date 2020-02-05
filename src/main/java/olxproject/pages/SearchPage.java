package olxproject.pages;

import olxproject.interfacepage.BasePage;
import olxproject.interfacepage.OlxManager;
import org.openqa.selenium.WebDriver;


public class SearchPage extends BasePage {

    private WebDriver driver;
    private OlxManager manager;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private void searchProductAndCheckingCheckBox(String product){
        manager.headerSearch(product);
        manager.closeAlertWindowSearchPage();
    }

    private void checkBoxActivate(boolean delivery,boolean descriptionTitle, boolean photo){
        manager.checkBoxSearchByDeliverySearchPage(delivery);
        manager.checkBoxSearchInDescriptionTitleSearchPage(descriptionTitle);
        manager.checkBoxSearchOnlyByPhotoSearchPage(photo);
    }

    private void additionalSettings(String criteria, String nameAdvert, String nameCurrency, String nameView){
        manager.forDefiningSortingCriteriaSearchPage(criteria);
        manager.forDeterminingFromWhomTheAdWasSubmittedSearchPage(nameAdvert);
        manager.forDeterminingTheCurrencySearchPage(nameCurrency);
        manager.forDisplayingGoodsSearchPage(nameView);
    }

    private void buttonAndNumberPage(boolean nextButton, boolean previousButton, Integer numberButton){
        manager.nextPageButtonOnSearchPage(nextButton);
        manager.previousPageButtonOnSearchPage(previousButton);
        manager.nextPageNumberOnSearchPage(numberButton);
    }
}
