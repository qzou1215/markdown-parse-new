import static org.junit.Assert.*;
import org.junit.*;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testSpaceAfterParen() {
        String contents = "[title]( space-in-url.com)";
        List<String> expect = List.of("space-in-url.com");
        assertEquals(expect, MarkdownParse.getLinks(contents));
    }

    @Test
    public void testFile1() throws IOException {
        int len = 0;
        String contents = "";
        FileReader fr = new FileReader("/Users/zouqingtong/Documents/GitHub/markdown-parse-new/test-file.md");
        while((len = fr.read())!=-1){
            contents += (char) len;
        }
        fr.close();
        String[] arr = {"https://something.com", "some-page.html"};
        ArrayList<String> expect = new ArrayList<>();
        expect.add(arr[0]);
        expect.add(arr[1]);
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile2() throws IOException {
        int len = 0;
        String contents = "";
        FileReader fr = new FileReader("test-file2.md");
        while((len = fr.read())!=-1){
            contents += (char) len;
        }
        fr.close();
        String[] arr = {"https://something.com", "some-page.html"};
        ArrayList<String> expect = new ArrayList<>();
        expect.add(arr[0]);
        expect.add(arr[1]);
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile3() throws IOException {
        int len = 0;
        String contents = "";
        FileReader fr = new FileReader("test-file3.md");
        while((len = fr.read())!=-1){
            contents += (char) len;
        }
        fr.close();
        ArrayList<String> expect = new ArrayList<>();
        assertEquals(MarkdownParse.getLinks(contents), expect);

    }

    @Test
    public void testFile8() throws IOException {
        int len = 0;
        String contents = "";
        FileReader fr = new FileReader("test-file8.md");
        while((len = fr.read())!=-1){
            contents += (char) len;
        }
        fr.close();
        ArrayList<String> expect = new ArrayList<>();
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }
    
}
