package elements;

public class Locator{

    //ИЩЕТ ЭЛЕМЕНТ ВВОДА В БЛОКЕ
    public static String findInputInBlock(String input){
        return ".//*[contains(text(),'" + input + "')]/parent::label/following-sibling::div/descendant::input";
    }

    public static String findDisplayField(String input){
        return ".//span[contains(text(),'" + input + "')]/parent::label/following-sibling::div/descendant::div";
    }
    //Ищет input в фильтре грида.
    public static String findInputInFilter(String input){
        //return ".//span[contains(text(),'" + input + "')]/ancestor::div[starts-with(@id,'gridcolumn-') and ends-with(@id,'-titleEl')]/following-sibling::div/descendant::input";
        return ".//span[contains(text(),'" + input + "')]/ancestor::div[starts-with(@id,'gridcolumn-') and string-length(@id)=23]/following-sibling::div/descendant::input";
    }
    //ИЩЕТ ЭЛЕМЕНТ ВВОДА В БЛОКЕ СЛЕДУЮЩИЙ ЗА ВВЕДЕННЫМ
    public static String findNextInputInBlock(String input){
        return ".//*[contains(text(),'" + input + "')]/parent::label/parent::div/following-sibling::div/descendant::input";
    }
    //ИЩЕТ ЭЛЕМЕНТ ВВОДА В БЛОКЕ ПЕРЕД ВВЕДЕННЫМ
    public static String findPreviousInputInBlock(String input){
        return ".//*[contains(text(),'" + input + "')]/parent::label/parent::div/preceding-sibling::div/descendant::input";
    }
    //ИЩЕТ ЭЛЕМЕНТ ВВОД ТИПА TEXTAREA
    public static String findTextAreaInBlock(String input) {
        return ".//*[contains(text(),'" + input + "')]/parent::label/following-sibling::div/descendant::textarea";
    }
    //ИЩЕТ ГРИД
    public static String findGridElements() {
        return ".//div[string-length(@id)=9 and starts-with(@id,'grid-')]/descendant::table";
    }
    public static String findSearchGridElements= "descendant-or-self::div[string-length(@id)=15 and starts-with(@id,'searchgrid-')]/descendant::table";
    //ИЩЕТ КНОПКУ
    public static String findButton(String input){
        return ".//span[text()='" + input + "']";
    }
    //ИЩЕТ КНОПКУ ВЫХОДА
    public static String findLogoutButton(){
        return ".//a[@id='logout']";
    }

    public static String findSwitchModuleButton(){
        return ".//*[@id='app-header-logo']";
    }
    //ИЩЕТ БЛОК
    public static String findBlock(String input) {
        return ".//*[contains(text(),'" + input + "')]/ancestor::div[string-length(@id)=10 and starts-with(@id,'panel-')]/";
    }
    public static String findExtCompFromTitle(String input){
        return ".//*[contains(text(),'" + input + "') and string-length(@id)=17 and starts-with(@id,'title-')]/ancestor::div[string-length(@id)=13 and starts-with(@id,'ext-comp-')][1]/";
    }
    public static String findExtCompFromH1(String input){
        return ".//*[contains(text(),'" + input + "')]/ancestor::div[string-length(@id)=13 and starts-with(@id,'ext-comp-')]/";
    }
    public static String findGradientBlock(String input){
        return ".//*[contains(text(),'" + input + "')]/ancestor::div[string-length(@id)=18 and starts-with(@id,'gradientPanel-')]/";
    }
    public static String findSearchGrid(String input){
        return ".//span[contains(text(),'" + input + "')]/ancestor::div[string-length(@id)=15 and starts-with(@id,'searchgrid-')]/";
    }
    public static String findTitle(String input){
        return ".//*[contains(text(),'" + input + "') and string-length(@id)=17 and starts-with(@id,'title-')]";
    }
    public static String findRadioButton(String input){
        //return ".//*[contains(text(),'" + input + "')]/preceding-sibling::*";
        return ".//*[contains(text(),'" + input + "')]";
        //return ".//*[contains(text(),'" + input + "')]/preceding-sibling::*/preceding-sibling::*";
    }
    public static String findCheckBox(String input){
        return ".//label[contains(text(),'" + input + "')]/preceding-sibling::span";
    }
    //ИЩЕТ ОКНО (НАПРИМЕР АВТОТРАНСПОРТ)
    public static String findWindow(String input) {
        return".//*[contains(text(),'" + input + "')]/ancestor::div[string-length(@id)=11 and starts-with(@id,'window-')]/";
    }
    public static String findForm(String input) {
        return".//div[contains(text(),'" + input + "')]/ancestor::div[string-length(@id)=9 and starts-with(@id,'form-')]/";
    }
    //ИЩЕТ БЛОК ТИПА FIELDSET В ОКНЕ
    public static String findFieldsetInWindow(String input){
        return ".//*[contains(text(),'"+input+"')]/ancestor::fieldset/";
    }
    //ИЩЕТ ЭЛЕМЕНТ СПИСКА (ДЛЯ АДРЕСА)
    public static String findBoundList(String input) {
        return ".//*[string-length(@id)=14 and starts-with(@id,'boundlist-') and not(contains(@style,'display: none'))]/descendant::*[contains(text(),'" + input + "') and not(contains(@class,'x-boundlist-selected'))]";
        //return ".//*[string-length(@id)=14 and starts-with(@id,'boundlist-') and not(contains(@style,'display: none'))]/descendant::*[contains(text(),'" + input + "') and not(contains(@class,'x-boundlist-selected'))]";
       // return ".//*[string-length(@id)=14 and starts-with(@id,'boundlist-') and not(contains(@style,'display: none'))]/descendant::*[contains(text(),'" + input + "')]";
    }

