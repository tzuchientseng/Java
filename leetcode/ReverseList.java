import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import java.util.stream.Collectors; // method 3

public class ReverseList {    
    public static void main(String[] args) {
        {//Method 1
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            System.out.println("Original list: " + list);

            Collections.reverse(list);
            System.out.println("Reversed list: " + list);
        }


        {//Method 2
            List<Integer> originalList = new ArrayList<>();
            originalList.add(1);
            originalList.add(2);
            originalList.add(3);

            System.out.println("Original list: " + originalList);

            List<Integer> reversedList = new ArrayList<>();
            for (int i = 0; i < originalList.size(); i++) {
                reversedList.add(0, originalList.get(i));
            }
            System.out.println("Reversed list: " + reversedList);
        }
    
        {//Method 3
            List<Integer> originalList2 = new ArrayList<>();
            originalList2.add(1);
            originalList2.add(2);
            originalList2.add(3);
            System.out.println("Original list: " + originalList2);

            List<Integer> reversedList2 = originalList2.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), lst -> {
                    Collections.reverse(lst);
                    return lst;
                }));
        
            System.out.println("Reversed list: " + reversedList2);
        }   

        {//Method 4
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            System.out.println("Original List: " + list);
            Solution o = new Solution();
            List<Integer> reversedList = o.reverse(list);
            System.out.println("Reversed List: " + reversedList);
        }
    }
}
class Solution {
    public List<Integer> reverse(List<Integer> list) {
        Collections.reverse(list); // Utilize Collections utility method to reverse the list
        return list;
    }
}
