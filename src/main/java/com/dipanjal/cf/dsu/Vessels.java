package com.dipanjal.cf.dsu;

import java.util.Scanner;

/**
 * @author dipanjal
 * @since 0.0.1
 * https://codeforces.com/contest/371/problem/D
 */
public class Vessels {

    static int[] capacity, remain, parent;

    public static int findSet(int pos){
        if(parent[pos] == pos)
            return pos;
        return parent[pos] = findSet(parent[pos]);
    }

    void unionSet(int a, int b) {
        a = findSet(a);
        b = findSet(b);
        if (a != b)
            parent[b] = a;
    }

    public static void pour(int pos, int amount) {
        while(amount > 0 && pos <= (capacity.length - 5)) {
            if(amount > remain[pos]) {
                amount -= remain[pos];
                remain[pos] = 0;
                parent[pos] = pos+1;
                pos = findSet(pos);
            }else {
                remain[pos] -= amount;
                amount = 0;
            }
        }
    }

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

            capacity = new int[n+5];
            remain = new int[n+5];
            parent = new int[n+5];

            for ( int i = 1 ; i<=n ; ++i ) {
                capacity[i] = sc.nextInt();
                remain[i] = capacity[i];
                parent[i] = i;
            }
            int q = sc.nextInt();
            int type, pos, amount;
            for ( int i = 0 ; i<q ; i++ ) {
                type = sc.nextInt();
                if(type == 1){
                    pos = sc.nextInt();
                    amount = sc.nextInt();
                    pour(findSet(pos), amount);
                    //pour water
                }else if (type == 2) {
                    pos = sc.nextInt();
                    System.out.println(
                            capacity[pos] - remain[pos]
                    );
                }
            }
        }catch (Exception e){

        }

    }
}
