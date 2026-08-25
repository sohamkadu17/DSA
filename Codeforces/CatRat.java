package Codeforces;

import java.util.Scanner;

// P. Shimlock Gnomes and the Phantom Rat
// The brilliant cat Shemlock Gnomes, feline companion to the great detective, has discovered a colony of rats living in the sewers of Baker Street. The sewer system consists of n
//  tunnels arranged in a straight line, numbered from 1
//  to n
// .
// A single rat is hiding in one of these tunnels. Warlock Gnomes wants to capture it, but the rat is elusive and follows a strict ritual:

// • The Midnight Scuttle: Every night, the rat must move from its current tunnel i
//  to an adjacent tunnel (i−1
//  or i+1
// ). If the rat is at an end (tunnel 1
//  or n
// ), it must move to the only possible neighbor (2
//  or n−1
// , respectively).

// •The Daylight Hunt: During the day, Warlock Gnomes can choose exactly one tunnel k
//  to inspect. If the rat is currently in tunnel k
// , it is captured! Otherwise, the rat hears the cat's footsteps and retreats deep into its current tunnel, making it impossible to catch for the rest of that day.

// Shimlock Gnomes does not know the rat's starting position. Your task is to provide a sequence of tunnel inspections such that, regardless of where the rat starts or how it moves, the cat is guaranteed to capture the rat at some point during the sequence.

// Input
// A single integer n
//  (2≤n≤105
// ) — the number of tunnels in the line.

// Output
// print an integer s
//  (1≤s≤3n
// ) — the number of days in your hunting sequence.On the second line, print s
//  space-separated integers p1,p2,…,ps
//  (1≤pi≤n
// ) — the index of the tunnel Shimlock Gnomes should check on day i
// .

// Example
// InputCopy
// 3
// OutputCopy
// 2
// 2 2
// Note
// If n=3
// , the rat can start at 1, 2, or 3.

// •If the rat starts at 2: On Day 1, the cat checks 2. Captured.

// •If the rat starts at 1 or 3: After the first night, the rat must move to tunnel 2. On Day 2, the cat checks 2. Captured.




public class CatRat {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();

        if(n == 2){
            System.out.println(2);
            System.out.println("2 2");
            return;
        }
        StringBuilder sb = new StringBuilder();
        int totalDays = 2 * n - 4;
        sb.append(totalDays).append("\n");

        // Phase 1: Forward sweep from tunnel 2 to n - 1
        for (int i = 2; i <= n - 1; i++) {
            sb.append(i).append(" ");
        }

        // Phase 2: Backward sweep from tunnel n - 1 down to 2
        for (int i = n - 1; i >= 2; i--) {
            sb.append(i);
            if (i > 2) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
