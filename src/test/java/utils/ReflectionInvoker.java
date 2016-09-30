package utils;


import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


public class ReflectionInvoker {

    //public synchronized static void invokeMethods(WebDriver driver,Class className,ArrayList<String> methodsData, ArrayList<String> data) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    public static void invokeMethods(WebDriver driver,Class className,ArrayList<String> methodsData, ArrayList<String> data) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method;
        //System.out.println(methodsData+" - "+data);
        //System.out.println(driver.toString());
        //System.out.println(data);
        //System.out.println(className.getName());
        //System.out.println(Thread.currentThread().getName());

        Object obj = className.getConstructor(WebDriver.class).newInstance(driver);
        //System.out.println(obj.toString()+" @ "+Thread.currentThread().getName());
        while (!methodsData.isEmpty()){
            //Object obj = className.getConstructor(WebDriver.class).newInstance(driver);
            //Constructor ctr=className.getConstructor(WebDriver.class);
            //System.out.println(ctr.toString()+" ctr");
            //System.out.println(ctr.getTypeParameters().toString()+" params1");
            // System.out.println(ctr.getParameterTypes().toString()+" types");
            // System.out.println(className.getTypeParameters().toString()+" params2");
            //System.out.println(obj.getClass().toString()+" obj.getClass().toString()");
            //LoginPage loginPage = new LoginPage(driver);
            //System.out.println(loginPage.getClass().toString()+" basic");
            String tempMethod= ExcelRead.extract(methodsData);
            //if (tempMethod.contains("Button")) {
            //    method = obj.getClass().getMethod(tempMethod);
            //} else {
            //     method = obj.getClass().getMethod(tempMethod, String.class);
            //}
            String tempData= ExcelRead.extract(data);
            //System.out.println(tempData);
            //System.out.println(method.getName());
            if (tempData!=null) {
               // if (tempMethod.contains("Click")||(tempMethod.contains("Set"))) {
               //     method = obj.getClass().getMethod(tempMethod);
                    //System.out.println(method.getName());
               //     method.invoke(obj);
               // }
                if (tempMethod.contains("Click")||(tempMethod.contains("Set"))||(tempMethod.contains("click"))||(tempMethod.contains("get"))||(tempMethod.contains("assert"))) {
                    method = obj.getClass().getMethod(tempMethod);
                    //System.out.println(method.getName());
                    method.invoke(obj);
                } else{
                    method = obj.getClass().getMethod(tempMethod, String.class);
                    //System.out.println(method.getName());
                    //System.out.println(tempMethod);
                    method.invoke(obj, tempData);
                }
            }
        }
    }
}
