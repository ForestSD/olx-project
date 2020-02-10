package olxproject;

import olxproject.enumcategoris.CategoriesId;
import olxproject.interfacepage.Config;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public class InitConfig {

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
