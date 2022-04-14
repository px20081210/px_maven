import org.junit.Test;

import java.util.Scanner;

public class TestScanner {

    @Test
    public void TestScan(){
        System.out.println("请输入");
        int scanner = new Scanner(System.in).nextInt();
        System.out.println(scanner);
    }
}
