package javastudy.assignment.week1;

public class assginment1 {
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

        for( int i = statValue ; i <= endValue ; i++ ) {
            if(name1 == i) {
                nameCount++;
                nameInt1 = i;
            } else if(name2 == i) {
                nameCount++;
                nameInt2 = i;
            } else if(name3 == i) {
                nameCount++;
                nameInt3 = i;
            }

            if(nameCount == 3)
                    break;
        }
        System.out.printf("%#X , %#X , %#X\n", nameInt1, nameInt2, nameInt3);
    }
}

