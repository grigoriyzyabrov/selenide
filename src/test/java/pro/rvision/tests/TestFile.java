package pro.rvision.tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static org.assertj.core.api.Assertions.assertThat;

public class TestFile {

    @Test
    void fileParsing() throws Exception {
        ZipFile zipFile = new ZipFile("src/test/resources/List.zip");

        //pdf
        ZipEntry zipEntryPDF = zipFile.getEntry("List.pdf");
        try (InputStream inputStreamPDF = zipFile.getInputStream(zipEntryPDF)) {
            PDF parsed = new PDF(inputStreamPDF);
            assertThat(parsed.text).contains("Krecks");
        }

        //csv
        ZipEntry zipEntryCSV = zipFile.getEntry("List.csv");
        try (InputStream inputStreamCSV = zipFile.getInputStream(zipEntryCSV)) {
            CSVReader reader = new CSVReader(new InputStreamReader(inputStreamCSV));
            List<String[]> list = reader.readAll();
            assertThat(list)
                    .hasSize(3)
                    .contains(
                            new String[] {"1", "Krecks"},
                            new String[] {"2", "Pecks"},
                            new String[] {"3", "Fecks"}

                            );

        //xlsx
        ZipEntry zipEntryXLSX = zipFile.getEntry("List.xlsx");
        try (InputStream inputStreamXLSX = zipFile.getInputStream(zipEntryXLSX)) {
            XLS parsed = new XLS(inputStreamXLSX);
            assertThat(parsed.excel.getSheetAt(0).getRow(0).getCell(0).getNumericCellValue())
                    .isEqualTo(1.0);
        }
    }

}
}
