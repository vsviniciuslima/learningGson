public class UserNested {
    private String name;
    private String email;
    private int age;
    private boolean isDeveloper;

    // novo
    UserAdress userAdress;

    public UserNested(String name, String email, int age, boolean isDeveloper, UserAdress userAdress) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.isDeveloper = isDeveloper;
        this.userAdress = userAdress;
    }

}
