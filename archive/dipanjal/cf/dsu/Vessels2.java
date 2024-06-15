package com.dipanjal.cf.dsu;

import java.util.Scanner;

/**
 * @author dipanjal
 * @since 0.0.1
 * https://codeforces.com/contest/371/problem/D
 */
public class Vessels2 {
    public static int size = 200000;
    public static int[] father = new int[size+10];
    public static int[] pre = new int[size+10];
    public static int[] now = new int[size+10];

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for ( int i = 1 ; i<=n ; ++i ) {
            pre[i] = sc.nextInt();
            now[i] = pre[i];
            father[i] = i;
        }
        int m = sc.nextInt();
        int type = 0 , pos = 0 , var = 0 , last = 1;
        for ( int i = 1 ; i<=m ; ++i ) {
            type = sc.nextInt();
            if ( type==2 ) {
                pos = sc.nextInt();
                System.out.println(pre[pos]-now[pos]);
            } else {
                pos = sc.nextInt();
                var = sc.nextInt();
                last = find(pos);
                while ( last<=n && var>=now[last] ) {
                    var -= now[last];
                    now[last] = 0;
                    if ( last!=pos) {
                        int x = find(last-1);
                        int y = find(last);
                        father[x] = y;
                    }
                    ++ last;
                }
                now[last] -= var;
            }
        }
    }
    public static int find( int x ) {
        if ( father[x] == x ) {
            return x;
        }
        return father[x] = find( father[x] );
    }
}
