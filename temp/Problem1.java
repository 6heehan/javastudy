package temp;

public class Problem1 {
    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        String[] deposits = {"01/01 2 50000", "01/03 1 999", "01/31 9 10000", "02/05 5 6547", "02/05 6 1", "06/30 5 5000", "10/15 5 2529", "12/30 4 10000"};
        problem1.solution(deposits);
    }

    public void solution(String[] deposits) {
        int answer= 0;
        int[] remainDays = {365,334,306,275,245,214,184,153,122,92,61,31};
        int[] principal = new int[deposits.length];
        int[] interest = new int[deposits.length];

        String[][] temp = new String[deposits.length][];
        for(int i=0; i< deposits.length; i++) {
            temp[i] = deposits[i].split(" ");
            String[] tempDay = temp[i][0].split("/");

            principal[i] = Integer.valueOf(temp[i][2]);
            interest[i] = (int)Math.floor(principal[i] * Integer.valueOf(temp[i][1]) / 100.0 * (remainDays[Integer.valueOf(tempDay[0])-1] - Integer.valueOf(tempDay[1])) / 365);
            answer = answer + principal[i] + interest[i];
        }
        
        System.out.println(answer);
    }
}
