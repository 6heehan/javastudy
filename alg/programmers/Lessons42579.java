package alg.programmers;
import java.util.*;

public class Lessons42579 {
    public static void main(String[] args) {

        System.out.println("베스트앨범");
        System.out.println("https://programmers.co.kr/learn/courses/30/lessons/42579");

        Lessons42579 problem = new Lessons42579();
        //["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
        problem.solution(new String[]{"classic","pop","classic", "classic","pop"} , new int[]{500,600,150,800,2500});
    }

    static class Music{
        String genre;
        int play;
        int idx;

        public Music(String genre, int play, int idx) {
            this.genre = genre;
            this.play = play;
            this.idx = idx;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<String> genres_ord = new ArrayList<>();
        while(map.size() != 0) {
            int max = -1;
            String maxKey = "";
            for(String key: map.keySet()) {
                int tmpCnt = map.get(key);
                if(tmpCnt > max) {
                    max = tmpCnt;
                    maxKey = key;
                }
            }
            genres_ord.add(maxKey);
            map.remove(maxKey);
        }

        ArrayList<Music> result = new ArrayList<>();
        for(String genre : genres_ord) {
            ArrayList<Music> list = new ArrayList<>();
            for(int i=0; i<genres.length; i++) {
                if(genres[i].equals(genre)) {
                    list.add(new Music(genre, plays[i], i));
                }
            }
            Collections.sort(list, (o1, o2) -> o2.play - o1.play);
            result.add(list.get(0));
            if(list.size() != 1) {
                result.add(list.get(1));
            }
        }

        int[] answer = new int[result.size()];
        for(int i=0; i< result.size(); i++) {
            answer[i] = result.get(i).idx;
        }
        for(int i : answer) {
            System.out.println(i);
        }
        return answer;
    }
}