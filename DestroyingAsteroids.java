import java.util.Arrays;

public class DestroyingAsteroids {

    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long planet = mass;

        for (int asteroid : asteroids) {
            if (planet < asteroid) {
                return false;
            }
            planet += asteroid;
        }

        return true;
    }

    public static void main(String[] args) {
        int mass = 10;
        int[] asteroids = {3, 9, 19, 5, 21};

        System.out.println(asteroidsDestroyed(mass, asteroids));
    }
}