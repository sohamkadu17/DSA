package Codeforces;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
// https://codeforces.com/gym/106669/problem/A
public class Curse {
    private static int M;
    private static int maxStates;
    private static int[] pow3;


    
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner(System.in);
        FastOutput output = new FastOutput(System.out);

        int N = scanner.nextInt();
        M = scanner.nextInt();

        // Precompute powers of 3
        pow3 = new int[M + 1];
        pow3[0] = 1;
        for (int i = 1; i <= M; i++) {
            pow3[i] = pow3[i - 1] * 3;
        }
        maxStates = pow3[M];

        int[] dp1 = new int[maxStates];
        int[] dp2 = new int[maxStates];

        // 1. Read Archive Strings & populate initial frequencies
        for (int i = 0; i < N; i++) {
            String s = scanner.next();
            int code = encode(s);
            dp1[code]++;
            dp2[code]++;
        }

        // 2. SOS DP for Type 1 (Parent Lookup)
        for (int dim = 0; dim < M; dim++) {
            int stride = pow3[dim];
            for (int i = 0; i < maxStates; i += stride * 3) {
                for (int j = 0; j < stride; j++) {
                    int i0 = i + j;
                    int i1 = i0 + stride;
                    int i2 = i0 + 2 * stride;

                    int a0 = dp1[i0];
                    int a1 = dp1[i1];
                    int a2 = dp1[i2];

                    // X[dim] = '0' (0) -> Parent can be '0', '1', or '?' (0, 1, 2)
                    dp1[i0] = a0 + a1 + a2;
                    // X[dim] = '1' (1) -> Parent can be '1' or '?' (1, 2)
                    dp1[i1] = a1 + a2;
                    // X[dim] = '?' (2) -> Parent can be '0' (0)
                    dp1[i2] = a0;
                }
            }
        }

        // 3. SOS DP for Type 2 (Child Lookup)
        for (int dim = 0; dim < M; dim++) {
            int stride = pow3[dim];
            for (int i = 0; i < maxStates; i += stride * 3) {
                for (int j = 0; j < stride; j++) {
                    int i0 = i + j;
                    int i1 = i0 + stride;
                    int i2 = i0 + 2 * stride;

                    int a0 = dp2[i0];
                    int a1 = dp2[i1];
                    int a2 = dp2[i2];

                    // X[dim] = '0' (0) -> Child can be '0' or '?' (0, 2)
                    dp2[i0] = a0 + a2;
                    // X[dim] = '1' (1) -> Child can be '0' or '1' (0, 1)
                    dp2[i1] = a0 + a1;
                    // X[dim] = '?' (2) -> Child can be '0' or '1' (0, 1)
                    dp2[i2] = a0 + a1;
                }
            }
        }

        // 4. Answer Queries in O(1) time each
        int Q = scanner.nextInt();
        for (int q = 0; q < Q; q++) {
            int type = scanner.nextInt();
            String x = scanner.next();
            int code = encode(x);

            if (type == 1) {
                output.println(dp1[code]);
            } else {
                output.println(dp2[code]);
            }
        }

        output.flush();
    }

    // Convert string ('0', '1', '?') into a base-3 integer
    private static int encode(String s) {
        int code = 0;
        for (int i = 0; i < M; i++) {
            char c = s.charAt(i);
            int val = (c == '0') ? 0 : (c == '1' ? 1 : 2);
            code = code * 3 + val;
        }
        return code;
    }

    // Fast I/O Helper Classes
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[32768];
        private int head = 0, tail = 0;

        public FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (head >= tail) {
                head = 0;
                tail = in.read(buffer, 0, buffer.length);
                if (tail <= 0) return -1;
            }
            return buffer[head++];
        }

        public String next() throws IOException {
            int c = read();
            while (c <= 32) {
                if (c == -1) return null;
                c = read();
            }
            StringBuilder res = new StringBuilder();
            while (c > 32) {
                res.append((char) c);
                c = read();
            }
            return res.toString();
        }

        public int nextInt() throws IOException {
            int c = read();
            while (c <= 32) {
                if (c == -1) return 0;
                c = read();
            }
            int res = 0;
            while (c > 32) {
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }
    }

    static class FastOutput {
        private final OutputStream out;
        private final byte[] buffer = new byte[32768];
        private int head = 0;

        public FastOutput(OutputStream out) {
            this.out = out;
        }

        public void print(int val) throws IOException {
            if (val == 0) {
                writeByte((byte) '0');
                return;
            }
            byte[] b = new byte[12];
            int p = 0;
            while (val > 0) {
                b[p++] = (byte) ('0' + (val % 10));
                val /= 10;
            }
            for (int i = p - 1; i >= 0; i--) {
                writeByte(b[i]);
            }
        }

        public void println(int val) throws IOException {
            print(val);
            writeByte((byte) '\n');
        }

        private void writeByte(byte b) throws IOException {
            if (head >= buffer.length) flush();
            buffer[head++] = b;
        }

        public void flush() throws IOException {
            if (head > 0) {
                out.write(buffer, 0, head);
                head = 0;
            }
        }
    }
}