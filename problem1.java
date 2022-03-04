//usaco bronze feb contest 2022, sleeping in class
import java.util.*;
import java.io.*;
public class problem1 {
    public static int max(int[] storage) {
        int max = storage[0];
        for (int i: storage) {
            max = Math.max(max, i);
        }
        return max;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int numtestcases = Integer.parseInt(r.readLine());
        for (int q = 0; q < numtestcases; q++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] storage = new int[n];
            st = new StringTokenizer(r.readLine());
            for (int i = 0; i < n; i++) {
                storage[i] = Integer.parseInt(st.nextToken());
            }
            int target = max(storage);
            boolean valid = false;
            ArrayList<Integer> vals = new ArrayList<>();
            while (!valid) {
                int temp = 0;
                for (int i = 0; i < storage.length; i++) {
                    if (i == storage.length-1) {
                        valid = true;
                    }
                    if (temp < target) {
                        temp += storage[i];
                    }
                    if (temp > target) {
                        break;
                    }
                    if (temp == target) {
                        vals.add(temp);temp = 0;
                    }
                }
                if (!valid) {
                    vals.clear();
                    target++;
                }
            }
            
            pw.println(n-vals.size());
        }
        pw.close();
    }
}
