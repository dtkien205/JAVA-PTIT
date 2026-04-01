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
public class J08029 {
    static int dx[] = { -2, -2, -1, -1, 1, 1, 2, 2 };
    static int dy[] = { -1, 1, -2, 2, -2, 2, -1, 1 };
    
    public static int solve(String st, String ed) {
        int s = st.charAt(0) - 'a' + 1;
        int t = st.charAt(1) - '0';
        int u = ed.charAt(0) - 'a' + 1;
        int v = ed.charAt(1) - '0';
        
        boolean[][] vs = new boolean[10][10];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(s, t, 0)); 
        vs[s][t] = true;
        
        while(!q.isEmpty()) {
            Pair a = q.poll();
            int i = a.x, j = a.y, cnt = a.cnt;
            
            if (i == u && j == v) return cnt;
            
            for (int k = 0; k < 8; k++) {
                int i1 = i + dx[k], j1 = j + dy[k];
                if (i1 >= 1 && i1 <= 8 && j1 >= 1 && j1 <= 8 && !vs[i1][j1]) {
                    vs[i1][j1] = true;
                    q.add(new Pair(i1, j1, cnt + 1));
                } 
            }
        }
        return -1; 
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            String start = sc.next();
            String end = sc.next();
            System.out.println(solve(start, end));
        }
    }
}

class Pair {
    int x, y, cnt;
    
    Pair (int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

//8
//e2 e4
//a1 b2
//b2 c3
//a1 h8
//a1 h7
//h8 a1
//b1 c3
//f6 f6