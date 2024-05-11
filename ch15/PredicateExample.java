package ch15;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        PredicateExample sample = new PredicateExample();

        Predicate<String> predicateLength5 = (a) -> a.length() > 5;
        Predicate<String> predicateContians = (a) -> a.contains("God");
        Predicate<String> predicateStart = (a) -> a.startsWith("God");

        String godOfJava = "GodOfJava";
        String goodJava = "GoodJava";

        // 데이터가 해당 조건에 맞는지 확인
        sample.predicateTest(predicateLength5, godOfJava);
        sample.predicateTest(predicateLength5, goodJava);

        // 데이터가 조건과 다른지 확인
        sample.predicateNegate(predicateLength5, godOfJava);
        sample.predicateNegate(predicateLength5, goodJava);

        // 데이터가 두 개의 조건에 모두 맞는지 확인
        sample.predicateAnd(predicateLength5, predicateStart, godOfJava);
        sample.predicateAnd(predicateLength5, predicateContians, goodJava);

        // 데이터가 두 개의 조건 중 하나라도 맞는지 확인
        sample.predicateOr(predicateLength5, predicateStart, godOfJava);
        sample.predicateOr(predicateLength5, predicateStart, goodJava);
    }

    private void predicateTest(Predicate<String> p, String data) {
        System.out.println(p.test(data));
    }

    private void predicateNegate(Predicate<String> p, String data) {
        System.out.println(p.negate().test(data));
    }

    private void predicateAnd(Predicate<String> p1, Predicate<String> p2, String data) {
        System.out.println(p1.and(p2).test(data));
    }

    private void predicateOr(Predicate<String> p1, Predicate<String> p2, String data) {
        System.out.println(p1.or(p2).test(data));
    }
}
