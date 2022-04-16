package me.parker.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1085 {

    public static void main(String[] args) throws Exception {
        new P1085().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        List<Integer> nums = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        // x, y, w, h
        int x = nums.get(0);
        int y = nums.get(1);
        int w = nums.get(2);
        int h = nums.get(3);

        List<Integer> candidates = List.of(w - x, h - y, x, y);
        Integer min = candidates.stream().min(Integer::compareTo).orElse(0);

        System.out.println(min);
    }
}
