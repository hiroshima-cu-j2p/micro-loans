package dao;
/**
 * 
 * @author	Eri.Kaneyama
 * @date	2013/08/29
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private Connection con;
    private String server = "//localhost:5432/postgres?";
    private String user = "postgres";
    private String password = "admin";
    
   
    
    /* 
     * METHOD NAME:	connect
     * DESCRIPTION:	the method to connect to the database
     * PARAMETER:	-
     */
    public Connection getConnection() throws SQLException {
        String drv = "org.postgresql.Driver";
        //String url = "jdbc:postgresql:" + server + "user=" + user + "&password=" + password;
        String url = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=admin";
        try {
            Class.forName(drv);
            con = DriverManager.getConnection(url);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }
    
    /* 
     * METHOD NAME:	close
     * DESCRIPTION:	the method to close a connection
     * PARAMETER:	-
     */
    public void close() throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}
