
package demowarcraft;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;

/**
 *
 * @author Vladyslav Shynal
 */
public class Logger {

    private static Logger Instance;
    private String fileName;
    private PrintStream printstream;
    
    public static Logger getInstance() {
        if (Instance == null) {
            Instance = new Logger();
        }
        return Instance;
    }

    private Logger() {
        fileName = new SimpleDateFormat("'GameLog'_yyyy.MM.dd_HHmmss'.log'").format(new Date());
        try {
        	printstream = new PrintStream(fileName);
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(Logger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getFileName() {
        return fileName;
    }
    
    public void writeToFile(String str) {
    	printstream.println(str);
    }
    
    public void close() {
    	printstream.close();
    }
}
