package test.com.solutions;

import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class TestCSVReadAndParse {

    @Test
    public void testDirectDebitCSVParseAndRead() throws IOException {
        Reader reader = new FileReader("/home/vagrant/projects/javaplayzzone/src/main/resources/direct-debit.csv");

        CSVReader csvParser = CSVReaderBuilder.newDefaultReader(reader);
        List data = csvParser.readAll();

        System.out.println(data);
    }
}
