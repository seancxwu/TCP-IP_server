/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpip.server;

import Database.DataHandler;
import Database.Database;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author krille0x7c2
 */
public class ConnectionHandler implements Runnable {

    private final Socket socket;
    private DataOutputStream output;
    private DataInputStream input;
    private final int tag;
    private final RawData rawData;

    public ConnectionHandler(Socket socket, int tag, RawData rawData) {
        this.socket = socket;
        this.tag = tag;
        this.rawData = rawData;
    }

    @Override
    public void run() {
        try {
            output = new DataOutputStream(socket.getOutputStream());
            input = new DataInputStream(socket.getInputStream());
            DataHandler dbh = new Database("altimu", "root", "root");

            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            Timestamp sqlTimestamp = new java.sql.Timestamp(utilDate.getTime());

            try {

                switch (tag) {
                    case 0://Thread 0(mobile)
                        byte[] buffer = new byte[6];

                        System.out.println("Enter the name of a Session:");
                        Scanner in = new Scanner(System.in);
                        String session = in.nextLine();

                        System.out.println("Connected, you are number " + tag);
                        System.out.println("What will you send to matlab?");
                        System.out.println("1: Batt/N/A");
                        System.out.println("2: Temp");
                        System.out.println("3: Acc");
                        System.out.println("4: Mag");
                        System.out.println("5: Gyro");
                        System.out.println("6: Bar");
                        System.out.println("7: All/N/A");
                        Scanner sc = new Scanner(System.in);
                        rawData.setGlobal_select(sc.nextInt());
                        System.out.println(rawData.getGlobal_select());
                        boolean se = true;

                        while (true) {
                            switch (input.read()) {
                                case 1://Accelerometar
                                    input.readFully(buffer, 0, 6);
                                    rawData.setXh(buffer[0]);
                                    rawData.setXl(buffer[1]);
                                    rawData.setYh(buffer[2]);
                                    rawData.setYl(buffer[3]);
                                    rawData.setZh(buffer[4]);
                                    rawData.setZl(buffer[5]);

//                                    Thread.sleep(100);
                                    //  if (se){
                                    //   dbh.addSessionValueToDatabase(session, sqlTimestamp, "1");
                                    //  se = false;
                                    //  }
                                    //dbh.addAccValueToDatabase(sqlTimestamp, "Accelerometer", "LSM303D", rawData.getX16(), rawData.getY16(), rawData.getZ16(), session, "1");
                                    System.out.println(new java.sql.Timestamp(utilDate.getTime()).toString());
                                    break;
                                case 2://Magnetometar
                                    input.readFully(buffer, 0, 6);
                                    rawData.setXh(buffer[0]);
                                    rawData.setXl(buffer[1]);
                                    rawData.setYh(buffer[2]);
                                    rawData.setYl(buffer[3]);
                                    rawData.setZh(buffer[4]);
                                    rawData.setZl(buffer[5]);
//                                    Thread.sleep(100);
                                    if (se) {
                                        dbh.addSessionValueToDatabase(session, sqlTimestamp, "2");
                                        se = false;
                                    }
                                    dbh.addMagValueToDatabase(sqlTimestamp, "Magnetometar", "LSM303D", rawData.getX16(), rawData.getY16(), rawData.getZ16(), session, "2");
                                    System.out.println(rawData.getX16());
                                    System.out.println(rawData.getY16());
                                    System.out.println(rawData.getZ16());
                                    break;
                                case 3://Gyro
                                    input.readFully(buffer, 0, 6);
                                    rawData.setXh(buffer[0]);
                                    rawData.setXl(buffer[1]);
                                    rawData.setYh(buffer[2]);
                                    rawData.setYl(buffer[3]);
                                    rawData.setZh(buffer[4]);
                                    rawData.setZl(buffer[5]);
//                                    Thread.sleep(100);
                                      if (se) {
                                        dbh.addSessionValueToDatabase(session, sqlTimestamp, "3");
                                        se = false;
                                    }
                                    dbh.addGyroValueToDatabase(sqlTimestamp, "Gyroscope", "L3GD20H", rawData.getX16(), rawData.getY16(), rawData.getZ16(), session, "3");
                                    System.out.println(sqlDate.toString());
                                    break;
                                case 4://Bar
                                    input.readFully(buffer, 0, 3);
                                    rawData.setLow(buffer[0]);
                                    rawData.setMiddle(buffer[1]);
                                    rawData.setHigh(buffer[2]);
                                      if (se) {
                                        dbh.addSessionValueToDatabase(session, sqlTimestamp, "4");
                                        se = false;
                                    }
                                     dbh.addBarValueToDatabase(sqlTimestamp, "Barometer", "LPS25H", rawData.getBar(),session, "4");
                                    System.out.println("bar " + rawData.getBar());
//                                    Thread.sleep(100);
                                    break;
                                case 5://Temp
                                    input.readFully(buffer, 0, 2);
                                    rawData.setLow(buffer[0]);
                                    rawData.setHigh(buffer[1]);
                                    double gay = rawData.getTemp() / 480 + 42.5;
                                     if (se) {
                                        dbh.addSessionValueToDatabase(session, sqlTimestamp, "5");
                                        se = false;
                                    }
                                    dbh.addTempValueToDatabase(sqlTimestamp, "Temperature", "LPS25H", rawData.getBar(),session, "5");
                                    System.out.println("Temp" + gay);
//                                    Thread.sleep(100);
                                    break;
                                case 6://Batt
                                    input.readFully(buffer, 0, 1);
                                    rawData.setLow(buffer[0]);
                                    //dbh.addBattValueToDatabase("Battery", 3, "unknown", sqlDate, rawData.getLow());
                                    System.out.println("battery: " + rawData.getLow());
//                                    Thread.sleep(100);
                                    break;

                                default:
                                    System.out.println("No value");

                            }

                        }
                    case 1://Thread 1 (matlab)
                        System.out.println("Connected, you are number " + tag);
                        while (true) {
                            switch (rawData.getGlobal_select()) {
                                case 1:
                                    output.write(rawData.getLow());
                                    Thread.sleep(50);
                                    break;
                                case 2:
                                    output.write(rawData.getHigh());
                                    output.write(rawData.getLow());
                                    Thread.sleep(50);
                                    break;
                                case 3:
                                case 4:
                                case 5:
                                    output.write(rawData.getX16());
                                    output.write(rawData.getY16());
                                    output.write(rawData.getZ16());
                                    Thread.sleep(50);
                                    break;
                                case 6:
                                    output.write(rawData.getHigh());
                                    output.write(rawData.getMiddle());
                                    output.write(rawData.getLow());
                                    Thread.sleep(50);
                                    break;
                                case 7:
                                    break;
                                default:
                                    System.out.println(rawData.getGlobal_select());
                            }

                        }
                    default:
                        System.out.println("Only two connections, you are number " + tag + " Piss off!");
                        break;
                }

            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
