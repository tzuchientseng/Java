public class LogicDemo{
    public static void main(String[] args){
        var o  = new User();
        var logic = new UserLogic();
        logic.process(o);
        System.out.println(o.i);
    }
}   

class UserLogic{    //logic put here
    public void process(User u){
        u.i  = 10;
    }

}

class User{ //data put here
    public int i;    
}