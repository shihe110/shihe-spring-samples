package map;

import set.Set;

import java.util.ArrayList;

/**
 * @ClassName Main
 * @Description TODO
 * @Author admin
 * @Date 2020-12-09 13:45
 * @Version 1.0
 */
public class Main {
    private static double testMap(Map<String, Integer> map, ArrayList<String> words){
        long startTime = System.nanoTime();

        for (String word : words) {
            if (map.contains(word)){
                map.set(word, map.get(word) + 1);
            }
            map.add(word, 1);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;

    }
    public static void main(String[] args) {

        BSTMap<String, Integer> bstMap = new BSTMap<>();
        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();

        ArrayList<String> words = new ArrayList<>();
        FileUtil.readFile("F:\\shihe-spring-samples\\shihe-data-structure\\src\\main\\java\\map\\pride-and-prejudice.txt",words);

        System.out.println("bstMap time " + testMap(bstMap, words));
        System.out.println("linkedlistMap time " + testMap(linkedListMap, words));

    }
}
