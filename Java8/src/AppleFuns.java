import java.util.ArrayList;
import java.util.List;

public class AppleFuns {
    //filter method by color
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result=new ArrayList<>();
        for(Apple apple:inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }
    //filter method by heavy
    public static List<Apple> filterHeavyApples(List<Apple> inventory){
        List<Apple> result=new ArrayList<>();
        for (Apple apple:inventory){
            if (apple.getWeight()>300){
                result.add(apple);
            }
        }
        return result;
    }
    //Judge by color
    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }
    //Judge by heavy
    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight()>300;
    }

    //Predicate<Apple> is more standard (and slightly more efficient because it avoids boxing a boolean into a Boolean).
    public  interface Predicate<T>{
        boolean test(T t);
    }
    static List<Apple> filterApples(List<Apple>inventory,Predicate<Apple> p){
        List<Apple>result =new ArrayList<>();
        for(Apple apple:inventory){
            if (p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    //Methods to lambdas (Only use once or twice)
    //filterApples(inventory,(Apple a)->"green".equals(a.getColor()));


}
