import org.testng.Assert;
import org.testng.annotations.*;

public class testNgTests {
    public static String INCORRECT_NUMBER_FORMAT = "Incorrect Number Format";

    @Test(dataProvider = "Zero",groups = "1")
    public void zero(String input, String expected){
        Assert.assertEquals(OpenWayTask.f_1_dev_x(input),expected);
    }

    @Test(dataProvider = "Integer",groups =  "1")
    public void integer(String input, String expected){
        Assert.assertEquals(OpenWayTask.f_1_dev_x(input),expected);
    }

    @Test(dataProvider = "Short", groups = "1")
    public void shortTest(String input,String expected){
        Assert.assertEquals(OpenWayTask.f_1_dev_x(input),expected);
    }

    @Test(dataProvider = "IncorrectFormat",groups = "2")
    public void incorrectFormat(String input){
        Assert.assertEquals(OpenWayTask.f_1_dev_x(input),INCORRECT_NUMBER_FORMAT);
    }

    @Test(dataProvider = "ExponentFormat",groups = "2")
    public void exponentFormat(String input,String expected){
        Assert.assertEquals(OpenWayTask.f_1_dev_x(input),expected);
    }

    @Test(dataProvider = "FloatFormat", groups = "2")
    public void floatFormat(String input,String expected){
        Assert.assertEquals(OpenWayTask.f_1_dev_x(input),expected);
    }

    @Test(dataProvider = "ExtremeValues", groups = "3")
    public void extremeValues(String input,String expected){
        Assert.assertEquals(OpenWayTask.f_1_dev_x(input),expected);
    }

    @Test(dataProvider = "KnownIssues", groups = "3")
    public void negative(String input,String expected){
        Assert.assertEquals(OpenWayTask.f_1_dev_x(input),expected);
    }

    //test integer Size
    @DataProvider(name = "Integer")
    public static Object[][] integer() {
        return new Object[][]{
                {"1","1.0"},
/*                {"2","0.5"},
                {"4","0.25"},
                {"8","0.125"},
                {"-32","-0.03125"},
                {"64","0.015625"},*/
                {"-128","-0.0078125"},
//                {"256","0.00390625"},
//                {"-1024","-9.765625E-4"},
                {Math.pow(2,20) + "","9.5367431640625E-7"},
                {-Math.pow(2,30) + "","-9.313225746154785E-10"},
//                {Math.pow(2,32) + "","2.3283064365386963E-10"},
                {-Math.pow(2,32) + "","-2.3283064365386963E-10"}
        };
    }

    //test border of the Short primitive type
    @DataProvider(name = "Short")
    public static Object[][] shortTest() {
        return new Object[][]{
                {"32768","3.0517578125E-5"},
                {new Double(1.0/32768).toString(),"32768.0"},
                {"32767","3.051850947599719E-5"},
                {new Double(1.0/32767).toString(),"32767.0"}
        };
    }

    @DataProvider(name = "Zero")
    public static Object[][] zero() {
        return new Object[][]{
                {"0","Infinity"},
                {"0.0","Infinity"},
                {"0E0","Infinity"},
                {"0.0E0","Infinity"}
        };
    }

    @DataProvider(name = "IncorrectFormat")
    public static Object[][] incorrectFormat() {
        return new Object[][]{
                {""},
                {"a"},
/*                {"_"},
                {"123.!"},*/
                {"!@#$%^&*()"},
                {"very long string very long string very long string very long string very long string very long string very long string very long string very long string very long string very long string very long string very long string very long string very long string very long string very long string "},
                {"1234567890..0"},
                {"-2.3283064365386963E@10"},
                {"-2.ee-10"}
        };
    }

    @DataProvider(name = "ExponentFormat")
    public static Object[][] exponentFormat() {
        return new Object[][]{
                {"1e1","0.1"},
//                {"1E1","0.1"},
                {"1E01","0.1"},
                {"1.0E10","1.0E-10"},
                {"1.0E-100","1.0E100"},

        };
    }

    @DataProvider(name = "FloatFormat")
    public static Object[][] floatFormat() {
        return new Object[][]{
                {"1.","1.0"},
                {".9","1.1111111111111112"},
                {"9.9","0.10101010101010101"}
                //{"0.0000000000001","1.0E13"},
        };
    }

    @DataProvider(name = "ExtremeValues")
    public static Object[][] extremeValues() {
        return new Object[][]{
                {"1.0E1000","0.0"},
                {"1.0E-1000","Infinity"},
                {"1.0E308","1.0E-308"},
                {"1.0E309","0.0"}
               // {"-9.9e306","-1.01010101010101E-307"}
        };
    }

    @DataProvider(name = "KnownIssues")
    public static Object[][] knownIssues() {
        return new Object[][]{
                {"-9.9e308","-0.0"}
        };
    }
}
