package HW.Account;


public class Main2 {
    public static void main(String[] args){
        User[] u = {
            new User("11","123"),
            new User("22","123"),
            new User("33","333"),
            new User("44","444"),
            new User("55","555")
        };


        var id = args[0] ;
        var password = args[1]; 
        var isLogin = false;

        for(var uu:u){
            if(uu.id().equals(id)&&uu.password().equals(password)){
                System.out.println("Login success");
                isLogin = true;
            }
        }
        if(!isLogin){
            System.out.println("Login fail");
        }
    }
}

record User(String id, String password){}





