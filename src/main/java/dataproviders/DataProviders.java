package dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "")
    public static Object [][] getData(){
        Object [][] array;
        array = ExcelReader.getDataFromSheet("");
        return array;
    }
}
