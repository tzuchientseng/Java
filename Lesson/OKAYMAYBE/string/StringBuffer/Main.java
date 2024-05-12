package string.StringBuffer;

public class Main {
// StringBufferExample
    public static void main(String[] args) {
        // 創建一個空的 StringBuffer
        StringBuffer stringBuffer = new StringBuffer();

        // 模擬大量的字串操作
        for (int i = 0; i < 10000; i++) {
            stringBuffer.append("String" + i + " "); // 連接字串並追加到 StringBuffer
        }

        // 在追加完所有字串後，將 StringBuffer 轉換為不可變的 String
        String result = stringBuffer.toString();

        // 輸出結果
        System.out.println(result);
    }
}
