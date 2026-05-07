package oop.intro;

public class SprintLogApp {

    public static void main(String[] args) {

        LearningLog javalog = new LearningLog();
        javalog.titles = "Java 시작";
        javalog.minutes = 40;
        javalog.publicLog = true;

        LearningLog gitlog = new LearningLog();
        gitlog.titles = "Git 복습";
        gitlog.minutes = 40;
        gitlog.publicLog = false;

        LearningLog conditionLog = new LearningLog();
        conditionLog.titles = "조건문 학습";
        conditionLog.minutes = 75;
        conditionLog.publicLog = true;

        LearningLog loopLog = new LearningLog();
        loopLog.titles = "반복문 학습";
        loopLog.minutes = 120;
        loopLog.publicLog = true;

        LearningLog[] logs = {javalog, gitlog, conditionLog, loopLog};

        System.out.println("=== 학습 기록 ===");
        for (int i = 0; i < logs.length; i++) {
            logs[i].printSummary();
        }
        
        System.out.println();
        System.out.println("=== 복습 ===");
        for (LearningLog log : logs) {
            if (log.needReview()) {
            log.printSummary();
        }
        }
        
        System.out.println();
        System.out.println("=== 공개 ===");
        for (LearningLog log : logs) {
            if (!log.publicLog) {
                continue;
            }
            log.printSummary();
        }
    }
}
