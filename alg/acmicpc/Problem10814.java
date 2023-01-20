package alg.acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem10814 {
    // https://www.acmicpc.net/problem/10814
    // 나이순 정렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Human[] h = new Human[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tempAge = Integer.parseInt(st.nextToken());
            String tempName = st.nextToken();
            h[i] = new Human(tempAge, tempName, i);
        }

        Arrays.sort(h, new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                if (o1.age == o2.age)
                    return o1.index - o2.index;
                return o1.age - o2.age;
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(h[i].age + " " + h[i].name);
        }

    }

    static class Human {
        int age;
        String name;
        int index;

        public Human() {

        }

        public Human(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }
    }
}
