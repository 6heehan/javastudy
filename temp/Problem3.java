package temp;

public class Problem3 {
    public static void main(String[] args) {
    
        int s1 = 21;
        int s2 = 31;

        Solution3 problem3 = new Solution3();
        problem3.solution(s1, s2);

    }
}

class Solution3 {

    public int[] solution(int s1, int s2) {
        int[] answer = {};
        String string1 = Integer.toString(s1);
        String string2 = Integer.toString(s2);
        
        int[] count1 = new int[7];
        int[] count2 = new int[7];
        //max answer 1,000,000

        //FIX ME
        for(int i = 0; i < string1.length(); i++ ) {
            if(i % 2 == 0) {
                int tempValue = string1.charAt(i);
                for(int j = 0; j < string1.charAt(i+1); j++) {
                    count1[j] = tempValue;
                }
            }
        }

        for(int i = 0; i < string2.length(); i++ ) {
            if(i % 2 == 0) {
                int tempValue = string2.charAt(i);
                for(int j = 0; j < string2.charAt(2); j++) {
                    count2[j] = tempValue;
                }
            }
        }

        //hashset 저장 -> 중복 값 제외
        //treeset -> 값에 따라 정렬

        for(int a : answer) {
            System.out.println(a);
        }
        
        return answer;
    }
}