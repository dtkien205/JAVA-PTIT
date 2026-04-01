/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacodeptit;

import java.util.*;

/**
 *
 * @author PC
 */
public class Bai5 {
    static final int MAX = 1005;
    static int[][] a = new int[MAX][MAX];
    static int[][] dist = new int[MAX][MAX];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    a[i][j] = sc.nextInt();
                    dist[i][j] = -1;
                }
            }
            
            Queue<int[]> q = new ArrayDeque<>();
            dist[0][0] = 0;
            q.add(new int[]{0, 0});

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int i = cur[0], j = cur[1];
                int d = dist[i][j];
                int v = a[i][j];

                if (i + 1 < n) {
                    int k = Math.abs(v - a[i + 1][j]);
                    int ni = i + k;
                    if (ni < n && dist[ni][j] == -1) {
                        dist[ni][j] = d + 1;
                        q.add(new int[]{ni, j});
                    }        
                }

                if (j + 1 < m) {
                    int k = Math.abs(v - a[i][j + 1]);
                    int nj = j + k;
                    if (nj < m && dist[i][nj] == -1) {
                        dist[i][nj] = d + 1;
                        q.add(new int[]{i, nj});
                    }
                }

                if (i + 1 < n && j + 1 < m) {
                    int k = Math.abs(v - a[i + 1][j + 1]);
                    int ni = i + k, nj = j + k;
                    if (ni < n && nj < m && dist[ni][nj] == -1) {
                        dist[ni][nj] = d + 1;
                        q.add(new int[]{ni, nj});
                    }
                }
            }

            System.out.println(dist[n - 1][m - 1]);
        }
    }
}



