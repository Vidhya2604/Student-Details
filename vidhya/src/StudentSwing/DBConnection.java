package StudentSwing;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
	
	static Connection con;
    public static Connection createConnetion(){

        try{
            
            String url="jdbc:mysql://localhost:3306/studentreg";
            String username="root";
            String password="root";
           con= DriverManager.getConnection(url,username,password);

        }catch (Exception ex){
            ex.printStackTrace();
        }
     return con;

    }
}
