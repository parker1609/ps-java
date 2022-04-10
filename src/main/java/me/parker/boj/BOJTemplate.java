package me.parker.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJTemplate {

    public static void main(String[] args) throws Exception {
        new BOJTemplate().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        // 문자열 한 줄 입력
        String input = br.readLine();

        // 문자열 2차원 배열 입력
        List<String> inputs = new ArrayList<>();
        String temp = "";
        while ((temp = br.readLine()) != null) {
            inputs.add(temp);
        }

        int m, n;
        String[][] board = new String[m][n];
        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            board[i] = line.split("");
        }

        // 정수 입력
        int num = Integer.parseInt(br.readLine());

        // 공백을 기준으로 입력받기
        List<Integer> nums = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }
    }
}
