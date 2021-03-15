/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALEX
 */

public class DB_Connection {
    public static Connection connection;
    public static Statement statement;
    public static ResultSet result;
    public static ArrayList<String> Data = new ArrayList<>();
    public static ArrayList<Integer> DataInt = new ArrayList<>();
    
    public static void DB_Connection() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:HotelDB.db");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    
//    SELECT Reservations.Reservation_ID AS ReservationID, First_Name, Last_Name, DocumentID, Breeding_Type, Discount, Date_Reservation, Stay, Room_Price, Stay, Discount, Service_Price, Breeding_Price, SUM(((Room_Price * Stay) - (Discount/100 * (Room_Price * Stay))) + Service_Price + Breeding_Price) OVER (ORDER BY Reservations.Reservation_ID ROWS BETWEEN 1 PRECEDING AND CURRENT ROW) AS Total
//    FROM Reservations LEFT JOIN Clients ON Reservations.ClientID = Clients.ClientID LEFT JOIN Rooms_Reservations
//    ON Reservations.Reservation_ID = Rooms_Reservations.Reservation_ID JOIN Rooms
//    ON Rooms_Reservations.RoomID = Rooms.RoomID LEFT JOIN Breeding
//    ON Reservations.Breeding_ID = Breeding.Breeding_ID LEFT JOIN Services_Reservations
//    ON Reservations.Reservation_ID = Services_Reservations.Reservation_ID JOIN Services
//    ON Services_Reservations.ServiceID = Services.ServiceID LEFT JOIN Discounts
//    ON Reservations.DiscountID = Discounts.DiscountID LEFT JOIN Payment_Status
//    ON Reservations.ID_status = Payment_Status.ID_status
//    GROUP BY ReservationID
    
    

//    POSSIBLE QUERIES

//    --How many Reservations are PAID
//    SELECT COUNT(Reservation_ID) FROM Reservations
//    WHERE ID_status = '1'

//    --How many Reservations are NOT PAID
//    SELECT COUNT(Reservation_ID) FROM Reservations
//    WHERE ID_status = '2'
    
//    --How many Reservations have at least 1 PAID Room
//    SELECT COUNT(DISTINCT Reservation_ID) FROM Rooms_Reservations
//    WHERE ID_status = '1'

//    --How many Reservations have at least 1 NOT PAID Room
//    SELECT COUNT(DISTINCT Reservation_ID) FROM Rooms_Reservations
//    WHERE ID_status = '2'

//    --How many Rooms are PAID from Reservation '...'
//    SELECT COUNT(RoomID) FROM Rooms_Reservations
//    WHERE ID_status = '1' AND Reservation_ID = '4'
    
    public static ArrayList<String> select(String[] columns, String table) {
        DB_Connection();
        String sql = "SELECT ";
        for (int i = 0; i < columns.length; i++) {
            sql += columns[i] + ", ";
        }
        sql = sql.substring(0, sql.length() - 2);
        sql += " FROM " + table;
        System.out.println(sql);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                String row = "";
                for (int i = 0; i < columns.length; i++) {
                    row += result.getString(columns[i]) + "_";
                }
                row = row.substring(0, row.length() - 1);
                Data.add(row);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return Data;
    }
    
    public static ArrayList<String> selectOrderBy(String[] columns, String table, String orderColumn, String orderChoise) {
        DB_Connection();
        String sql = "SELECT ";
        for (int i = 0; i < columns.length; i++) {
            sql += columns[i] + ", ";
        }
        sql = sql.substring(0, sql.length() - 2);
        sql += " FROM " + table + " ORDER BY " + orderColumn + " " + orderChoise;
        System.out.println(sql);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                String row = "";
                for (int i = 0; i < columns.length; i++) {
                    row += result.getString(columns[i]) + "_";
                }
                row = row.substring(0, row.length() - 1);
                Data.add(row);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return Data;
    }
    
