import java.util.*;

class JumpGamefour {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                if (index == n - 1) return steps;

                if (index + 1 < n && !visited[index + 1]) {
                    visited[index + 1] = true;
                    queue.offer(index + 1);
                }
                if (index - 1 >= 0 && !visited[index - 1]) {
                    visited[index - 1] = true;
                    queue.offer(index - 1);
                }

                List<Integer> sameValueIndices = graph.get(arr[index]);
                if (sameValueIndices != null) {
                    for (int sameIndex : sameValueIndices) {
                        if (!visited[sameIndex]) {
                            visited[sameIndex] = true;
                            queue.offer(sameIndex);
                        }
                    }
                    sameValueIndices.clear();
                }
            }
            steps++;
        }

        return -1; 
    }
}

public class JumpGame_IV {
    public static void main(String[] args) {
        JumpGamefour solution = new JumpGamefour();
        int[] arr = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        int result = solution.minJumps(arr);
        System.out.println(result); 
    }
}