public class Restaurant {
    String name;

    RestaurantOwner owner;
    RestaurantStaff cook;
    RestaurantStaff waiter;


    private class RestaurantOwner {
        String name;
        UserAddress address;
    }


    private class RestaurantStaff {
        int age;
        String name;
        int salary;
    }
}
