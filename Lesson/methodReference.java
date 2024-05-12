public class methodReference {
    public static void main(String[] args) {
        System.out.println(running(methodReference::add, 5, 10));
        System.out.println(running(methodReference::mul, 5, 10));
    }

    public static int add(int x, int y) {
        return x + y;
    }

    public static int mul(int x, int y) {
        return x * y;
    }

    public static int running(MyFunctionalInterface func, int arg1, int arg2) {
        return func.operation(arg1, arg2);
    }

    interface MyFunctionalInterface {
        int operation(int arg1, int arg2);
    }
}
/*
    在這個Java程式碼中：

    我們定義了一個Main類別，其中包含一個main方法。
    我們定義了add和mul方法，分別執行加法和乘法運算。
    我們定義了一個running方法，該方法接受一個函數介面（MyFunctionalInterface），允許將函數作為參數傳遞。
    在running方法內部，我們呼叫函數介面的operation方法，並傳遞提供的參數。
    在main方法中，我們使用方法引用（Main::add和Main::mul）將add和mul方法的引用作為參數傳遞給running方法。
    最後，我們列印出執行加法和乘法運算的結果。
    
    Main::add 是 Java 中的方法引用（Method Reference）語法。它提供了一種簡潔的方式來引用現有方法作為 lambda 運算式的替代。在這裡，Main::add 引用了 Main 類別中的 add 方法。

    Java 中的方法引用有幾種不同的類型，包括：

    靜態方法引用（Static Method Reference）：ClassName::methodName，例如 Main::add。
    實例方法引用（Instance Method Reference）：instance::methodName，例如 str::length，其中 str 是一個字串物件。
    類別任意型態的實例方法引用（Class Type Arbitrary Instance Method Reference）：ClassName::methodName，例如 String::compareToIgnoreCase。
    建構子引用（Constructor Reference）：ClassName::new，例如 ArrayList::new。
    在這個例子中，Main::add 是靜態方法引用，它指的是 Main 類別中的 add 方法。當你傳遞 Main::add 給一個接受函數接口的方法時，它將被解釋為一個接受兩個整數參數並返回整數的函數。

 */

/*  python
    def add(x, y):
        return x + y

    def mul(x, y):
        return x * y

    def running(func, arg1, arg2):
        return func(arg1, arg2)

    print(running(add, 5, 10))
    print(running(mul, 5, 10))
*/

