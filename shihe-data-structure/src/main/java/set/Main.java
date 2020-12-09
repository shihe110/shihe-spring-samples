package set;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Main
 * @Description TODO
 * @Author admin
 * @Date 2020-12-09 10:23
 * @Version 1.0
 */
public class Main {
    private static double testSet(Set<String> set, ArrayList<String> words){
        long startTime = System.nanoTime();
        for (String word : words) {
            set.add(word);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;

    }
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        FileUtil.readFile("F:\\shihe-spring-samples\\shihe-data-structure\\src\\main\\java\\set\\pride-and-prejudice.txt", words);
        System.out.println("Total words "+words.size());

        System.out.println("-------------");
        Set<String> link = new LinkedListSet<>();
        double v = testSet(link, words);
        System.out.println("LinkedListSet total time "+v);

        System.out.println("-------------");
        BSTSet<String> bst = new BSTSet<>();
        double v1 = testSet(bst, words);
        System.out.println("BST total time "+v1);
    }
}
