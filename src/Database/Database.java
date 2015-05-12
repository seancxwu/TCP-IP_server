package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database implements DataHandler{

    private final String password;
    private final String userName;
    private final String databaseName;
    private final Statement stmt = null;
    private final ResultSet rs = null;
    private PreparedStatement pstmt = null;

    public Database(String databaseName, String userName, String password) {

        this.databaseName = databaseName;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public void addGyroValueToDatabase(java.sql.Timestamp date, String name, String type, double x, double y, double z, String sessionId, String sensorId) {

        try {
            Connection c = setUpConnection();
            String query = "INSERT INTO gyro (time, sensorName, sensorType,xValue, yValue, zValue, Session_sessionId, Session_sensorId) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?,?)";
            pstmt = c.prepareStatement(query);
            pstmt.setTimestamp(1, date);
            pstmt.setString(2, name);
            pstmt.setString(3, type);
            pstmt.setDouble(4, x);
            pstmt.setDouble(5, y);
            pstmt.setDouble(6, z);
            pstmt.setString(7, sessionId);
            pstmt.setString(8, sensorId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
     public void addAccValueToDatabase(  java.sql.Timestamp date, String name, String type, double x, double y, double z, String sessionId, String sensorId) {

        try {
            Connection c = setUpConnection();
            String query = "INSERT INTO acc (time, sensorName, sensorType,xValue, yValue, zValue, Session_sessionId, Session_sensorId) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?,?)";
            pstmt = c.prepareStatement(query);
            
            pstmt.setTimestamp(1, date);
            pstmt.setString(2, name);
            pstmt.setString(3, type);
            pstmt.setDouble(4, x);
            pstmt.setDouble(5, y);
            pstmt.setDouble(6, z);
            pstmt.setString(7, sessionId);
            pstmt.setString(8, sensorId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void addBarValueToDatabase(java.sql.Timestamp date, String name, String type, double x,String sessionId, String sensorId) {

        try {
            Connection c = setUpConnection();
            String query = "INSERT INTO bar (time, sensorName, sensorType, pressure, Session_sessionId, Session_sensorId) "
                    + "VALUES (?, ?,?, ?, ?,?)";
            pstmt = c.prepareStatement(query);
            pstmt.setTimestamp(1, date);
            pstmt.setString(2, name);
            pstmt.setString(3, type);
            pstmt.setDouble(4, x);
            pstmt.setString(5, sessionId);
            pstmt.setString(6, sensorId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void addTempValueToDatabase(java.sql.Timestamp date, String name, String type, double x,String sessionId, String sensorId) {

        try {
            Connection c = setUpConnection();
            String query = "INSERT INTO temp (time, sensorName, sensorType, temperature, Session_sessionId, Session_sensorId) "
                    + "VALUES (?, ?,?, ?, ?,?)";
            pstmt = c.prepareStatement(query);
            pstmt.setTimestamp(1, date);
            pstmt.setString(2, name);
            pstmt.setString(3, type);
            pstmt.setDouble(4, x);
            pstmt.setString(5, sessionId);
            pstmt.setString(6, sensorId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

     @Override
    public void addSessionValueToDatabase(String id, java.sql.Timestamp date, String sensorId) {
        try {
            Connection c = setUpConnection();
            String query = "INSERT INTO session (sessionId, sessionTime, sensorId) "
                    + "VALUES (?, ?, ?)";
            pstmt = c.prepareStatement(query);
             pstmt.setString(1, id);
            pstmt.setTimestamp(2, date);
            pstmt.setString(3, sensorId);
           

            pstmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @Override
    public void addMagValueToDatabase(java.sql.Timestamp date, String name, String type, double x, double y, double z, String sessionId, String sensorId) {

        try {
            Connection c = setUpConnection();
            String query = "INSERT INTO mag (time, sensorName, sensorType,xValue, yValue, zValue, Session_sessionId, Session_sensorId) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?,?)";
            pstmt = c.prepareStatement(query);
            pstmt.setTimestamp(1, date);
            pstmt.setString(2, name);
            pstmt.setString(3, type);
            pstmt.setDouble(4, x);
            pstmt.setDouble(5, y);
            pstmt.setDouble(6, z);
            pstmt.setString(7, sessionId);
            pstmt.setString(8, sensorId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Connection setUpConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String URL = "jdbc:mysql://localhost:3306/" + databaseName + "?user=" + userName + "&password=" + password + "";
            Connection c = DriverManager.getConnection(URL);
            return c;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void addBattValueToDatabase(String name, int id, String type,java.sql.Date date, double x) {
        try {
            Connection c = setUpConnection();
            String query = "INSERT INTO Battery (sensorName, sessionId, sensorType,time,value) "
                    + "VALUES (?, ?, ?, ?, ?)";
            pstmt = c.prepareStatement(query);
             pstmt.setString(1, name);
            pstmt.setInt(2, id);
            pstmt.setString(3, type);
            pstmt.setDate(4,date);
            pstmt.setDouble(5, x);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

   

}
