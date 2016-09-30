package objects.eal.admcase.all;

import elements.ElementsGrid;
import objects.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.List;
import java.util.Random;

public class KoAP extends Page{

    public KoAP(WebDriver driver) {
        super(driver);
    }

    //public List<WebElement> articlesList = ElementsGrid.elementsSearchGridFromWindow(driver, "Кодекс об административных правонарушениях");

    @Step("Выбрать случайной статьи.")
    public void randomArticleClick(){
        List<WebElement> articlesList = ElementsGrid.elementsSearchGridFromWindow(driver, "Кодекс об административных правонарушениях");
        Random rand = new Random();
        //System.out.println(articlesList.size());
        int index = rand.nextInt(articlesList.size());
        //System.out.println(index);
        articlesList.get(index).click();
        articlesList.get(index).click();
        articlesList.get(index).click();
        //scrollIntoElement(articlesList.get(index));
        doubleClick(driver, articlesList.get(index));
        //articlesList.get(index).submit();
        //doubleClick(driver, articlesList.get(index));
    }

}