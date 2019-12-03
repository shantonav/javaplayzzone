package test.com.solutions;

import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import com.googlecode.jcsv.reader.internal.DefaultCSVEntryParser;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class TestCSVReadAndParse {

    @Test
    public void testDirectDebitCSVParseAndRead() throws IOException {
        Reader reader = new FileReader("/home/vagrant/projects/javaplayzzone/src/main/resources/direct-debit.csv");
        CSVReaderBuilder<String[]> csvReaderBuilder = new CSVReaderBuilder<String[]>(reader);
        CSVReader<String[]> csvParser = csvReaderBuilder.strategy(CSVStrategy.UK_DEFAULT)
                                                .entryParser(new DefaultCSVEntryParser())
                                                .build();

        List<String[]> data = csvParser.readAll();

        System.out.println(data);
    }
}
