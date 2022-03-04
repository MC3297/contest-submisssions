//usaco bronze feb contest 2022, photoshoot 2
import java.util.*;
import java.io.*;
public class problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int numtestcases = Integer.parseInt(r.readLine());
        ArrayList<Integer> wrong = new ArrayList<>();
        int[] right = new int[numtestcases];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < numtestcases; i++) {
            wrong.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(r.readLine());
        for (int i = 0; i < numtestcases; i++) {
            right[i] = Integer.parseInt(st.nextToken());
        }
        int total = 0;
        //HashSet<Integer> check = new HashSet<>();
        /*while (indexright < right.length && indexwrong < wrong.length) {
            if (right[indexright] != wrong[indexwrong]) {
                indexright++; total++;
            }
            else if (right[indexright] == wrong[indexwrong]) {
                indexright++; indexwrong++;
            }
        }*/
        for (int i = 0; i < right.length; i++) {
            if (right[i] != wrong.get(i)) {
                wrong.remove(wrong.indexOf(right[i]));
                wrong.add(i, right[i]);
                total++;
            }
        }
        //pw.println(wrong);
        //pw.println(Arrays.toString(right));
        pw.println(total);
        pw.close();
    }
}
