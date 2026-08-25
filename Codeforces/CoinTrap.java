package Codeforces;
// E. Sherlock and the Mechanical Coin Trap
// time limit per test1 second
// memory limit per test256 megabytes
// While investigating a peculiar case in Baker Street, Sherlock Holmes discovers a strange mechanical device left by Professor Moriarty. The device consists of N coins placed in a straight line on a table. Each coin shows either Head (H) or Tail (T).
// Sherlock notices that the device follows very specific rules:
// Sherlock can remove a coin only if it shows Head.
// When Sherlock removes the coin at position i, a hidden mechanical switch activates and flips the state of the coins that were originally adjacent to it:
// The coin that was originally to its left, if it exists.
// The coin that was originally to its right, if it exists.
// Two coins are considered neighbors only if they were adjacent in the initial arrangement, regardless of which coins have been removed afterward.
// Input
// The first line contains a single integer t
//  (1≤t≤104
// ) — the number of test cases.
// Each test case consists of two lines.
// The first line of each test case contains a single integer n
//  (1≤n≤2⋅105
// ) — the number of coins.
// The second line of each test case contains a string s
//  of length n
//  consisting only of characters 'H' and 'T'.
// Output
// If it is impossible to remove all coins, print NO.
// Otherwise, print YES in the first line.
// In the second line, print n
//  integers — the sequence of removed coin positions in order.
// If there are multiple valid answers, print any.
// Example
// InputCopy
// 1
// 2
// HH
// OutputCopy
// NO

import java.util.Scanner;


public class CoinTrap {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()){ 
            sc.close();
            return;}
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            // Edge case: single coin
            if (n == 1) {
                System.out.println(s.charAt(0) == 'H' ? "YES\n1" : "NO");
                continue;
            }

            // dir[i]: true if coin i is removed before i+1, false if i+1 before i
            boolean[] dir = new boolean[n]; // 1-based indexing for edges 1..n-1
            
            // Coin 1
            dir[1] = (s.charAt(0) == 'H');

            // Coins 2 to n-1
            for (int i = 2; i < n; i++) {
                int leftBefore = dir[i - 1] ? 1 : 0;
                int needTotal = (s.charAt(i - 1) == 'T') ? 1 : 0; // T needs odd (1), H needs even (0 or 2)
                
                int rightBefore = (needTotal - leftBefore + 2) % 2;
                dir[i] = (rightBefore == 0); // true means i -> i+1
            }

            // Verify Coin n
            int leftBeforeLast = dir[n - 1] ? 1 : 0;
            int needTotalLast = (s.charAt(n - 1) == 'T') ? 1 : 0;

            if (leftBeforeLast != needTotalLast) {
                System.out.println("NO");
                continue;
            }

            // Count how many neighbors must be removed before each coin
            int[] inDegree = new int[n + 1];
            for (int i = 1; i < n; i++) {
                if (dir[i]) {
                    inDegree[i + 1]++; // i is before i+1, so i+1 waits for i
                } else {
                    inDegree[i]++;     // i+1 is before i, so i waits for i+1
                }
            }

            // Collect and print the order (Queue using an array)
            int[] order = new int[n];
            int head = 0, tail = 0;

            for (int i = 1; i <= n; i++) {
                if (inDegree[i] == 0) {
                    order[tail++] = i;
                }
            }

            while (head < tail) {
                int u = order[head++];

                // Check left neighbor dependency
                if (u > 1 && !dir[u - 1]) { // edge was u -> u-1
                    if (--inDegree[u - 1] == 0) order[tail++] = u - 1;
                }
                // Check right neighbor dependency
                if (u < n && dir[u]) {      // edge was u -> u+1
                    if (--inDegree[u + 1] == 0) order[tail++] = u + 1;
                }
            }

            // Output result
            System.out.println("YES");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(order[i]).append(i == n - 1 ? "" : " ");
            }
            System.out.println(sb.toString());
        }
        sc.close();
    }
    
}
