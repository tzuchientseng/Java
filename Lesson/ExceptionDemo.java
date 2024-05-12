public class ExceptionDemo{
        public static void main(String[] args)throws Exception{
            Candidate c = new Candidate("James", 20);
            Candidate c1 = new Candidate("Williams", 32);
            System.out.println(c);
            System.out.println(c1);
    }
}

class MissingInfoException extends Exception{}

class AgeoutofRangeException extends Exception{}

class Candidate {
    String name;
    int age;
    Candidate(String name, int age) throws Exception{
        if(name == null){
            throw new MissingInfoException();
        }else if(age <= 10 || age >= 150){
            throw new AgeoutofRangeException();
        }else {
            this.name = name;
            this.age  = age;
        } 
    }
}