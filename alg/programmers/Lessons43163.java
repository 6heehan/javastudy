package alg.programmers;

public class Lessons43163 {
    boolean[] isVisited = {};
    public static void main(String[] args) {
        System.out.println("단어변환");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/43163");

        String begin1 = "hit";
        String target1 = "cog";
        String[] words1 = {"hot","dot","dog","lot","log","cog"};

        // String begin2 = "hit";
        // String target2 = "cog";
        // String[] words2 = {"hot","dot","dog","lot","log"};

        Lessons43163 problem = new Lessons43163();
        problem.solution(begin1, target1, words1);
        //solution(begin2, target2, words2);

    }

    public  int solution(String begin, String target, String[] words) {
        int answer = 0;
        isVisited = new boolean[words.length];
        answer = dfsAll(words, begin, target);
        System.out.println(answer);
        return answer;
    }

    public  int dfsAll(String[] words, String begin, String target) {
        int count = 0;
        for(int i=0;i<words.length;i++) {
            if(isPossible(begin, words[i], isVisited[i])) count = dfs( words, i, 1, target);
        }
        return count;
    }
    public  int dfs( String[] words, int index, int count, String target) {
        isVisited[index] = true;
        if(target.equals(words[index])) return count;
        for(int i=0;i<words.length;i++) {
            if(isPossible(words[index], words[i], isVisited[i])) count = dfs( words, i, count+1, target);
        }
        isVisited[index] = false;
        return count;
    }
    public  boolean isPossible(String currentWord, String words, boolean isVisited) {
        if(isVisited) return false;
        int count = 0;
        for(int j=0; j<currentWord.length();j++) {
            if(currentWord.charAt(j) == words.charAt(j)) count++;
        }
        if(count==2) return true;
        return false;
    }
}
