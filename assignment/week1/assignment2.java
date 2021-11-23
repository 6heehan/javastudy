package assignment.week1;

import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("[메뉴선택]");
        System.out.println("1. 회원 관리");
        System.out.println("2. 과목 관리");
        System.out.println("3. 수강 관리");
        System.out.println("4. 결제 관리");
        System.out.println("5. 종료");
        
        int menu = 0;

        while(menu != 5) {
            menu = scanner.nextInt();
            if(menu == 1) {
                System.out.println("회원 관리 메뉴를 선택했습니다.");
            } else if(menu == 2) {
                System.out.println("과목 관리 메뉴를 선택했습니다.");
            } else if(menu == 3) {
                System.out.println("수강 관리 메뉴를 선택했습니다.");
            } else if(menu == 4) {
                System.out.println("결제 관리 메뉴를 선택했습니다.");
            } else if(menu == 5) {
                System.out.println("프로그램을 종료합니다.");
            } else {
                System.out.println("유효하지 않은 메뉴 번호입니다.");
                System.out.println("[메뉴선택]");
                System.out.println("1. 회원 관리");
                System.out.println("2. 과목 관리");
                System.out.println("3. 수강 관리");
                System.out.println("4. 결제 관리");
                System.out.println("5. 종료");
            }
        }
        scanner.close();
        //scanner 사용 후 close 필요 warning 발생
    }
}