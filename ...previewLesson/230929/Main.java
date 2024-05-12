package foo;
import bar.Hello;
public class Main{
   public static void main(String[] args){
      Hello h = new Hello();     //Make the object
      String result = h.say("Sunny");  //fuction call
      System.out.println(result);   //print the result
      h.say();   //method calling(no return value)
 }
}