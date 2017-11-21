import java.io.IOException;

/**
 * Created by inocer on 11/20/17.
 */
public class TestMain {
    public static void main(String[] args) {
        DruidDataService d = new DruidDataService();
        try {
            d.whenPostJsonUsingHttpClient_thenCorrect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
