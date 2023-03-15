package imagefileio;

/**
 * ImageFileIO with Excel and PGM.
 * This is the main class.
 * DO NOT MODIFY THE GIVEN main() METHOD!
 * 
 *** STUDENTS SHOULD CUSTOMIZE METHOD prepareSID() TO PREPARE YOUR OWN sid.pgm
 * 
 * @author pffung
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
 */
public class ImageFileIO {
    
    /**
     * Prepare student's own SID in "sid.pgm"
     * This method should not declare "throws Exception"
     */
    public static void prepareSID() // NO throws Exception here!!
    {
        try
        {
            PGM sid;        
            PGM digit;
            
            // STUDENTS SHOULD CUSTOMIZE THIS METHOD TO PREPARE YOUR OWN sid.pgm

            // read and copy first digit
            digit = new PGM();
            digit.read("digit1.pgm");
            sid = new PGM(digit);

            // read and stack with next digit
            digit = new PGM();
            digit.read("digit1.pgm");
            sid.stackWith(digit);
            digit = new PGM();
            digit.read("digit5.pgm");
            sid.stackWith(digit);
            digit = new PGM();
            digit.read("digit5.pgm");
            sid.stackWith(digit);
            digit = new PGM();
            digit.read("digit1.pgm");
            sid.stackWith(digit);
            digit = new PGM();
            digit.read("digit6.pgm");
            sid.stackWith(digit);
            digit = new PGM();
            digit.read("digit5.pgm");
            sid.stackWith(digit);
            digit.read("digit2.pgm");
            sid.stackWith(digit);
            digit.read("digit1.pgm");
            sid.stackWith(digit);
            digit.read("digit1.pgm");
            sid.stackWith(digit);

            sid.write("sid.pgm");
        }
        // GIVEN catch block as a learning example, DO NOT MODIFY
        catch (Exception exceptionObject)
        {
            System.out.println(exceptionObject.getMessage());
        }
    }
    
    /**
     * ImageFileIO main method
     * @param args is an array of command line arguments
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception
    {
        
        /** DO NOT MODIFY THE GIVEN main() METHOD! */
        
        /**
         * Before you FINISH another class PGM.java PROPERLY,
         * there may be errors and warnings in main() and prepareSID() methods.
         */
                
        PGM img1 = new PGM();
        // you may ignore the warning about text block conversion
        img1.setPixels(4, 2, "127\t255\t255\t127\n" + "255\t0\t0\t255\n");
        System.out.println("*** Demonstrate use of getter methods ***");
        System.out.println("img1 of size " + img1.getWidth() + "x" + img1.getHeight() + ":");
        System.out.println(img1.getPixels());
        img1.write("Gray_4by2.pgm");
        img1.screenShow();

        PGM img2 = new PGM();
        // you may ignore the warning about text block conversion
        img2.setPixels(4, 2, "0\t70\t180\t0\n" + "255\t190\t80\t255\n");
        img2.stackWith(img1);
        img2.stackWith(img1);
        System.out.println("*** Demonstrate use of stackWith() ***");
        System.out.println("img2 of size " + img2.getWidth() + "x" + img2.getHeight() + ":");
        System.out.println(img2.getPixels());
        img2.write("Gray_4by6.pgm");
        img2.screenShow();
        
        System.out.println("*** Demonstrate use of read() and write() ***");
        System.out.println("    Generate Excel Tab-delimited Text file");
        System.out.println("    Show that some PGM formatted files are compatible to .tab");
        PGM img3 = new PGM();
        img3.read("digit0.pgm");
        img3.write("digit0.tab");
        img3.screenShow();
        
        System.out.println("*** Demonstrate use of invert() ***");
        PGM dong = new PGM();
        dong.read("DongDong.pgm");
        dong.invert().write("DongDong_inv.pgm");
        System.out.println();
        
        System.out.println("*** Send message to student's prepareSID() ***");
        prepareSID();
        
        /** DO NOT MODIFY THE GIVEN main() METHOD! */
    }    
}
