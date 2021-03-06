/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;

/**
 *
 * @author Luca Mantica
 */
public class Main {

    private static final SharedData sharedData = new SharedData();
    /**
     * @brief thread "DIN"
     *
     * @author Luca Mantica
     */
    private static final Thread th1 = new Thread(new ThSound("DIN", sharedData));

    /**
     * @brief thread "DON"
     *
     * @author Luca Mantica
     */
    private static final Thread th2 = new Thread(new ThSound("DON", sharedData));

    /**
     * @brief thread "DAN"
     *
     * @author Luca Mantica
     */
    private static final Thread th3 = new Thread(new ThSound("DAN", sharedData));

    private static final Thread thVis = new Thread(new ThVis(sharedData));

    /**
     * @throws java.io.IOException
     * @brief entry point
     * @param args command line arguments
     *
     * @author Luca Mantica
     */
    public static void main(String[] args) throws IOException {
        try {
            //avvio thread
            System.out.println("Started");

            th1.start();
            th2.start();
            th3.start();
            thVis.start();
            //interruzione thread
            System.in.read();

            th1.interrupt();
            th2.interrupt();
            th3.interrupt();
            

            th1.join();
            th2.join();
            th3.join();
            thVis.interrupt();
            thVis.join();
            System.out.println("Ended");
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
    }
}
