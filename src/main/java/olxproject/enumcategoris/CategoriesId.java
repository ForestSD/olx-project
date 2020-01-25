package olxproject.enumcategoris;

import java.util.Arrays;
import java.util.List;

public enum CategoriesId {
    childrenWorld("bottom36", Arrays.asList("Детский мир","Дитячий світ")),
    theProperty("bottom1", Arrays.asList("Недвижимость","Нерухомість")),
    transport("bottom1532", Arrays.asList("Транспорт","Транспорт")),
    spares("bottom3", Arrays.asList("Запчасти для транспорта","Запчастини для транспорту")),
    work("bottom6", Arrays.asList("Работа","Робота")),
    animal("bottom35", Arrays.asList("Животные","Тварини")),
    homeAndGarden("bottom899", Arrays.asList("Дом и сад","Дім і сад")),
    electronic("bottom37", Arrays.asList("Электроника","Електроніка")),
    business("bottom7", Arrays.asList("Бизнес и услуги","Бізнес та послуги")),
    fashion("bottom891", Arrays.asList("Мода и стиль","Мода і стиль")),
    hobby("bottom903", Arrays.asList("Хобби отдых и спорт","Хобі відпочинок і спорт"))
    ;

    private String numberID;
    private List<String> name;

    CategoriesId(String buttonID, List<String> name) {
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

}
