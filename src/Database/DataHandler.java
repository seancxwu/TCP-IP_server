/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author krille0x7c2
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;

public interface DataHandler {
    public Connection setUpConnection();
    public void addMagValueToDatabase(Timestamp date, String name,String type, double x, double y, double z,String sessionId, String sensorId);
    public void addTempValueToDatabase(Timestamp date, String name,String type, double x, String sessionId, String sensorId);
    public void addBarValueToDatabase(Timestamp date, String name,String type, double x, String sessionId, String sensorId);
     public void addAccValueToDatabase(Timestamp date, String name,String type, double x, double y, double z,String sessionId, String sensorId);
    public void addGyroValueToDatabase(Timestamp date, String name,String type, double x, double y, double z,String sessionId, String sensorId);
    public void addBattValueToDatabase(String name, int id, String type, Date date, double x);
    public void addSessionValueToDatabase(String id, Timestamp date, String sensorId);
    
}
