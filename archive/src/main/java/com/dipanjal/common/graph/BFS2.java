package com.dipanjal.common.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS2 {

    final int[] cx = {1, 0, -1, 0}, cy = {0, 1, 0, -1};
    int R, C;
    Point start, exit;
    int[][] grid;

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int bfs() {
        Queue<Point> toEval = new LinkedList<>();
        toEval.add(exit);
        int currLeft = 1, nextLeft = 0, currDist = 0;
        int answer = 0;
        boolean[][] visited = new boolean[R][C];
        visited[exit.y][exit.x] = true;
        boolean startFound = false;

        Point c;
        while (!toEval.isEmpty()) {
            c = toEval.poll();

            if (currLeft == 0) {
                if (startFound) return answer;  // Done
                currLeft = nextLeft;
                nextLeft = 0;
                currDist++;
            }
            currLeft--;

            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = c.x + cx[i];
                ny = c.y + cy[i];
                if (!visited[ny][nx] && grid[ny][nx] != -1) {
                    if (nx == start.x && ny == start.y) startFound = true;
                    nextLeft++;
                    visited[ny][nx] = true;
                    answer += grid[ny][nx];
                    toEval.add(new Point(nx, ny));
                }
            }
        }
        return -1;
    }
}
