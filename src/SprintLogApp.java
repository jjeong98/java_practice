import java.util.Scanner;

public class SprintLogApp {

    public static void main(String[] args) {
        String[] titles = {"Java 시작", "Git 복습", "조건문 학습", "반복문 학습"};
        int[] minutes = {40, 30, 75, 120};
        boolean[] publicFlags = {true, false, true, true};

        Scanner sc = new Scanner(System.in);

        // 무한 루프 / 무조건 참;
        while (true) {
            printMenu();
            int menu = sc.nextInt();

            if(menu == 1){
                printAllLogs(titles, minutes);
            }
            else if(menu == 2){
                printPublicLogs(titles, publicFlags, minutes);
            }
            else if(menu == 3){
                int total = calculateTotalMins(minutes);
                System.out.println(total + "mins");
            }
            else if(menu == 4){
                printReminder(titles, minutes);
            }
            else if (menu == 5) {
                printLongStudyLogs(titles, minutes);
            }
            else if(menu == 0){
                System.out.println("Close");
                break;
            }

        }
    }

    static void printLongStudyLogs(String[] titles, int[] minutes) {
        printDivider("긴 학습");
        for (int i = 0; i < titles.length; i++) {
            if (minutes[i] >100) {
                printLogitem(i, titles, minutes);
            }
        }
    }

    static void printReminder(String[] titles, int[] minutes) {
        printDivider("복습");
        for (int i = 0; i < titles.length; i++) {
            if (minutes[i] < 60) {
                printLogitem(i, titles, minutes);
            }
        }
        int total = calculateTotalMins(minutes);
        double avg = (double) total / minutes.length;
        System.out.println("Avg: " + avg +"mins");
    }

    static int calculateTotalMins(int[] minutes) {
        int total = 0;
        for (int m: minutes) {
            total += m;
        }
        return total;
    }

    static void printPublicLogs(String[] titles, boolean[] publicFlags, int[] minutes) {
        printDivider("공개");
        for (int i = 0; i < titles.length; i++) {
            if (!publicFlags[i]) {
                continue;
            }
            printLogitem(i, titles, minutes);
        }
    }

    static void printAllLogs(String[] titles, int[] minutes) {
        printDivider("전체");

        for (int i = 0; i < titles.length; i++) {
            printLogitem(i, titles, minutes);
        }
    }

    static void printLogitem(int i, String[] titles, int[] minutes) {
        System.out.println((i + 1) + ". " + titles[i] + "- " + minutes[i] + "mins");
    }

    // 메서드 이름 앞에는 메서드가 반환하는 값의 타입을 작성이 기본.
    // 리턴 값이 없는 경우는 'void'.
    static void printMenu () {
        System.out.println();
        System.out.println("==== SprintLog ====");
        System.out.println("1. 전체 기록 출력");
        System.out.println("2. 공개 기록만 출력");
        System.out.println("3. 전체 학습 시간 출력");
        System.out.println("4. 복습 필요 기록 출력");
        System.out.println("5. 긴 학습 기록 출력");
        System.out.println("0. 종료");
        System.out.print("메뉴를 선택하세요: ");
    }
    
    static void printDivider(String title) {
        System.out.println("========= " + title + "=========");
    }
    
}