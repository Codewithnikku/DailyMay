import java.util.*;

class MIETFT {

    public int minimumEffort(int[][] tasks) {

        Arrays.sort(tasks, (a, b) -> {
            return (b[1] - b[0]) - (a[1] - a[0]);
        });

        int initialEnergy = 0;
        int currentEnergy = 0;

        for (int[] task : tasks) {

            int actual = task[0];
            int minimum = task[1];

            if (currentEnergy < minimum) {
                initialEnergy += (minimum - currentEnergy);
                currentEnergy = minimum;
            }

            currentEnergy -= actual;
        }

        return initialEnergy;
    }
}

public class MinimumInitialEnergyToFinishTasks {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of tasks: ");
        int n = sc.nextInt();

        int[][] tasks = new int[n][2];

        System.out.println("Enter actual and minimum energy for each task:");

        for (int i = 0; i < n; i++) {
            tasks[i][0] = sc.nextInt();
            tasks[i][1] = sc.nextInt();
        }

        MIETFT solver = new MIETFT();

        int result = solver.minimumEffort(tasks);

        System.out.println("Minimum Initial Energy Required: " + result);

        sc.close();
    }
}