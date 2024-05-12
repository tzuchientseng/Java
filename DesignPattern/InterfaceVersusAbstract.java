/*
1.類別是對物件的抽象; 抽象類別是對類別的抽象; 介面(像合約,插座...)是對行為的抽象
2.行為跨越不同的物件,可使用介面;對於一些像似的類別物件,用繼承抽象類別
3.從設計角度講,抽象類別是從子類別中發現了公共的東西,泛化出父類別,而介面不曉得子類別的存在,方法如何實現還不確認,預先定義
 */
package DesignPattern;

public class InterfaceVersusAbstract {
    public static void main (String[] args) {
       MachineCat mcat = new MachineCat("Doraemon");
       StoneMonkey wukong = new StoneMonkey("Son Goku");

       IChange[] array = new IChange[2];
       array[0] = mcat;
       array[1] = wukong;

        System.out.println(array[0].changeThing("do a magic."));
        System.out.println(array[1].changeThing("do a magic."));
    }
}

abstract class Animal {
    protected String name;
    protected int shoutNum;

    public Animal() {
        this.name = "";
        this.shoutNum = 1; // Default shoutNum
    }

    public Animal(String name) {
        this.name = name;
        this.shoutNum = 1;
    }

    public String shout() {
        return "";
    }

    public String getName() {
        return this.name;
    }
}

class Cat extends Animal {
    public Cat() {
        super();
    }

    public Cat(String name) {
        super(name);
    }

    @Override
    public String shout() {
        String result = "";
        for (int i = 0; i < this.shoutNum; i++) {
            result += "Meow";
        }
        return "My name is " + name + " " + result;
    }
}

class Dog extends Animal {
    public Dog() {
        super();
    }

    public Dog(String name) {
        super(name);
    }

    @Override
    public String shout() {
        String result = "";
        for (int i = 0; i < this.shoutNum; i++) {
            result += "Wow";
        }
        return "My name is " + name + " " + result;
    }
}
interface IChange {
    String changeThing(String thing);
}

class MachineCat extends Cat implements IChange {
    public MachineCat() {
        super();
    }

    public MachineCat(String name) {
        super(name);
    }

    @Override
    public String changeThing(String thing) {
        return "Changing " + thing;
    }
}

class StoneMonkey extends Animal implements IChange {
    public StoneMonkey() {
        super();
    }

    public StoneMonkey(String name) {
        super(name);
    }

    @Override
    public String changeThing(String thing) {
        return "Transforming " + thing;
    }

    @Override
    public String shout() {
        String result = "";
        for (int i = 0; i < this.shoutNum; i++) {
            result += "Woof";
        }
        return "My name is " + name + " " + result;
    }
}
