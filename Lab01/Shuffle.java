/*
* Mahdeen Ahmed Khan Sameer
* 
* CS231
*/

// In Python, we have to do it by using "x" and in Java, it's like /** X 

// The java.util library contains standard data types, algorithms, and capabilities. 

/* 

import java.util.ArrayList;
import java.util.Random;

public class Shuffle {
    public static void main(String[] args) {
        ArrayList<Integer> arr0 = new ArrayList<Integer>();
        Random ran = new Random();
        for (int i = 0; i < 10; i++) {
            int val = ran.nextInt(100);
            arr0.add(val);
            System.out.println(val);
        }
        
//I tried to do it with Python too so that I can visualize better
         * arr0 = []
         * ran = random.Random()
         * for i in range(10):
         * val = ran.randint(0, 100)
         * arr0.append(val)
         * print(val)
        

        int i = 5; // specify the index you want to get the value from
        Integer x = arr0.get(i);
        System.out.println("Value at index " + i + ": " + x);

        // Python Version
        
         * i = 5
         * x = arr0[i]
         * print("Value at index {}: {}".format(i, x))
        

        ArrayList<Integer> arr1 = new ArrayList<>(arr0);
        ArrayList<Integer> arr2 = arr0;

        System.out.println("arr0:" + arr0);
        System.out.println("arr1:" + arr2);
        System.out.println("arr2:" + arr2);

        System.out.println("arr0 == arr1: " + (arr0 == arr1) + "\narr1 == arr2: " + (arr1 == arr2) + "\narr2 == arr0: "
                + (arr2 == arr0));
        System.out.println("arr0.equals(arr1): " + (arr0.equals(arr1)) + "\narr1.equals(arr2): " + (arr1.equals(arr2))
                + "\narr2.equals(arr0): " + (arr2.equals(arr0)));
    }
//In Java, == operator compares if two variables refer to the same object in memory. The equals method is used to compare if two objects have the same content. In the code, arr0, arr1, and arr2 are different objects in memory, even though they have the same content, therefore == operator returns false for arr0 == arr1 and arr1 == arr2. However, arr2 was assigned a reference to arr0, so arr2 == arr0 returns true. As for equals, it checks if two objects have the same content, so arr0.equals(arr1), arr1.equals(arr2), and arr2.equals(arr0) all return true.
}


//In Python, "==" checks for equality in terms of object identity, not content equality. In the code, we are creating two new lists arr1 and arr2 with the same contents as arr0, but they are different objects in memory, so arr0 == arr1 and arr0 == arr2 will return False.

/*
 * import java.util.ArrayList;
 * import java.util.Random;
 * 
 * public class Shuffle {
 * public static void main(String[] args) {
 * ArrayList<Integer> arr0 = new ArrayList<Integer>();
 * Random ran = new Random();
 * for (int i = 0; i < 10; i++) {
 * int val = ran.nextInt(100);
 * arr0.add(val);
 * System.out.println(val);
 * }
 * 
 * for (int i = 0; i < 10; i++) {
 * int index = ran.nextInt(arr0.size());
 * int removedValue = arr0.remove(index);
 * System.out.print("Removed value: " + removedValue + "; Remaining values: ");
 * System.out.println(arr0);
 * }
 * }
 * }
 */

import java.util.ArrayList;
import java.util.Random;

public class Shuffle {
    public static void main(String[] args) {
        ArrayList<Integer> arr0 = new ArrayList<Integer>();
        Random ran = new Random();
        for (int i = 0; i < 10; i++) {
            int val = ran.nextInt(100);
            arr0.add(val);
            System.out.println(val);
        }

        int i = 5;
        Integer x = arr0.get(i);
        System.out.println("Value at index " + i + ": " + x);

        ArrayList<Integer> arr1 = new ArrayList<>(arr0);
        ArrayList<Integer> arr2 = arr0;

        System.out.println("arr0:" + arr0);
        System.out.println("arr1:" + arr2);
        System.out.println("arr2:" + arr2);

        System.out.println("arr0 == arr1: " + (arr0 == arr1) + "\narr1 == arr2: " + (arr1 == arr2) + "\narr2 == arr0: "
                + (arr2 == arr0));
        System.out.println("arr0.equals(arr1): " + (arr0.equals(arr1)) + "\narr1.equals(arr2): " + (arr1.equals(arr2))
                + "\narr2.equals(arr0): " + (arr2.equals(arr0)));

        for (int j = 0; j < 10; j++) {
            int index = ran.nextInt(arr0.size());
            int removedValue = arr0.remove(index);
            System.out.print("Removed value: " + removedValue + "; Remaining values: ");
            System.out.println(arr0);
        }
    }
}