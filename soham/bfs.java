package soham;

// 8 Puzzle problem using BFS

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class bfs {

    private static final String GOAL = "123456780";
    private static final int[] ROW = {-1, 1, 0, 0};
    private static final int[] COL = {0, 0, -1, 1};
    private static final char[] MOVE = {'U', 'D', 'L', 'R'};

    private static class Node {
        String parent;
        char move;

        Node(String parent, char move) {
            this.parent = parent;
            this.move = move;
        }
    }

    private static boolean isSolvable(String state) {
        int inversions = 0;
        for (int i = 0; i < state.length(); i++) {
            char current = state.charAt(i);
            if (current == '0') {
                continue;
            }
            for (int j = i + 1; j < state.length(); j++) {
                char next = state.charAt(j);
                if (next != '0' && current > next) {
                    inversions++;
                }
            }
        }
        return inversions % 2 == 0;
    }

    private static List<String> reconstructPath(Map<String, Node> visited, String endState) {
        List<String> path = new ArrayList<>();
        String current = endState;

        while (current != null) {
            path.add(0, current);
            current = visited.get(current).parent;
        }
        return path;
    }

    public static List<String> solve(String start) {
        if (start == null || start.length() != 9) {
            throw new IllegalArgumentException("8-puzzle state must contain exactly 9 characters");
        }
        if (!isSolvable(start)) {
            return null;
        }

        Queue<String> queue = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        Map<String, Node> visited = new HashMap<>();

        queue.offer(start);
        seen.add(start);
        visited.put(start, new Node(null, ' '));

        while (!queue.isEmpty()) {
            String state = queue.poll();
            if (GOAL.equals(state)) {
                return reconstructPath(visited, state);
            }

            int zeroIndex = state.indexOf('0');
            int zeroRow = zeroIndex / 3;
            int zeroCol = zeroIndex % 3;

            for (int i = 0; i < 4; i++) {
                int newRow = zeroRow + ROW[i];
                int newCol = zeroCol + COL[i];

                if (newRow < 0 || newRow >= 3 || newCol < 0 || newCol >= 3) {
                    continue;
                }

                int swapIndex = newRow * 3 + newCol;
                StringBuilder nextState = new StringBuilder(state);
                nextState.setCharAt(zeroIndex, state.charAt(swapIndex));
                nextState.setCharAt(swapIndex, '0');

                String candidate = nextState.toString();
                if (seen.add(candidate)) {
                    queue.offer(candidate);
                    visited.put(candidate, new Node(state, MOVE[i]));
                }
            }
        }

        return null;
    }

    private static void printSolution(List<String> path) {
        if (path == null) {
            System.out.println("No solution exists for this 8-puzzle state.");
            return;
        }

        System.out.println("Moves required: " + (path.size() - 1));
        for (String state : path) {
            for (int i = 0; i < 9; i++) {
                char value = state.charAt(i);
                System.out.print((value == '0' ? ' ' : value) + " ");
                if ((i + 1) % 3 == 0) {
                    System.out.println();
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String start = "123450678";
        List<String> solution = solve(start);
        printSolution(solution);
    }
}