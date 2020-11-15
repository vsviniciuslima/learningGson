import com.google.gson.Gson;

public class learningJson {

    public static void main(String[] args) {

        //serializeUserSimple();
        deserializeUserSimple();
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

        System.out.println(user2.getName() + user2.getAge());
    }
}
