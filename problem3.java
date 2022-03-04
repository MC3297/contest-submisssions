//usaco bronze feb contest 2022, blocks
import java.util.*;
import java.io.*;
public class problem3 {
    public static void solve(ArrayList<String> arr, String target, HashMap<Integer, HashSet<Character>> store, String currstring, int index) {
        if (index == target.length()) {
            arr.add(currstring);
            return;
        }
        for (int i: store.keySet()) {
            if (store.get(i).contains(target.charAt(index))) {
                solve(arr, target, store, currstring+i, index+1);
            }
        }
    }
    public static boolean isvalidstring(String s) {
        HashSet<Character> temp = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            temp.add(s.charAt(i));
        }
        if (s.length() == temp.size()) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int numtestcases = Integer.parseInt(r.readLine());
        HashMap<Integer, HashSet<Character>> store = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            String s = r.readLine();
            HashSet<Character> temp = new HashSet<>();
            for (int j = 0; j < s.length(); j++) {
                temp.add(s.charAt(j));
            }
            store.put(i, temp);
        }
        for (int i = 0; i < numtestcases; i++) {
            String target = r.readLine();
            ArrayList<String> arr = new ArrayList<>();
            solve(arr, target, store,"", 0);
            boolean returned = false;
            //pw.println(arr);
            for (String j: arr) {
                if (isvalidstring(j)) {
                    pw.println("YES"); returned = true; break;
                }
            }
            if (!returned) {
                pw.println("NO");
            }
        }

        pw.close();
    }
}
