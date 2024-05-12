package foo;
public class Main {
 public static void main(String[] args){
 Animal a = new Tiger();
 a.eat();
 Cat b = new Tiger();
 b.eat();
 b.jump();
 System.out.println(b.getLeg());
 Tiger c = new Tiger();
 c.eat();
 c.jump();
 System.out.println(c.getLeg());
 Cat d = new Leo();
 d.eat();
 d.jump();
 System.out.println(d.getLeg());
 Cat e = new Cat();
 e.eat();
 e.jump();
 System.out.println(e.getLeg());
 }
}
class Animal {
 public void eat(){
 System.out.println("Animal Eat");
 }
}
class Cat extends Animal {
 protected int leg = 4;
 public Cat(){
 System.out.println("Cat Created");
 }
 public void eat(){
 System.out.println("Cat Eat");
 }
 public void jump(){
 System.out.println("Cat Jump");
 }
 public int getLeg(){
 return this.leg;
 }
}
class Tiger extends Cat {
 private int leg = 5;
 public void eat(){
 System.out.println("Tiger Eat");
 }
 public int getLeg(){
 return this.leg;
 }
}
class Leo extends Cat {
 public Leo(){
 System.out.println("Leo Created");
 }
 public int getLeg(){
 return super.leg;
 }
}