package oop.stream.quiz;

import javax.naming.Name;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = List.of(
                new Transaction(brian, 2021, 300),
                new Transaction(raoul, 2022, 1000),
                new Transaction(raoul, 2021, 400),
                new Transaction(mario, 2021, 710),
                new Transaction(mario, 2022, 700),
                new Transaction(alan, 2022, 950)
        );

        // 연습 1: 2021년에 발생한 모든 거래를 찾아 거래액 오름차 정렬(작은 값에서 큰 값).
        List<Transaction> tr2021 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2021 )
                .sorted(Comparator.comparing(transaction -> transaction.getValue()))
                .toList();
        tr2021.forEach(System.out::println);
                

        // 연습 2: 거래자가 근무하는 모든 도시이름을 중복 없이 나열하시오.
        List<String> cities =transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .toList();
        cities.forEach(System.out::println);

        // 연습 3: Cambridge에 근무하는 모든 거래자(Trader)를 찾아
        // 거래자 리스트로 이름순으로 오름차 정렬.
        List<Trader> cam = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .toList();
        cam.forEach(System.out::println);
        
        // 연습 4: 모든 거래자의 이름을 리스트에 모아서
        // 알파벳순으로 오름차 정렬하여 반환

        List<String> allTraders = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .sorted()
                .distinct()
                .toList();
        allTraders.forEach(System.out::println);

        // 연습 5: Milan에 거주하는 거래자가 한명이라도 있는지 여부 확인?
        boolean milano = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println("milanoPerson = " + milano);

        // 연습 6: Cambridge에 사는 거래자의 모든 거래액의 총합 출력.
        Optional<Integer> sumInCam = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(transaction -> transaction.getValue())
                .reduce(Integer::sum);
        System.out.println("sumInCam = " + sumInCam.orElse(0));
        
        int sumInCam2 = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .mapToInt(transaction -> transaction.getValue())
                .sum();
        System.out.println("sumInCam2 = " + sumInCam2);

        // 연습 7: 모든 거래에서 최고거래액은 얼마인가?
        int maxValue = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max()
                .orElse(0);
        System.out.println("maxValue = " + maxValue);
        
        Optional<Integer> maxValue2 = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo);
        System.out.println("maxValue2 = " + maxValue2.get());
        
        

        // 연습 8. 가장 작은 거래액을 가진 거래정보 탐색
        Optional<Transaction> minValue = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println("minValue = " + minValue.get());
        
        // 연습 9. 거래액이 500 이상인 거래들만 필터링하고,
        // 해당 거래의 정보를 출력하시오.
        List<Transaction> fivehundred = transactions.stream()
                .filter(transaction -> transaction.getValue() >= 500)
                .sorted(Comparator.comparing(transaction -> transaction.getTrader().getName()))
                .toList();
        fivehundred.forEach(System.out::println);


        // 연습 10. 모든 거래에서 가장 작은 거래액보다
        // 큰 거래액을 가진 거래의 평균을 계산하시오.
        // 출력값: 752.0
        int min = transactions.stream()
                .mapToInt(Transaction::getValue)
                .min()
                .orElse(0);
        
        OptionalDouble avg = transactions.stream()
                        .mapToInt(Transaction::getValue)
                .filter(value -> value > min)
                        .average();
        System.out.println("avg = " + avg.getAsDouble());
        


        System.out.println("=============================================");

        // 연습 11. "Cambridge"에서 거래하는 모든 거래자의 거래 정보를 연도별로 그룹화해서
        // 출력하세요.
        

        /*
        Year: 2021
        {Trader: Brian in Cambridge, year: 2021, value: 300}
        {Trader: Raoul in Cambridge, year: 2021, value: 400}
        ...

        Year: 2022
        {Trader: Raoul in Cambridge, year: 2022, value: 1000}
        ...
        */

        // key: 거래연도, value: 거래내역을 담은 리스트
        Map<Integer, List<Transaction>> groupByYearMap = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .collect(Collectors.groupingBy(Transaction::getYear));
        groupByYearMap.forEach((year, transactionList) -> {
            System.out.println("year :" + year);
            transactionList.forEach(System.out::println);
        });
        
        HashMap<Integer, List<Transaction>> groupByYearMap2 = new HashMap<>(
                transactions.stream()
                        .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                        .collect(Collectors.groupingBy(Transaction::getYear)));
        groupByYearMap2.forEach((year, transactionList) -> {
            System.out.println("year :" + year);
            transactionList.forEach(System.out::println);
        });

    }

}