    public static ArrayList<String> selectWhere(String[] columnsArray, int[] whereColIndex, String[] whereValue, String table){
        DB_Connection();
        ArrayList<String> data = new ArrayList<String>();
        
        String columnsString = String.join(", ", columnsArray);
        
        String sql = "SELECT " + columnsString + " FROM " + table + " WHERE ";
            for (int i = 0; i < whereColIndex.length; i++) {
                sql += columnsArray[whereColIndex[i]] + " LIKE '%" + whereValue[i] + "%' OR ";
            }
        sql = sql.substring(0, sql.length() - 4);
        System.out.println(sql);
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next()){
                String row = "";
                for (int i = 0; i < columnsArray.length; i++) {
                    row += result.getString(columnsArray[i]) + "_";
                }
                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
    public static ArrayList<String> selectWhere2(String[] columnsArray, String[] whereColumn, String[] whereValue, String table){
        DB_Connection();
        ArrayList<String> data = new ArrayList<String>();
        
        String columnsString = String.join(", ", columnsArray);
        
        String sql = "SELECT " + columnsString + " FROM " + table + " WHERE ";
            for (int i = 0; i < whereColumn.length; i++) {
                sql += whereColumn[i] + " LIKE '%" + whereValue[i] + "%' OR ";
            }
        sql = sql.substring(0, sql.length() - 4);
        System.out.println(sql);
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next()){
                String row = "";
                for (int i = 0; i < columnsArray.length; i++) {
                    row += result.getString(columnsArray[i]) + "_";
                }
                row = row.substring(0, row.length() - 1);
                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
    
    public static ArrayList<String> selectWhere3(String[] columnsArray, String[] whereColumn, String[] whereValue, String table){
        DB_Connection();
        ArrayList<String> data = new ArrayList<String>();
        
        String columnsString = String.join(", ", columnsArray);
        
        String sql = "SELECT " + columnsString + " FROM " + table + " WHERE ";
            for (int i = 0; i < whereColumn.length; i++) {
                sql += whereColumn[i] + " = " + whereValue[i] + " OR ";
            }
        sql = sql.substring(0, sql.length() - 4);
        System.out.println(sql);
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next()){
                String row = "";
                for (int i = 0; i < columnsArray.length; i++) {
                    row += result.getString(columnsArray[i]) + "_";
                }
                row = row.substring(0, row.length() - 1);
                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
    
    public static ArrayList<String> selectWhere4(String[] columnsArray, String[] whereColumn, String[] whereValue, String table){
        DB_Connection();
        ArrayList<String> data = new ArrayList<String>();
        
        String columnsString = String.join(", ", columnsArray);
        
        String sql = "SELECT " + columnsString + " FROM " + table + " WHERE ";
            for (int i = 0; i < whereColumn.length; i++) {
                sql += whereColumn[i] + " = '" + whereValue[i] + "' OR ";
            }
        sql = sql.substring(0, sql.length() - 4);
        System.out.println(sql);
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next()){
                String row = "";
                for (int i = 0; i < columnsArray.length; i++) {
                    row += result.getString(columnsArray[i]) + "_";
                }
                row = row.substring(0, row.length() - 1);
                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
    
    public static ArrayList<String> selectWhereDouble(String[] columnsArray, String[] whereColumn, double[] whereValue, String table){
        DB_Connection();
        ArrayList<String> data = new ArrayList<String>();
        
        String columnsString = String.join(", ", columnsArray);
        
        String sql = "SELECT " + columnsString + " FROM " + table + " WHERE ";
            for (int i = 0; i < whereColumn.length; i++) {
                sql += whereColumn[i] + " = " + whereValue[i] + " OR ";
            }
        sql = sql.substring(0, sql.length() - 4);
        System.out.println(sql);
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
            while(result.next()){
                String row = "";
                for (int i = 0; i < columnsArray.length; i++) {
                    row += result.getString(columnsArray[i]) + "_";
                }
                row = row.substring(0, row.length() - 1);
                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
    
    public static ArrayList<Integer> selectCount(String column, String table) {
        DB_Connection();
        String count = "Count";
        String sql = "SELECT COUNT(" + column + ") AS " + count + " FROM " + table;
        System.out.println(sql);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                DataInt.add(result.getInt(count));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return DataInt;
    }
    
//    SELECT COUNT(Country) AS Count FROM Clients
//    GROUP BY Country
//    ORDER BY Count DESC
    
    public static ArrayList<String> selectGroupByOrderBy(String column, String table, String groupValue, String orderValue, String orderChoise) {
        DB_Connection();
        String sql = "SELECT " + column + " FROM " + table;
        sql += " GROUP BY " + groupValue + " ORDER BY " + orderValue + " " + orderChoise;
        System.out.println(sql);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                Data.add(result.getString(column));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return Data;
    }
    
    public static ArrayList<Integer> selectCountWhere(String column, String table, String[] whereColumn, String[] whereValue) {
        DB_Connection();
        String count = "Count";
        String sql = "SELECT COUNT(" + column + ") AS " + count + " FROM " + table + " WHERE ";
        for (int i = 0; i < whereColumn.length; i++) {
            sql += whereColumn[i] + " = '" + whereValue[i] + "' OR ";
        }
        sql = sql.substring(0, sql.length() - 4);
        System.out.println(sql);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                DataInt.add(result.getInt(count));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return DataInt;
    }
    
    public static ArrayList<Integer> selectCountWhereInt(String column, String table, String[] whereColumn, int[] whereValue) {
        DB_Connection();
        String count = "Count";
        String sql = "SELECT COUNT(" + column + ") AS " + count + " FROM " + table + " WHERE ";
        for (int i = 0; i < whereColumn.length; i++) {
            sql += whereColumn[i] + " = " + whereValue[i] + " OR ";
        }
        sql = sql.substring(0, sql.length() - 4);
        System.out.println(sql);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                DataInt.add(result.getInt(count));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return DataInt;
    }
    
//            SELECT Room_View FROM Rooms JOIN Rooms_Reservations
//            ON Rooms.RoomID=Rooms_Reservations.RoomID JOIN Reservations
//            ON Rooms_Reservations.Reservation_ID=Reservations.Reservation_ID
//            GROUP BY Room_View
//            ORDER BY COUNT(Reservations.Reservation_ID) DESC
    
    public static ArrayList<String> selectTopRoom_ViewJoin() {
        DB_Connection();
        String sql = "SELECT Room_View FROM Rooms JOIN Rooms_Reservations ";
        sql += "ON Rooms.RoomID = Rooms_Reservations.RoomID JOIN Reservations ";
        sql += "ON Rooms_Reservations.Reservation_ID=Reservations.Reservation_ID ";
        sql += "GROUP BY Room_View ";
        sql += "ORDER BY COUNT(Reservations.Reservation_ID) DESC";
        System.out.println(sql);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                Data.add(result.getString("Room_View"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return Data;
    }
    
//    SELECT Reservations.Reservation_ID AS ReservationID, First_Name, Last_Name, DocumentID, Breeding_Type, Discount, Date_Reservation, Stay, SUM(((Room_Price * Stay) - (Discount/100 * (Room_Price * Stay))) + Service_Price + Breeding_Price) OVER (ORDER BY Reservations.Reservation_ID ROWS BETWEEN 1 PRECEDING AND CURRENT ROW) AS Total, Paid
//    FROM Reservations JOIN Clients ON Reservations.ClientID = Clients.ClientID JOIN Rooms_Reservations
//    ON Reservations.Reservation_ID = Rooms_Reservations.Reservation_ID JOIN Rooms
//    ON Rooms_Reservations.RoomID = Rooms.RoomID JOIN Breeding
//    ON Reservations.Breeding_ID = Breeding.Breeding_ID JOIN Services_Reservations
//    ON Reservations.Reservation_ID = Services_Reservations.Reservation_ID JOIN Services
//    ON Services_Reservations.ServiceID = Services.ServiceID JOIN Discounts
//    ON Reservations.DiscountID = Discounts.DiscountID JOIN Payment_Status
//    ON Reservations.ID_status = Payment_Status.ID_status
//    GROUP BY ReservationID
    
    public static ArrayList<String> selectReservationsJoin() {
        DB_Connection();
        String sql = "SELECT Reservations.Reservation_ID AS ReservationID, First_Name, Last_Name, DocumentID, Breeding_Type, Discount, Date_Reservation, Stay, SUM(((Room_Price * Stay) - (Discount/100 * (Room_Price * Stay))) + Breeding_Price + (SELECT SUM(Service_Price) FROM Services JOIN Services_Reservations\n" + "ON Services.ServiceID = Services_Reservations.ServiceID JOIN Reservations\n" + "ON Services_Reservations.Reservation_ID = Reservations.Reservation_ID)) AS Total, Paid\n" +
"FROM Reservations JOIN Clients ON Reservations.ClientID = Clients.ClientID JOIN Rooms_Reservations\n" +
"ON Reservations.Reservation_ID = Rooms_Reservations.Reservation_ID JOIN Rooms\n" +
"ON Rooms_Reservations.RoomID = Rooms.RoomID JOIN Breeding\n" +
"ON Reservations.Breeding_ID = Breeding.Breeding_ID JOIN Discounts\n" +
"ON Reservations.DiscountID = Discounts.DiscountID JOIN Payment_Status\n" +
"ON Reservations.ID_status = Payment_Status.ID_status\n" +
"GROUP BY ReservationID";
        System.out.println(sql);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                Data.add(result.getString("ReservationID") + "_" +
                         result.getString("First_Name") + "_" +
                         result.getString("Last_Name") + "_" +
                         result.getString("DocumentID") + "_" +
                         result.getString("Breeding_Type") + "_" +
                         result.getString("Discount") +  "_" +
                         result.getString("Date_Reservation") + "_" +
                         result.getString("Stay") + "_" +
                         result.getString("Total") + "_" +
                         result.getString("Paid"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return Data;
    }
    
    public static ArrayList<String> selectWhereReservationsClientJoin(String[] whereValue) {
        DB_Connection();
        String sql = "SELECT Reservations.Reservation_ID AS ReservationID, First_Name, Last_Name, DocumentID, Breeding_Type, Discount, Date_Reservation, Stay, SUM(((Room_Price * Stay) - (Discount/100 * (Room_Price * Stay))) + Service_Price + Breeding_Price) AS Total, Paid\n";
        sql += "FROM Reservations JOIN Clients ON Reservations.ClientID = Clients.ClientID JOIN Rooms_Reservations\n";
        sql += "ON Reservations.Reservation_ID = Rooms_Reservations.Reservation_ID  JOIN Rooms\n";
        sql += "ON Rooms_Reservations.RoomID = Rooms.RoomID  JOIN Breeding\n";
        sql += "ON Reservations.Breeding_ID = Breeding.Breeding_ID JOIN Services_Reservations\n";
        sql += "ON Reservations.Reservation_ID = Services_Reservations.Reservation_ID  JOIN Services\n";
        sql += "ON Services_Reservations.ServiceID = Services.ServiceID JOIN Discounts\n";
        sql += "ON Reservations.DiscountID = Discounts.DiscountID  JOIN Payment_Status\n";
        sql += "ON Reservations.ID_status = Payment_Status.ID_status WHERE ";
//        String space0 = "";
//        String space1 = "";
        String space2 = "";
        for (int i = 0; i < whereValue.length; i++) {
//            sql += "First_Name || " + "'" + (space0 += " ") + "'" + " LIKE '%" + whereValue[i] + "%' OR " + "'" + (space1 += " ") + "'" + " || Last_Name LIKE '%" + whereValue[i] + "%' OR ";
            sql += "First_Name || " + "'" + (space2 += " ") + "'" + " || Last_Name LIKE '%" + whereValue[i] + "%' OR ";
//            sql += "'" + (space3 += " ") + "'" + " || First_Name LIKE '%" + whereValue[i] + "%' OR Last_Name || " + "'" + (space4 += " ") + "'" + " LIKE '%" + whereValue[i] + "%' OR ";
//            sql += "'" + (space4 += " ") + "'" + " || First_Name || " + "'" + (space5 += " ") + "'" + " || Last_Name || " + "'" + (space6 += " ") + "'" + " LIKE '%" + whereValue[i] + "%' OR ";
        }
        sql = sql.substring(0, sql.length() - 4);
        sql += "\nGROUP BY ReservationID";
        System.out.println(sql);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                Data.add(result.getString("ReservationID") + "_" +
                         result.getString("First_Name") + "_" +
                         result.getString("Last_Name") + "_" +
                         result.getString("DocumentID") + "_" +
                         result.getString("Breeding_Type") + "_" +
                         result.getString("Discount") +  "_" +
                         result.getString("Date_Reservation") + "_" +
                         result.getString("Stay") + "_" +
                         result.getString("Total") + "_" +
                         result.getString("Paid"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return Data;
    }
    
    public static ArrayList<String> selectWhereReservationsDocIDJoin(String[] whereValue) {
        DB_Connection();
        String sql = "SELECT Reservations.Reservation_ID AS ReservationID, First_Name, Last_Name, DocumentID, Breeding_Type, Discount, Date_Reservation, Stay, SUM(((Room_Price * Stay) - (Discount/100 * (Room_Price * Stay))) + Service_Price + Breeding_Price) AS Total, Paid\n";
        sql += "FROM Reservations JOIN Clients ON Reservations.ClientID = Clients.ClientID JOIN Rooms_Reservations\n";
        sql += "ON Reservations.Reservation_ID = Rooms_Reservations.Reservation_ID  JOIN Rooms\n";
        sql += "ON Rooms_Reservations.RoomID = Rooms.RoomID  JOIN Breeding\n";
        sql += "ON Reservations.Breeding_ID = Breeding.Breeding_ID JOIN Services_Reservations\n";
        sql += "ON Reservations.Reservation_ID = Services_Reservations.Reservation_ID  JOIN Services\n";
        sql += "ON Services_Reservations.ServiceID = Services.ServiceID JOIN Discounts\n";
        sql += "ON Reservations.DiscountID = Discounts.DiscountID  JOIN Payment_Status\n";
        sql += "ON Reservations.ID_status = Payment_Status.ID_status WHERE ";
        String space0 = "";
        String space1 = "";
        String space2 = "";
        String space3 = "";
//        String space4 = "";
//        String space5 = "";
//        String space6 = "";
        for (int i = 0; i < whereValue.length; i++) {
            sql += "'" + (space0 += " ") + "'" + " || DocumentID " + " LIKE '" + whereValue[i] + "%' OR ";
            sql += "DocumentID || " + "'" + (space1 += " ") + "'" + " LIKE '" + whereValue[i] + "%' OR ";
            sql += "'" + (space2 += " ") + "'" + " || DocumentID || " + "'" + (space3 += " ") + "'" + " LIKE '" + whereValue[i] + "%' OR ";
        }
        sql = sql.substring(0, sql.length() - 4);
        sql += "\nGROUP BY ReservationID";
        System.out.println(sql);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                Data.add(result.getString("ReservationID") + "_" +
                         result.getString("First_Name") + "_" +
                         result.getString("Last_Name") + "_" +
                         result.getString("DocumentID") + "_" +
                         result.getString("Breeding_Type") + "_" +
                         result.getString("Discount") +  "_" +
                         result.getString("Date_Reservation") + "_" +
                         result.getString("Stay") + "_" +
                         result.getString("Total") + "_" +
                         result.getString("Paid"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return Data;
    }
    
    public static ArrayList<String> selectRoomsJoin(String[] whereColumn, int[] whereValue) {
        DB_Connection();
        String sql = "SELECT Room_Number FROM Rooms JOIN Rooms_Reservations\n" +
        "ON Rooms.RoomID = Rooms_Reservations.RoomID JOIN Reservations\n" +
        "ON Rooms_Reservations.Reservation_ID = Reservations.Reservation_ID JOIN Clients\n" +
        "ON Reservations.ClientID = Clients.ClientID WHERE ";
        for (int i = 0; i < whereColumn.length; i++) {
            sql += whereColumn[i] + " = " + whereValue[i] + " OR ";
        }
        sql = sql.substring(0, sql.length() - 4);
        System.out.println(sql);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                Data.add(result.getString("Room_Number"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Data;
    }
    
    public static ArrayList<String> selectRoomsJoin1(String[] whereColumn, int[] whereValue, String[] groupColumn) {
        DB_Connection();
        String sql = "SELECT Room_Number FROM Rooms JOIN Rooms_Reservations\n" +
        "ON Rooms.RoomID = Rooms_Reservations.RoomID JOIN Reservations\n" +
        "ON Rooms_Reservations.Reservation_ID = Reservations.Reservation_ID JOIN Clients\n" +
        "ON Reservations.ClientID = Clients.ClientID JOIN Discounts\n" +
        "ON Reservations.DiscountID = Discounts.DiscountID WHERE ";
        for (int i = 0; i < whereColumn.length; i++) {
            sql += whereColumn[i] + " = " + whereValue[i] + " OR ";
        }
        sql = sql.substring(0, sql.length() - 4);
        String groupString = String.join(", ", groupColumn);
        sql += " GROUP BY " + groupString;
        System.out.println(sql);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                Data.add(result.getString("Room_Number"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Data;
    }
    
    public static ArrayList<String> selectRoomsJoin2(String[] whereColumn, String[] whereValue, String[] groupColumn) {
        DB_Connection();
        String sql = "SELECT Room_Number FROM Rooms JOIN Rooms_Reservations\n" +
        "ON Rooms.RoomID = Rooms_Reservations.RoomID JOIN Reservations\n" +
        "ON Rooms_Reservations.Reservation_ID = Reservations.Reservation_ID JOIN Clients\n" +
        "ON Reservations.ClientID = Clients.ClientID WHERE ";
        for (int i = 0; i < whereColumn.length; i++) {
            sql += "' ' || " + whereColumn[i] + " || ' '" + " LIKE '%" + whereValue[i] + "%' OR ";
        }
        sql = sql.substring(0, sql.length() - 4);
        sql += " GROUP BY "; 
        for (int i = 0; i < groupColumn.length; i++) {
            sql += groupColumn[i] + ", ";
        }
        sql = sql.substring(0, sql.length() - 2);
        
        System.out.println(sql);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                Data.add(result.getString("Room_Number"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Data;
    }
    
    public static ArrayList<String> selectRoomsJoinByClientName(String[] whereValue, String[] groupColumn) {
        DB_Connection();
        String sql = "SELECT Room_Number FROM Rooms JOIN Rooms_Reservations\n" +
        "ON Rooms.RoomID = Rooms_Reservations.RoomID JOIN Reservations\n" +
        "ON Rooms_Reservations.Reservation_ID = Reservations.Reservation_ID JOIN Clients\n" +
        "ON Reservations.ClientID = Clients.ClientID WHERE ";
        String space = "";
        for (int i = 0; i < whereValue.length; i++) {
            sql += "First_Name || " + "'" + (space += " ") + "'" + " || Last_Name LIKE '%" + whereValue[i] + "%' OR ";
        }
        sql = sql.substring(0, sql.length() - 4);
        sql += " GROUP BY "; 
        for (int i = 0; i < groupColumn.length; i++) {
            sql += groupColumn[i] + ", ";
        }
        sql = sql.substring(0, sql.length() - 2);
        
        System.out.println(sql);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                Data.add(result.getString("Room_Number"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Data;
    }
    
    public static ArrayList<String> selectServicesJoin(String[] whereColumn, int[] whereValue) {
        DB_Connection();
        String sql = "SELECT Service_Type FROM Services JOIN Services_Reservations\n" +
        "ON Services.ServiceID = Services_Reservations.ServiceID JOIN Reservations\n" +
        "ON Services_Reservations.Reservation_ID = Reservations.Reservation_ID JOIN Clients\n" +
        "ON Reservations.ClientID = Clients.ClientID WHERE ";
        for (int i = 0; i < whereColumn.length; i++) {
            sql += whereColumn[i] + " = " + whereValue[i] + " OR ";
        }
        sql = sql.substring(0, sql.length() - 4);
        sql += "\nORDER BY Service_Type ASC";
        System.out.println(sql);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                Data.add(result.getString("Service_Type"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Data;
    }
    
    public static ArrayList<String> selectServicesJoin1(String[] whereColumn, int[] whereValue, String[] groupColumn) {
        DB_Connection();
        String sql = "SELECT Service_Type FROM Services JOIN Services_Reservations\n" +
        "ON Services.ServiceID = Services_Reservations.ServiceID JOIN Reservations\n" +
        "ON Services_Reservations.Reservation_ID = Reservations.Reservation_ID JOIN Clients\n" +
        "ON Reservations.ClientID = Clients.ClientID JOIN Discounts\n" +
        "ON Reservations.DiscountID = Discounts.DiscountID WHERE ";
        for (int i = 0; i < whereColumn.length; i++) {
            sql += whereColumn[i] + " = " + whereValue[i] + " OR ";
        }
        sql = sql.substring(0, sql.length() - 4);
        String groupString = String.join(", ", groupColumn);
        sql += " GROUP BY " + groupString;
        System.out.println(sql);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                Data.add(result.getString("Service_Type"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Data;
    }
    
    public static ArrayList<String> selectServicesJoin2(String[] whereColumn, String[] whereValue, String[] groupColumn) {
        DB_Connection();
        String sql = "SELECT Service_Type FROM Services JOIN Services_Reservations\n" +
        "ON Services.ServiceID = Services_Reservations.ServiceID JOIN Reservations\n" +
        "ON Services_Reservations.Reservation_ID = Reservations.Reservation_ID JOIN Clients\n" +
        "ON Reservations.ClientID = Clients.ClientID WHERE ";
        for (int i = 0; i < whereColumn.length; i++) {
            sql += "' ' || " + whereColumn[i] + " || ' '" + " LIKE '%" + whereValue[i] + "%' OR ";
        }
        sql = sql.substring(0, sql.length() - 4);
        sql += " GROUP BY "; 
        for (int i = 0; i < groupColumn.length; i++) {
            sql += groupColumn[i] + ", ";
        }
        sql = sql.substring(0, sql.length() - 2);
        System.out.println(sql);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                Data.add(result.getString("Service_Type"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Data;
    }
    
    public static ArrayList<String> selectServicesJoinByClientName(String[] whereValue, String[] groupColumn) {
        DB_Connection();
        String sql = "SELECT Service_Type FROM Services JOIN Services_Reservations\n" +
        "ON Services.ServiceID = Services_Reservations.ServiceID JOIN Reservations\n" +
        "ON Services_Reservations.Reservation_ID = Reservations.Reservation_ID JOIN Clients\n" +
        "ON Reservations.ClientID = Clients.ClientID WHERE ";
        String space = "";
        for (int i = 0; i < whereValue.length; i++) {
            sql += "First_Name || " + "'" + (space += " ") + "'" + " || Last_Name LIKE '%" + whereValue[i] + "%' OR ";
        }
        sql = sql.substring(0, sql.length() - 4);
        sql += " GROUP BY "; 
        for (int i = 0; i < groupColumn.length; i++) {
            sql += groupColumn[i] + ", ";
        }
        sql = sql.substring(0, sql.length() - 2);
        sql += "\nORDER BY Service_Type ASC";
        System.out.println(sql);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                Data.add(result.getString("Service_Type"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Data;
    }
    
    public static ArrayList<String> selectReservationsByDiscountPassJoin(String[] whereColumn, int[] whereValue) {
        DB_Connection();
        String sql = "SELECT Reservations.Reservation_ID AS ReservationID, First_Name, Last_Name, DocumentID, Breeding_Type, Discount, Date_Reservation, Stay, SUM(((Room_Price * Stay) - (Discount/100 * (Room_Price * Stay))) + Service_Price + Breeding_Price) AS Total, Paid\n";
        sql += "FROM Reservations JOIN Clients ON Reservations.ClientID = Clients.ClientID JOIN Rooms_Reservations\n";
        sql += "ON Reservations.Reservation_ID = Rooms_Reservations.Reservation_ID  JOIN Rooms\n";
        sql += "ON Rooms_Reservations.RoomID = Rooms.RoomID  JOIN Breeding\n";
        sql += "ON Reservations.Breeding_ID = Breeding.Breeding_ID JOIN Services_Reservations\n";
        sql += "ON Reservations.Reservation_ID = Services_Reservations.Reservation_ID  JOIN Services\n";
        sql += "ON Services_Reservations.ServiceID = Services.ServiceID JOIN Discounts\n";
        sql += "ON Reservations.DiscountID = Discounts.DiscountID  JOIN Payment_Status\n";
        sql += "ON Reservations.ID_status = Payment_Status.ID_status WHERE ";
        for (int i = 0; i < whereValue.length; i++) {
            sql += whereColumn[i] + " = " + whereValue[i] + " OR ";
        }
        sql = sql.substring(0, sql.length() - 4);
        sql += " GROUP BY ReservationID";
        System.out.println(sql);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                Data.add(result.getString("ReservationID") + "_" +
                         result.getString("First_Name") + "_" +
                         result.getString("Last_Name") + "_" +
                         result.getString("DocumentID") + "_" +
                         result.getString("Breeding_Type") + "_" +
                         result.getString("Discount") +  "_" +
                         result.getString("Date_Reservation") + "_" +
                         result.getString("Stay") + "_" +
                         result.getString("Total") + "_" +
                         result.getString("Paid"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return Data;
    }
    
     public static ArrayList<String> selectWhereRooms_ReservationsJoin(String[] whereColumn, String[] whereValue) {
        DB_Connection();
        String sql = "SELECT Room_Number FROM Rooms JOIN Rooms_Reservations\n" +
"ON Rooms.RoomID = Rooms_Reservations.RoomID JOIN Reservations\n" +
"ON Rooms_Reservations.Reservation_ID = Reservations.Reservation_ID\n" +
"WHERE ";
        for (int i = 0; i < whereValue.length; i++) {
            sql += whereColumn[i] + " = " + whereValue[i] + " OR ";
        }
        sql = sql.substring(0, sql.length() - 4);
        System.out.println(sql);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                Data.add(result.getString("Room_Number"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Data;
    }
     public static ArrayList<String> selectWhereServices_ReservationsJoin(String[] whereColumn, String[] whereValue) {
        DB_Connection();
        String sql = "SELECT Service_Type FROM Services JOIN Services_Reservations\n" +
"ON Services.ServiceID = Services_Reservations.ServiceID JOIN Reservations\n" +
"ON Services_Reservations.Reservation_ID = Reservations.Reservation_ID\n" +
"WHERE ";
        for (int i = 0; i < whereValue.length; i++) {
            sql += whereColumn[i] + " = " + whereValue[i] + " OR ";
        }
        sql = sql.substring(0, sql.length() - 4);
        System.out.println(sql);
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()) {
                Data.add(result.getString("Service_Type"));
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return Data;
    }

    public static void insert(String[] columnsArray, String[] valuesArray, String table) {
        DB_Connection();
//     String check = values.substring(values.length() - 2, values.length());
//         if(check.equals("''")) {
//              values = values.replace("''", "null");
//         }
        String columns = String.join(", ", columnsArray);
        String sql = "INSERT INTO " + table + " (" + columns + ") VALUES(";
        for (int i = 0; i < valuesArray.length; i++) {
//      ---Slower---
//            if(valuesArray[i].equals("")) {
//                valuesArray[i] = null;
//                sql += valuesArray[i] + ", ";
//            }
//            else {
//                sql += "'" + valuesArray[i] + "', ";
//            }

//      ---Faster + Empty Spaces Exception---
//            sql += (valuesArray[i].isBlank() ? null : "'" + valuesArray[i] + "'") + ", ";
            sql += valuesArray[i] + ", ";  
        }
        sql = sql.substring(0, sql.length() - 2);
        sql += ")";
        System.out.println(sql);
        try{
            statement = connection.createStatement();
            statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void insertInt(String[] columnsArray, int[] valuesArray, String table) {
        DB_Connection();
//     String check = values.substring(values.length() - 2, values.length());
//         if(check.equals("''")) {
//              values = values.replace("''", "null");
//         }
        String columns = String.join(", ", columnsArray);
        String sql = "INSERT INTO " + table + " (" + columns + ") VALUES(";
        for (int i = 0; i < valuesArray.length; i++) {
//      ---Slower---
//            if(valuesArray[i].equals("")) {
//                valuesArray[i] = null;
//                sql += valuesArray[i] + ", ";
//            }
//            else {
//                sql += "'" + valuesArray[i] + "', ";
//            }

//      ---Faster + Empty Spaces Exception---
//            sql += (valuesArray[i].isBlank() ? null : "'" + valuesArray[i] + "'") + ", ";
            sql += valuesArray[i] + ", ";  
        }
        sql = sql.substring(0, sql.length() - 2);
        sql += ")";
        System.out.println(sql);
        try{
            statement = connection.createStatement();
            statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void insert2(String[] columnsArray, String[] valuesArray, String table) {
        DB_Connection();
//     String check = values.substring(values.length() - 2, values.length());
//         if(check.equals("''")) {
//              values = values.replace("''", "null");
//         }
        String columns = String.join(", ", columnsArray);
        String sql = "INSERT INTO " + table + " (" + columns + ") VALUES(";
        for (int i = 0; i < valuesArray.length; i++) {
//      ---Slower---
//            if(valuesArray[i].equals("")) {
//                valuesArray[i] = null;
//                sql += valuesArray[i] + ", ";
//            }
//            else {
//                sql += "'" + valuesArray[i] + "', ";
//            }

//      ---Faster + Empty Spaces Exception---
//            sql += (valuesArray[i].isBlank() ? null : "'" + valuesArray[i] + "'") + ", ";
            sql += "'" + valuesArray[i] + "'" + ", ";
        }
        sql = sql.substring(0, sql.length() - 2);
        sql += ")";
        System.out.println(sql);
        try{
            statement = connection.createStatement();
            statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void insert3(String[] columnsArray, String[] valuesArray, String table) {
        DB_Connection();
//     String check = values.substring(values.length() - 2, values.length());
//         if(check.equals("''")) {
//              values = values.replace("''", "null");
//         }
        String columns = String.join(", ", columnsArray);
        String sql = "INSERT INTO " + table + " (" + columns + ") VALUES(";
        for (int i = 0; i < valuesArray.length; i++) {
//      ---Slower---
//            if(valuesArray[i].equals("")) {
//                valuesArray[i] = null;
//                sql += valuesArray[i] + ", ";
//            }
//            else {
//                sql += "'" + valuesArray[i] + "', ";
//            }

//      ---Faster + Empty Spaces Exception---
//            sql += (valuesArray[i].isBlank() ? null : "'" + valuesArray[i] + "'") + ", ";
            if(valuesArray[i].contains(".") || valuesArray[i].contains("/") || valuesArray[i].contains("\\") || valuesArray[i].contains("-") || valuesArray[i].contains(" ")) {
                sql += "'" + valuesArray[i] + "'" + ", ";
            }
            else {
                sql += valuesArray[i] + ", ";
            }
        }
        sql = sql.substring(0, sql.length() - 2);
        sql += ")";
        System.out.println(sql);
        try{
            statement = connection.createStatement();
            statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void updateInt(String[] columnsArray, String[] valuesArray, String[] whereColumn, String[] whereValue, String table) {
        DB_Connection();
        String sql = "UPDATE " + table + " SET ";
        for (int i = 0; i < columnsArray.length; i++) {
//            sql += columnsArray[i] + " = " + (valuesArray[i].equals("") ? null : "'" + valuesArray[i] + "'") + ", ";
              if(valuesArray[i].contains(".")) {
                  sql += columnsArray[i] + " = '" + valuesArray[i] + "', ";
              }
              else {
                  sql += columnsArray[i] + " = " + valuesArray[i] + ", ";
              }
        }
        sql = sql.substring(0, sql.length() - 2);
        sql += " WHERE ";
        for (int i = 0; i < whereValue.length; i++) {
            sql += whereColumn[i] + " = " + whereValue[i] + " AND ";
        }
        sql = sql.substring(0, sql.length() - 5);
        System.out.println(sql);
        try{
            statement = connection.createStatement();
            statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void updateString(String[] columnsArray, String[] valuesArray, String[] whereColumn, String[] whereValue, String table) {
        DB_Connection();
        String sql = "UPDATE " + table + " SET ";
        for (int i = 0; i < columnsArray.length; i++) {
//            sql += columnsArray[i] + " = " + (valuesArray[i].equals("") ? null : "'" + valuesArray[i] + "'") + ", ";
              if(valuesArray[i].contains("0") || valuesArray[i].contains("1") ||
                 valuesArray[i].contains("2") || valuesArray[i].contains("3") ||
                 valuesArray[i].contains("4") || valuesArray[i].contains("5") ||
                 valuesArray[i].contains("6") || valuesArray[i].contains("7") ||
                 valuesArray[i].contains("8") || valuesArray[i].contains("9")) {
                  sql += columnsArray[i] + " = " + valuesArray[i] + ", ";
              }
              else {
                  sql += columnsArray[i] + " = '" + valuesArray[i] + "', ";
              }
        }
        sql = sql.substring(0, sql.length() - 2);
        sql += " WHERE ";
        for (int i = 0; i < whereValue.length; i++) {
            sql += whereColumn[i] + " = " + whereValue[i] + " AND ";
        }
        sql = sql.substring(0, sql.length() - 5);
        System.out.println(sql);
        try{
            statement = connection.createStatement();
            statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void updateCombinedString(String[] columnsArray, String[] valuesArray, String[] whereColumn, String[] whereValue, String table) {
        DB_Connection();
        String sql = "UPDATE " + table + " SET ";
        for (int i = 0; i < columnsArray.length; i++) {
//            sql += columnsArray[i] + " = " + (valuesArray[i].equals("") ? null : "'" + valuesArray[i] + "'") + ", ";
              sql += columnsArray[i] + " = '" + valuesArray[i] + "', ";
        }
        sql = sql.substring(0, sql.length() - 2);
        sql += " WHERE ";
        for (int i = 0; i < whereValue.length; i++) {
            sql += whereColumn[i] + " = " + whereValue[i] + " AND ";
        }
        sql = sql.substring(0, sql.length() - 5);
        System.out.println(sql);
        try{
            statement = connection.createStatement();
            statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void delete(String[] columnsArray, String[] valuesArray, String table){
        
        String sql = "DELETE FROM " + table + " WHERE ";
        for (int i = 0; i < valuesArray.length; i++) {
            sql += columnsArray[i] + " = " + valuesArray[i] + " AND ";
        }
        sql = sql.substring(0, sql.length() - 5);
        System.out.println(sql);
        try{
            statement = connection.createStatement();
            statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void close(){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Throwable ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
