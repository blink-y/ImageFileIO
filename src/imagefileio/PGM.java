package imagefileio;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Class PGM of app ImageFileIO.
 * 
 *** STUDENTS SHOULD FINISH THIS CLASS PROPERLY TO MAKE ImageFileIO WORK!
 *** All methods in class PGM do NOT handle, but just declare "throws Exception".
 * 
 * CSCI1130 Java Assignment 4 ImageFileIO
 *
 * Remark: Name your class, variables, methods, etc. properly. 
 * You should write comment for your work and follow good styles.
 *
 * I declare that the assignment here submitted is original except for source
 * material explicitly acknowledged, and that the same or closely related
 * material has not been previously submitted for another course. I also
 * acknowledge that I am aware of University policy and regulations on honesty
 * in academic work, and of the disciplinary guidelines and procedures
 * applicable to breaches of such policy and regulations, as contained in the
 * website.
 *
 * University Guideline on Academic Honesty:
 *     http://www.cuhk.edu.hk/policy/academichonesty
 * Faculty of Engineering Guidelines to Academic Honesty:
 *     https://www.erg.cuhk.edu.hk/erg/AcademicHonesty
 *
 * Section     : CSCI1130A
 * Student Name: MITUL Mohammad Abdullah Al Mukit
 * Student ID  : 1155165211
 * Date        : 7/11/2022
 *
 * Reference: https://en.wikipedia.org/wiki/Netpbm#PGM_example
 * Assumption: this assignment DOES NOT handle #comment in PGM image files
 * Tool: https://kylepaulsen.com/stuff/NetpbmViewer/
 */
public class PGM {
    
    /** all field are private */
    private int width, height, maxValue;
    private String pixels;

    /**
     * Default constructor takes no parameters.
     * Initializes this new object with width 0, height 0, maxValue 255
     * and empty String "" in pixels
     */
        /*** Students' work here ***/
    public PGM(){
        width = 0;
        height = 0;
        maxValue =0;
        pixels = "";
    
    }


    /**
     * Constructor that "clones" an existing PGM object
     * Copies ALL fields from given img to this new object using assignment statements.
     * @param img is an existing PGM object
     */
        /*** Students' work here ***/
    public PGM(PGM img){
        this.height = img.height;
        this.width = img.width;
        this.maxValue = img.maxValue;
        this.pixels = img.pixels;
        
    }


    /**
     * Read from a PGM File using Scanner.
     * 1. Create a new File object and then a new Scanner object
     * 2. Read first token using Scanner object's next() method to get header
     * 3. If header is not equal to "P2", throw new Exception("Invalid header");
     * 4. Read following three integers as width, height and maxValue
     * 5. Read many pixel value lines AND concatenate all lines (plus newlines) as one single pixels String
     * 6. Close the Scanner object
     * @param filename is an existing ASCII file containing an image in PGM format
     * @throws Exception 
     */
    public void read(String filename) throws Exception
    {
        /*** Students' work here ***/
        File f = new File(filename);
        Scanner scnr = new Scanner(f);
        String header = scnr.next();
        if (header.equals("P2\n")){
           throw new Exception("Invalid Header");   
        }
        
        width = Integer.parseInt(scnr.next());
        height = Integer.parseInt(scnr.next());
        maxValue = Integer.parseInt(scnr.next());
        scnr.nextLine();
        pixels = scnr.nextLine()+'\n';
        while(scnr.hasNextLine()){
            pixels = pixels + scnr.nextLine()+'\n';
        }
        scnr.close();
        
        System.out.println("Read " + filename + " with header " + header + " of image size " + width + "x" + height);
    }

    /**
     * Write to a PGM file using PrintStream.
     * 1. Declare and initialize a String header with content "P2"
     * 2. Create a PrintStream object with given filename
     * 3. Write header, width, height, maxValue through the PrintStream object
     * 4. Write the pixels (a String with many lines of pixel values)
     * 5. Close the PrintStream object
     * @param filename is a file to be created/ overwritten in working folder
     * @throws Exception 
     */
    public void write(String filename) throws Exception
    {
        /*** Students' work here ***/
       String header = "P2";
       PrintStream prnt = new PrintStream(new File(filename));
       prnt.append(header).append('\n');
       prnt.append(Integer.toString(width)).append('\t').append(Integer.toString(height)).append('\n');
       prnt.append(Integer.toString(maxValue)).append('\n');
       prnt.append(pixels);
       prnt.close();
        System.out.println("Wrote " + filename + " with header " + header + " of image size " + width + "x" + height);
    }
    
    /**
     * getWidth() method
     * @return width is an int
     */
        /*** Students' work here ***/
    public int getWidth(){
        return width;
    }

    
    /**
     * getHeight() method
     * @return height is an int
     */
        /*** Students' work here ***/
    public int getHeight(){
        return height;
    }

    
    /**
     * getPixels() method
     * @return pixels String that is immutable
     */
    public String getPixels()
    {
        return pixels;
    }

    /**
     * setPixels replaces content in this PGM image with given width, height and pixels
     * @param int newWidth
     * @param int newHeight
     * @param String newPixels
     * @return type is void
     */
        /*** Students' work here ***/
        public void setPixels(int newWidth, int newHeight, String newPixels)
    {
        this.width = newWidth; 
        this.height = newHeight;
        this.pixels = newPixels;
    }


    /**
     * Stack this image on top of another image, keeping result in this image.
     * Both source images should have the same width; otherwise return without action.
     * Resultant image has the same width as that of both source images.
     * Height of resultant image is the sum of the height of both source images.
     * Pixels in resultant image is the concatenated result of the source pixel Strings.
     * @param img is another image that is copied and unaffected.
     */
    public void stackWith(PGM img)
    {
        /*** Students' work here ***/
        if(this.width==img.width){
            String newPixels = this.pixels+ img.pixels ;
            this.setPixels(width, this.height+img.height, newPixels);

        }
  
    }
    
    /**
     * Invert this image and return a new resultant image.
     * Refer to the technique demonstrated in given method screenShow().
     * Use maxValue to invert each and every extracted pixel value.
     * Use new StringBuilder object to rebuild a new pixels String efficiently.
     * Separate the resultant pixel values by tabs and newlines.
     * @return a new PGM that represents the inverted image of the source
     */
    public PGM invert()
    {
        /*** Students' work here ***/
        PGM newone = new PGM(this);
        Scanner values = new Scanner(this.pixels);
        String pixel_new="";
        StringBuilder b= new StringBuilder(pixel_new);
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++){
                b.append(Integer.toString(this.maxValue-values.nextInt()));  
                b.append('\t');
            }
            b.append('\n');
        }
        newone.setPixels(width, height, b.toString());
        return newone;
    }
    
    /**
     * Display this PGM as pixel values on screen for inspection and debugging.
     * Demonstrate how to use Scanner to parse pixel values in a String
     * in order to perform screen formatting.
     */
    public void screenShow()
    {
        System.out.println("Screen show of image size " + width + "x" + height + ":");
        Scanner values = new Scanner(pixels);
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++)
                System.out.printf("%4d", values.nextInt());
            System.out.println();
            System.out.println();
        }
    }
}
