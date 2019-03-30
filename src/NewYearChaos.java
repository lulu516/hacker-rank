/***
 * https://www.hackerrank.com/challenges/new-year-chaos/problem
 */

import java.util.*;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        try {
            int count = countBribes(q, new ArrayList<Integer>());
            System.out.println(count);
        } catch (Exception e) {
            System.out.println("Too chaotic");
        }
    }

    static int countBribes(int[] q, List<Integer> movedNumbers) throws Exception {
        int size = q.length;
        int count = 0;

        for (int i = 0; i < size; i ++) {
            int movedTimes = (Collections.binarySearch(movedNumbers, q[i], Comparator.reverseOrder()) * -1) - 1;
            int originalPos =q[i] - 1 + movedTimes;
            if (originalPos > i) {
                if (originalPos - i > 2) {
                    throw new Exception();
                } else {
                    count += originalPos - i;
                    movedNumbers.add(movedTimes, q[i]);
                }
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
