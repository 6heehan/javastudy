package alg.programmers;

public class Lessons42885 {
    public static void main(String[] args) {
        System.out.println("구명보트");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/42885");

        Lessons42885 problem = new Lessons42885();
        int[] people1 = {70,50,80,50};
        int[] people2 = {70,80,50};
        int limit = 100;

        System.out.println(problem.solution(people1, limit));
        System.out.println(problem.solution(people2, limit));
    }

    public int solution(int[] people, int limit) {
        int answer = 0;
        for(int i=0; i<people.length; i++) {
            int weight = people[i];
            if(weight == 0) continue;
            for(int j=i+1 ; j<people.length ; j++) {
                if(weight + people[j] <= limit) {
                    weight = weight + people[j];
                    people[j] = 0;
                }
            }
            answer++;
        }
        return answer;
    }
}
