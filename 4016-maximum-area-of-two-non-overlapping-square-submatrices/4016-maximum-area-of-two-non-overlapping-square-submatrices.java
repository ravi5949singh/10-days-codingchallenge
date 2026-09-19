class Solution {
    public int maxArea(int[][] mat) {
        return Math.max(calc(mat), calc(transpose(mat)));
    }

    private int calc(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // suf[i] represents the maximum square side length within rows [i, m - 1]
        int[][] f = new int[m + 1][n + 1];
        int[] suf = new int[m + 1];
        for (int i = m - 1; i > 0; i--) {
            int rowMax = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 1) {
                    f[i][j] = Math.min(Math.min(f[i + 1][j], f[i][j + 1]), f[i + 1][j + 1]) + 1;
                    rowMax = Math.max(rowMax, f[i][j]);
                }
            }
            suf[i] = Math.max(suf[i + 1], rowMax);
        }

        // pre[i] represents the maximum square side length within rows [0, i - 1]
        f = new int[m + 1][n + 1];
        int[] pre = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            int rowMax = 0;
            for (int j = 1; j <= n; j++) {
                if (mat[i - 1][j - 1] == 1) {
                    f[i][j] = Math.min(Math.min(f[i - 1][j], f[i][j - 1]), f[i - 1][j - 1]) + 1;
                    rowMax = Math.max(rowMax, f[i][j]);
                }
            }
            pre[i] = Math.max(pre[i - 1], rowMax);
        }

        int maxArea = 0;
        for (int i = 1; i < m; i++) {
            int k = Math.min(pre[i], suf[i]);
            maxArea = Math.max(maxArea, k * k);
        }

        return maxArea;
    }

    private int[][] transpose(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] trans = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                trans[j][i] = mat[i][j];
            }
        }
        return trans;
    }
}