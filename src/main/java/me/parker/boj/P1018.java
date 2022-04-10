package me.parker.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1) 문제
 * M*N 보드가 존재 -> 8 * 8 체스판으로 만들려고 함
 * 체스판 -> 검/횐 번갈아 가면서 존재 (인접한 면이 모두 달라야 함)
 * 보드 맨 왼쪽이 검은색이냐, 흰색이냐 두 가지 존재
 * 보드는 체스판처럼 안되어있는데, 최소한으로 색깔을
 * 
 * 2) 조건
 * 8 <= M, N <= 50
 * -> 완전 탐색, 대략적으로 잡아도 = 50*50*8*8
 */
public class P1018 {

    private static final short CHESS_SIZE = 8;

    public static void main(String[] args) throws Exception {
        new P1018().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        String[][] board = new String[m][n];
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            board[i] = line.split("");
        }

        System.out.println(calculateMinOfPaint(m, n, board));
    }

    // 전체 보드를 체스판 크기로 순회 -> 최소 값 갱신
    private int calculateMinOfPaint(int m, int n, String[][] board) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= m - CHESS_SIZE; i++) {
            for (int j = 0; j <= n - CHESS_SIZE; j++) {
                min = Math.min(min, calculateNumOfPaint(i, j, board));
                min = Math.min(min, calculateNumOfPaintChangedFirstPos(i, j, board));
            }
        }

        return min;
    }

    // 체스판으로 만들려면 몇 개를 칠해야 하는지 계산 (가장 첫 번째 위치를 그대로 두는지/색을 바꾸는지 두 가지 경우 계산)
    private int calculateNumOfPaint(int startY, int startX, String[][] board) {
        int numOfPaint = 0;
        String beforeLineColor = board[startY][startX];
        String beforeColor = board[startY][startX];

        return getNumOfPaint(startY, startX, board, numOfPaint, beforeLineColor, beforeColor);
    }

    private int calculateNumOfPaintChangedFirstPos(int startY, int startX, String[][] board) {
        int numOfPaint = 1;
        String beforeLineColor = toggleColor(board[startY][startX]);
        String beforeColor = toggleColor(board[startY][startX]);

        return getNumOfPaint(startY, startX, board, numOfPaint, beforeLineColor, beforeColor);
    }

    private int getNumOfPaint(int startY, int startX, String[][] board, int numOfPaint, String beforeLineColor, String beforeColor) {
        for (int i = startY; i < startY + CHESS_SIZE; i++) {
            for (int j = startX; j < startX + CHESS_SIZE; j++) {
                if (i == startY && j == startX) {
                    continue;
                }

                if (j == startX) {
                    beforeColor = beforeLineColor;
                }

                numOfPaint += beforeColor.equals(board[i][j]) ? 1 : 0;
                beforeColor = nextColor(beforeColor, board[i][j]);

                if (j == startX) {
                    beforeLineColor = beforeColor;
                }
            }
        }
        return numOfPaint;
    }

    private String nextColor(String beforeColor, String currentColor) {
        if (!beforeColor.equals(currentColor)) {
            return currentColor;
        }

        return toggleColor(beforeColor);
    }

    private String toggleColor(String color) {
        return "B".equals(color) ? "W" : "B";
    }
}