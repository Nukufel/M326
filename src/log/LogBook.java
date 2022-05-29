package log;

import java.io.*;
import java.util.Vector;

public class LogBook {
    private Vector<String> entries = new Vector<>();
    static LogBook instance;
    private File file;
    private BufferedReader reader;
    private BufferedWriter writer;
    private boolean fileWritingEnabled = false;

    /**
     * Construktor
     * Creates a File for the LogBook, a BufferedReader and a BufferedWriter
     * @throws IOException
     */
    private LogBook() {
        File f = new File("logbook.log");
        try {
            if (f.createNewFile() == false) {
                reader = new BufferedReader(new FileReader(f));
                readFile();
                reader.close();
            }
            writer = new BufferedWriter(new FileWriter(f, true));
            fileWritingEnabled = true;
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @return
     * @throws IOException
     */
    public static LogBook getLogBookInstance() throws IOException {
        if(instance == null){
            instance = new LogBook();
        }
        return instance;
    }


    /**
     * This method is called when sth. is done and the it writs the changes in to the file.
     * @param entry
     * @throws IOException
     */
    public void addEntry(String entry) throws IOException {
        if(fileWritingEnabled == true){
            writeFile(entry);
        }
        entries.add(entry);

    }

    /**
     * Returns an entry from a position
     * @param index
     * @return String at the position of index from the Vector entries
     */
    public String  getEntry(int index){
        return entries.get(index);
    }

    /**
     * How many entries are in the Vector
     * @return the size of the Vector enries
     */
    public int getSize(){
        return entries.size();
    }

    /**
     * Closes the LogBook, so you can't write in it anymore
     * @throws IOException
     */
    public void LogBookClose() throws IOException {
        writer.close();
    }

    /**
     * prints out the LogBook
     */
    public void printLog(){
        for (String entry : entries) {
            System.out.println(entry);
        }
    }

    /**
     * Writs all entries in a file (appending)
     * @param entry
     * @throws IOException
     */
    public void writeFile(String entry) throws IOException {
        writer.append(entry);
        writer.newLine();
        writer.flush();
    }

    /**
     * reads out the File
     * @throws IOException
     */
    public void readFile() throws IOException {
        while(reader.ready() == true){
            entries.add(reader.readLine());
        }
    }
}

