import com.google.gson.Gson;

public class learningJson {

    public static void main(String[] args) {

        //serializeUserSimple();
        //deserializeUserSimple();

        System.out.println("learningGson 2.0");
        //serializeUserNested();
        deserializeUserNested();
    }

    private static void serializeUserSimple() {

        UserSimple user = new UserSimple(
                "Vinicius",
                "vsviniciuslima@gmail.com",
                20,
                true
                );

        Gson gson = new Gson();

        String json = gson.toJson(user);

    }
    private static void deserializeUserSimple() {
        String source = "{\n" +
                "  \"name\": \"Guilherme\",\n" +
                "  \"email\": \"gsguilhermelima@gmail.com\",\n" +
                "  \"age\": 23,\n" +
                "  \"isDeveloper\": false\n" +
                "}";

        Gson gson = new Gson();

        UserSimple user2 = gson.fromJson(source, UserSimple.class);
    }

    private static void serializeUserNested() {

        UserAddress adress = new UserAddress(
                "Main Street",
                "64",
                "Madgeburg",
                "Germany"
        );

        UserNested userNested = new UserNested(
                "Vinicius",
                "vsviniciuslima@gmail.com",
                20,
                true,
                adress
        );

        String json = new Gson().toJson(userNested);
    }
    private static void deserializeUserNested() {
        String restaurantJson = "{\n" +
                "  \"name\": \"Future Studio Steakhouse\",\n" +
                "  \"owner\": {\n" +
                "    \"name\": \"Christian\",\n" +
                "    \"address\": {\n" +
                "      \"city\": \"Madgeburg\",\n" +
                "      \"country\": \"Germany\",\n" +
                "      \"houseNumber\": \"42A\",\n" +
                "      \"street\": \"Main Street\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"cook\": {\n" +
                "    \"age\": 18,\n" +
                "    \"name\": \"Marcus\",\n" +
                "    \"salary\": 1500\n" +
                "  },\n" +
                "  \"waiter\": {\n" +
                "    \"age\": 18,\n" +
                "    \"name\": \"Norman\",\n" +
                "    \"salary\": 1000\n" +
                "  }\n" +
                "}";

        Restaurant restaurant = new Gson().fromJson(restaurantJson, Restaurant.class);
    }
}
