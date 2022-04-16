package me.parker.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P1181 {

    public static void main(String[] args) throws Exception {
        new P1181().solution();
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strings.add(br.readLine());
        }

        /*
         * 정렬 조건
         * 1. 길이가 짧은 것부터
         * 2. 길이가 같으면 사전 순으로
         * 중복 제거
         */
        List<String> sorted = strings.stream()
                .distinct()
                .sorted((s1, s2) -> s1.length() < s2.length()
                        ? -1
                        : s1.length() == s2.length()
                            ? s1.compareTo(s2)
                            : 1)
                .collect(Collectors.toUnmodifiableList());

        for (String s : sorted) {
            System.out.println(s);
        }
    }
}
