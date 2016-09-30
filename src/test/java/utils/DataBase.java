package utils;

import java.io.Reader;
import java.io.StringWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class DataBase {

    //protected String dbDriver;
    //protected String url;
    protected static String dbDriver="org.postgresql.Driver";

    protected static String host=System.getProperty("db.host");
    protected static String port=System.getProperty("db.port");
    protected static String dbName=System.getProperty("db.name");
    protected static String user=System.getProperty("db.user");
    protected static String password=System.getProperty("db.password");
    //protected static String host="192.168.15.123";
    //protected static String port="5432";
    //protected static String dbName="soopdbtest";
    //protected static String user="isod";
    //protected static String password="qwerty";


    public static Connection getDBConnection() {
        Connection dbConnection = null;
        String dataBaseConnectionString = "jdbc:postgresql://" + host + ":" + port + "/" + dbName;
        try {
            Class.forName(dbDriver);
            //System.out.println("dbdriver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(dataBaseConnectionString,user,password);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //System.out.println(dbConnection.toString());
        return dbConnection;
    }


    public static ArrayList<String> select (String columnName,String resultColumnName, String columnType, String table, String sqlCondition)throws Exception{

        Connection conn = null;
        Statement stmt = null;
        ResultSet recordsList = null;
       // try{
            //connect to database
            //System.out.println("1");
            conn = getDBConnection();
            //System.out.println("2");
            stmt = conn.createStatement();
            //execute SQL statement
            String SQLQuery = "select "+columnName+" from "+table+" where "+sqlCondition;
            recordsList = stmt.executeQuery(SQLQuery);
            System.out.println("SQLQuery:"+SQLQuery);
            ArrayList<String> resultList = new ArrayList<>();
            int count=0;
            String curRes;
            while (recordsList.next()){
                switch (columnType.toLowerCase()){
                    case "string":
                        resultList.add(count, recordsList.getString(resultColumnName));
                        break;
                    case "datetime":
                        curRes = new SimpleDateFormat("MM/dd/yyyy HH/mm/ss").format(recordsList.getDate(resultColumnName));
                        resultList.add(count, curRes);
                        break;
                    case "int":
                        curRes = recordsList.getBigDecimal(resultColumnName).toString();
                        resultList.add(count, curRes);
                        break;
                    case "clob":
                        Clob clob = recordsList.getClob(1);
                        char clobVal[] = new char[(int) clob.length()];
                        Reader r = clob.getCharacterStream();
                        r.read(clobVal);
                        StringWriter sw = new StringWriter();
                        sw.write(clobVal);
                        r.close();
                        resultList.add(count, new String(clobVal));
                }
                //resultList.add(0, (String) records.getObject(columnName));
                count++;
            }
            System.out.println("Result: "+resultList);
            return resultList;
        //}
      //  catch(SQLException e){
      //      e.printStackTrace();
     //       return null;
      //  }
      //  finally{
        //    conn.close();
        //    stmt.close();
        //    recordsList.close();
      //  }
    }
}

