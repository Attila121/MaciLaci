/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package macilaci;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Mielec Attila (MNZVUM)
 */
public class DataBase {
    PreparedStatement insertStatement;
    Connection connection;
    
    public DataBase() throws SQLException
    {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "root");
        connectionProps.put("serverTimezone", "UTC");
        String dbURL = "jdbc:mysql://localhost:3306/maci";
        connection = DriverManager.getConnection(dbURL, connectionProps);
        
        
        String insertQuery = "INSERT INTO MACI.EREDMENY (NEV, IDO, PONT) VALUES (?, ?, ?)";
        insertStatement = connection.prepareStatement(insertQuery);
    }
    
    
    public ArrayList<Result> getResults() throws SQLException {
        ArrayList<Result> res = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet results = stmt.executeQuery("SELECT * FROM EREDMENY ORDER BY pont DESC, ido ASC, nev ASC LIMIT 10");
        while (results.next()) {
            String nev = results.getString("nev");
            double ido = results.getDouble("ido");
            int pont = results.getInt("pont");
            res.add(new Result(nev, ido, pont));
        }
        return res;
    }
    
    
    public void insertScore(String nev, double ido, int pont) throws SQLException {
        insertStatement.setString(1, nev);
        insertStatement.setDouble(2, ido);
        insertStatement.setInt(3, pont);
        insertStatement.executeUpdate();
    }
}