    public static String findTimepicker(String input) {
        return ".//*[string-length(@id)=15 and starts-with(@id,'timepicker-')]/descendant::*[contains(text(),'" + input + "') and not(contains(@class,'x-boundlist-selected'))]";
        //String xpath = ".//*[contains(@id,'boundlist') and not(contains(@display,'none'))]/*[contains(text(),'" + input + "')]";
        //String xpath = ".//*[contains(@id,'boundlist')]/*[contains(text(),'" + input + "')]";
    }

    public static String findBoundListInstance(String input) {
        return ".//*[contains(@id,'boundlist')]/*[contains(text(),'" + input + "')]/ancestor::*[string-length(@id)=14 and starts-with(@id,'boundlist-') and not(contains(@style,'display: none'))]";
    }
    public static String findBoundListForClick(String input) {
        return ".//*[contains(text(),'" + input + "') and not(contains(@class,'x-boundlist-selected'))]";
    }

    //ИЩЕТ ЭЛЕМЕНТ MESSAGEBOX
    public static String findMessageBox(String input) {
        return ".//*[contains(text(),'" + input + "')]/ancestor::div[string-length(@id)=15 and starts-with(@id,'messagebox-')]/";
    }
    //ИЩЕТ ЭЛЕМЕНТ BASEWINDOW
    public static String findBaseWindow(String input){
        return".//*[contains(text(),'" + input + "')]/ancestor::div[string-length(@id)=15 and starts-with(@id,'basewindow-')]/";
    }
    //
    public static String findButtonInWindow(String input){
        return ".//*[contains(text(),'" + input + "')]/parent::*/descendant::a";
    }
    public static String findToolButtonInWindow = ".//*[string-length(@id)=9 and starts-with(@id,'tool-')]/img";

    public static String findInputInSearchForm(String input) {
        return ".//span[contains(text(),'" + input + "')]/ancestor::div[string-length(@id)=15 and starts-with(@id,'gridcolumn-')]/descendant::input";
    }

    public static String findTrigger = "/parent::div/following-sibling::div";

    public static String findUnknownContainer = ".//div[string-length(@id)=14 and starts-with(@id,'container-')]/";

    public static String findContainer(String input){
        return ".//*[contains(text(),'"+input+"')]/ancestor::div[string-length(@id)=14 and starts-with(@id,'container-')]/";
    }

    public static String findLabel(String input){
        return".//label[text()='"+input+"']";
    }

    public static String findButtonWithDataQtip(String input) {
        return".//a[@data-qtip='"+input+"']";
    }
}
