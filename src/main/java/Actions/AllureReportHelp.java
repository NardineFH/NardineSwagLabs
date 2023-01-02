package Actions;

import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;

public class AllureReportHelp {
    public static void attachScreenshot( byte[] screenshot){

        Allure.addAttachment("attach screenshot",new ByteArrayInputStream(screenshot));

    }
}
