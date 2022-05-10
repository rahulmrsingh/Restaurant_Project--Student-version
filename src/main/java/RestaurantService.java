import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
        String establishmentName = restaurantName;

        for (Restaurant restaurant : restaurants){

            if(restaurant.getName().toLowerCase().equals(restaurantName.toLowerCase())){
                return restaurant;
            }
        }
        throw new restaurantNotFoundException("Error: Restaurant could not be found");
    }


    public Restaurant addRestaurant(Restaurant restaurant) {
        Restaurant newRestaurant = new Restaurant(restaurant.getName(), restaurant.getLocation(), restaurant.getOpeningTime(), restaurant.getClosingTime());
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
