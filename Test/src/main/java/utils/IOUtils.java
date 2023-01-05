
package utils;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import javax.swing.text.Document;
import javax.swing.text.BadLocationException;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Properties;
import java.io.File;
import org.slf4j.Logger;

public class IOUtils
{
    private static final Logger log;
    
    private IOUtils() {
    }
    
    public static File createDirectory(final String strBaseDirectoryName, final String strDirectoryName) {
        final File fBaseDirectory = new File(strBaseDirectoryName);
        File directory = null;
        if (fBaseDirectory.exists() && fBaseDirectory.isDirectory()) {
            directory = new File(fBaseDirectory.getAbsolutePath() + File.separator + strDirectoryName);
            if (!directory.exists()) {
                directory.mkdir();
            }
        }
        return directory;
    }
    
    public static Properties loadProperties(final String propertiesFile) {
        final Properties properties = new Properties();
        try (final FileInputStream fInputStream = new FileInputStream(propertiesFile)) {
            properties.load(fInputStream);
        }
        catch (IOException e) {
            IOUtils.log.error("Unable to read poperty file " + ExceptionUtil.stackTraceToString(e));
        }
        return properties;
    }
    
    public static Properties loadPropertiesFromXML(final String propertiesFile) {
        final Properties properties = new Properties();
        try {
            properties.loadFromXML(new FileInputStream(propertiesFile));
        }
        catch (IOException e) {
            IOUtils.log.error("Unable to read property file " + ExceptionUtil.stackTraceToString(e));
        }
        return properties;
    }
    
    public static List<String> readTextLinesInFile(final String fileName) {
        final List<String> textLinesInFile = new ArrayList<String>();
        if (fileName != null && fileName.length() > 0) {
            final File filetoBeRead = new File(fileName);
            if (!filetoBeRead.exists()) {
                IOUtils.log.error("The file " + fileName + " can not be found. ");
            }
            try (final BufferedReader reader = new BufferedReader(new FileReader(filetoBeRead))) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    if (line.trim().length() > 0) {
                        textLinesInFile.add(line);
                    }
                }
            }
            catch (IOException ex) {
                IOUtils.log.error("Unable to read file " + filetoBeRead + " " + ExceptionUtil.stackTraceToString(ex));
            }
        }
        return textLinesInFile;
    }
    
    public static String readRTFFile(final String strAbsoluteFilePath) {
        String strContent = null;
        try (final FileInputStream stream = new FileInputStream(strAbsoluteFilePath)) {
            final RTFEditorKit kit = new RTFEditorKit();
            final Document doc = kit.createDefaultDocument();
            kit.read(stream, doc, 0);
            strContent = doc.getText(0, doc.getLength());
        }
        catch (IOException | BadLocationException ex2) {
            final Exception ex = null;
            final Exception e = ex;
            IOUtils.log.error(ExceptionUtil.stackTraceToString(e));
        }
        return strContent;
    }
    
    public static String readPDFFile(final String strAbsoluteFilePath, final int nPageNumber) {
        if (!strAbsoluteFilePath.endsWith("pdf")) {
            throw new IllegalArgumentException("The specified file '" + strAbsoluteFilePath + "' is not a PDF file");
        }
        String strPageContent = "";
        try {
            final PdfReader pdfReader = new PdfReader(strAbsoluteFilePath);
            strPageContent = PdfTextExtractor.getTextFromPage(pdfReader, nPageNumber);
            pdfReader.close();
        }
        catch (IOException ex) {
            IOUtils.log.error("Unable to read pdf file " + strAbsoluteFilePath, (Throwable)ex);
        }
        return strPageContent;
    }
    
    static {
        log = LoggerFactory.getLogger((Class)IOUtils.class);
    }
}
