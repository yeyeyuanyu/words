package xyz.yyworker.words.myTest;

import de.siegmar.fastcsv.reader.CsvContainer;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.yyworker.words.automaticgenerated.dao.BookLexiconDao;
import xyz.yyworker.words.automaticgenerated.dao.LexiconDao;
import xyz.yyworker.words.automaticgenerated.entity.BookLexicon;
import xyz.yyworker.words.automaticgenerated.entity.Lexicon;

import javax.annotation.Resource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class FileTest {

    @Resource
    LexiconDao lexiconDao;
    @Resource
    BookLexiconDao bookLexiconDao;


    /**
     * 把cvs文档的的数据保存到数据库
     * @throws Exception
     */
    @Test
    public void testReadByCVS() throws IOException {
        String nativePath = "D:\\下载\\book\\zh";
        String nativePath2 = "";
        File file = new File(nativePath);
        final File[] f = file.listFiles();
        boolean toMax = false;
        List<BookLexicon> list = new ArrayList<>();
        int flag = 0;
        for (int i = 0; i < f.length; i++) {
            CsvReader csvReader = new CsvReader();
            CsvContainer csv = csvReader.read(f[i], StandardCharsets.UTF_8);
            BookLexicon bookLexicon;
            toMax = false;
            String name =f[i].getName();
            name = name.substring(0,name.length()-4);
            for (CsvRow row : csv.getRows()) {
                bookLexicon = new BookLexicon();
                bookLexicon.setBookName(name);
                bookLexicon.setWord(row.getField(0));
                list.add(bookLexicon);
                bookLexicon.setChineseParaphrase(row.getField(1));
                if (bookLexicon.getChineseParaphrase().length() >= 600){
                    list.clear();
                    System.out.println("跳过"+bookLexicon.getBookName());
                    toMax = true;
                    break;
                }
            }
            if (!toMax){
                //bookLexiconDao.insertOrUpdateBatch(list);
                System.out.println(f[i].getName()+"  "+list.size());
            }
            list.clear();
        }
    }
    @Test
    public void testReadByCVS2() throws IOException {
        String nativePath = "D:\\下载\\book\\english";
        File file = new File(nativePath);
        final File[] f = file.listFiles();
        int flag = 0;
        for (int i = 0; i < f.length; i++) {
            CsvReader csvReader = new CsvReader();
            CsvContainer csv = csvReader.read(f[i], StandardCharsets.UTF_8);
            String name =f[i].getName();
            name = name.substring(0,name.length()-4);
            for (CsvRow row : csv.getRows()) {
                if (row.getField(1).length() >= 600){
                    continue;
                }
                BookLexicon  bookLexicon = new BookLexicon();
                bookLexicon.setBookName(name);
                bookLexicon.setWord(row.getField(0));
                bookLexicon.setEnglishParaphrase(row.getField(1));
                //int rows = bookLexiconDao.updateByBooKNameAndWord(bookLexicon);
                //System.out.println(rows+"  "+bookLexicon.getWord());
            }
        }
    }

    /**
     * 文件重命名
     */
    public  void test2( ){
        String nativePath = "D:/单词库/";
        File file = new File(nativePath);
        String temp;
        final File[] files = file.listFiles();
        for (int i=0 ; i<files.length ; i++){
            System.out.println(files[i].getName());
            temp = files[i].getName();
            File fileDest = new File("D:/单词库/"+ temp.substring(1,2));
            files[i].renameTo(fileDest);
        }
    }

    /**
     * 把doc文档的的数据保存到数据库
     * @throws Exception
     */
    public void testReadByDoc() throws Exception {
        InputStream is = new FileInputStream("D:/单词库/142000.doc");
        HWPFDocument doc = new HWPFDocument(is);

        Range range = doc.getRange();
        // range信息
        //this.printInfo(range);
        int paraNum = range.numParagraphs();
        System.out.println("段落数为 ： " + paraNum);
        String temp;
        for (int i = 1; i < paraNum; i++) {
            temp = range.getParagraph(i).text();
            //System.out.println("段落" + (i + 1) + "内容为：" + temp);
            lexiconDao.insert(new Lexicon(temp.substring( 0 , temp.indexOf("=") ) ,"/voice/"+temp.substring(0,1).toUpperCase()+"/"+temp.substring( temp.lastIndexOf("\\")+1 ) ) );
        }
    }

}
