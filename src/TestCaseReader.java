import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TestCaseReader {

    public static void main(String args[]) throws IOException {

        Algorithm algo = new Algorithm(new File("res/offlinetest.xlsx"),
                new File("res/"));

        Gui gui = new Gui("PDFnamer",new Dimension(800,350));
    }
}
