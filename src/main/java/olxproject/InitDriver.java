package olxproject;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;

public class InitDriver {

    public static void initDriver() {
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
}
