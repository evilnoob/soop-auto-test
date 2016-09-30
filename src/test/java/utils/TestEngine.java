package utils;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


public class TestEngine{

    //@Step("Выполнение теста \"{4}\" из листа \"{3}\" файла \"{2}\" на классе \"{1}\" в драйвере \"{0}\" .")
    public static void executeTestFromData(WebDriver driver,Class className,String fileName,String sheetName,String testName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ArrayList<String> testData= ExcelRead.excelRead(fileName, sheetName).get(ExcelRead.rowFinder(fileName, sheetName, testName));
        ArrayList<String> methodsData= ExcelRead.excelRead(fileName, sheetName).get(ExcelRead.rowFinder(fileName, sheetName, "Methods"));
        ReflectionInvoker.invokeMethods(driver, className, methodsData, testData);
    }

    public static String countDocuments (String documentType, String subType) throws Exception {
        String number="";
        switch (documentType){
            case "Протокол":switch (subType){
                case "Протокол об административном правонарушении": number=DataBase.select("count(protocol_id)","count","int","isod.tbcase_protocol","type_id=-100").get(0);
                    break;
                case "Протокол об изъятии вещей и документов": number=DataBase.select("count(protocol_id)","count","int","isod.tbcase_protocol","type_id=-101").get(0);
                    break;
                }
                break;
            case "Постановление":switch (subType){
                case "Постановление о назначении административного наказания": number=DataBase.select("count(resolution_id)","count","int","isod.tbcase_resolution","resolution_type_id=-3600").get(0);
                    break;
                case "Постановление о прекращении производства по делу об адм. правонарушении": number=DataBase.select("count(resolution_id)","count","int","isod.tbcase_resolution","resolution_type_id=-3601").get(0);
                    break;
                }
                break;
            case "Определение":switch (subType){
                case "Определение о проведении административного расследования": number=DataBase.select("count(act_id)","count","int","isod.tbcase_act","act_type_id=-3502").get(0);
                    break;
                case "Определение о передаче дела об административном правонарушении": number=DataBase.select("count(act_id)","count","int","isod.tbcase_act","act_type_id=-3500").get(0);
                    break;
                case "Определение о возврате дела об административном правонарушении на доработку": number=DataBase.select("count(act_id)","count","int","isod.tbcase_act","act_type_id=-3501").get(0);
                    break;
                }
                break;
        }
        return number;
    }
}