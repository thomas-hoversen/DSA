import java.util.*;


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
        //buildLastTable("octocat");
        CharacterComparator comparator = new CharacterComparator();
        //List<Integer> matches = boyerMoore("abca", "abcabcabcabc", comparator);
        List<Integer> matches = boyerMoore("COM", "COMPUTERSCIENCE", comparator);
        System.out.println("Matches: " + matches);
        System.out.println("Comparisons: " + comparator.getComparisonCount());
    }



    public static List<Integer> boyerMoore(CharSequence pattern, CharSequence text, CharacterComparator comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        Map<Character, Integer> lastTable = buildLastTable(pattern);
        int i = 0;
        List<Integer> matches = new ArrayList<>();



        while (i <= text.length() - pattern.length()) {
            int j = pattern.length() - 1;

            while (j >= 0 && comparator.compare(text.charAt(i + j), pattern.charAt(j)) == 0) {
                j--;
            }

            if (j == -1) {
                matches.add(i); // i + j ?
                i++;
            } else {
                int shift = lastTable.getOrDefault(text.charAt(i + j), -1);
                if (shift < j) {
                    i = i + j - shift; // order of operations?
                } else {
                    i++;
                }
            }

        }
        return matches;

    }

    public static Map<Character, Integer> buildLastTable(CharSequence pattern) {
        /*
        * Ex. pattern = octocat
        *
        * table.get(o) = 3
        * table.get(c) = 4
        * table.get(t) = 6
        * table.get(a) = 5
        */

        int m = pattern.length();
        Map<Character, Integer> last = new HashMap<>();

        for (int i = 0; i < m; i++) {
            last.put(pattern.charAt(i), i);
        }
        printTable(last);
        return last;

    }

    public static void printTable(Map<Character, Integer> table) {
        Set<Character> keys = table.keySet();
        Iterator newKeys = keys.iterator();
        for (int i = 0; i < table.size(); i++) {
            Object key = newKeys.next();
            System.out.println("Key: " + key + " Value: " + table.get((Character) key));
        }

    }
    /*
    [Executed at: Tue Sep 28 16:24:05 PDT 2021]
    ============================================================
    PatternMatching.java successfully compiled.
    ============================================================
    Tests Passed: 13 / 18

            [Test Failure: boyerBoore] [-0.56] : Returned list is correct for text : "BAADBACCD", pattern : "ABCD", but the number of comparator usages was different than expected.
    Acceptable comparisons : 6
    Actual comparisons : 4

            [Test Failure: boyerBoore] [-0.56] : Returned list is correct for text : "ABCDEFG", pattern : "XYZ", but the number of comparator usages was different than expected.
    Acceptable comparisons : 2
    Actual comparisons : 5

            [Test Failure: boyerBoore] [-0.56] : Returned list is correct for text : "COMPUTERSCIENCE", pattern : "COM", but the number of comparator usages was different than expected.
    Acceptable comparisons : 8
    Actual comparisons : 14

            [Test Failure: boyerBoore] [-0.56] : Returned list is correct for text : "COMPUTERSCIENCE", pattern : "NCE", but the number of comparator usages was different than expected.
    Acceptable comparisons : 9
    Actual comparisons : 17

            [Test Failure: boyerBoore] [-0.56] : Unexpected content in returned list for text : "BABCDABABCDB", pattern : "ABCD".
    Expected : [1, 7]
    Actual : []


    Score: 7.22 / 10.0
            ============================================================ */

}
