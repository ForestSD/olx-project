package olxproject.enumcategoris;

import java.util.ArrayList;
import java.util.List;

public class CategoriesId {

    private String key;
    private String numberID;
    private List<String> name;

    public CategoriesId(String key, String buttonID, List<String> name) {
        this.key = key;
        this.numberID = buttonID;
        this.name = name;
    }

    public String giveId(){
        return numberID;
    }

    public static CategoriesId getByName(String name){
        for (CategoriesId value : CategoriesId.values()) {
            for (String oneName : value.name){
                if(oneName.equalsIgnoreCase(name)){
                    return value;
                }
            }
        }
        throw new IllegalArgumentException(name + " NOT FOUND ");
    }

    private static List<CategoriesId> categoriesIds = new ArrayList<>();

    public static List<CategoriesId> values() {
        return categoriesIds;
    }

    @Override
    public String toString() {
        return "CategoriesId{" +
                "key='" + key + '\'' +
                ", numberID='" + numberID + '\'' +
                ", name=" + name +
                '}';
    }
}
