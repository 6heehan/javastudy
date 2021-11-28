package assignment.week1;

public class Assginment1 {
    public static void main(String[] args) {
        char name1 = '한';
        char name2 = '준';
        char name3 = '희';

        char statValue = Character.MIN_VALUE;
        char endValue = Character.MAX_VALUE;
        //char koStart = '\uAC00';
        //char koEnd = '\uD7AF';
        
        int nameCount = 0;
        int nameInt1 = 0;
        int nameInt2 = 0;
        int nameInt3 = 0;

        //이름에 같은 글자가 있는 경우를 대비해 모두 if 문으로 조건 검색
        for( int i = statValue ; i <= endValue ; i++ ) {
            if(name1 == i) {
                nameCount++;
                nameInt1 = i;
            }
            if(name2 == i) {
                nameCount++;
                nameInt2 = i;
            }
            if(name3 == i) {
                nameCount++;
                nameInt3 = i;
            }
            if(nameCount == 3)
                    break;
        }
        System.out.printf("%#X , %#X , %#X\n", nameInt1, nameInt2, nameInt3);
    }
}

