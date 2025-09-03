import java.util.*;
import java.io.*;
import java.sql.*;
import oracle.jdbc.driver.OracleDriver;

class SqlPlus {
    public static void main(String[] args) throws Exception {
        FileInputStream fin = new FileInputStream("SqlPlus.properties");
        Properties p = new Properties();
        p.load(fin);

        String driver = p.getProperty("driver");
        String url = p.getProperty("url");

        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, p);
        Statement st = con.createStatement();
        Scanner sc = new Scanner(System.in);

        String sql = "";
        int columnCount = 0;

        while (!"exit".equalsIgnoreCase(sql)) {
            System.out.print("SQL> ");
            sql = sc.nextLine().trim();
            if(sql.isEmpty())
             continue;
            if("exit".equalsIgnoreCase(sql)){
                    System.out.println("Exited successfully.");
                    break;
                }
              

            try {
                if(st.execute(sql)) {
                    ResultSet rs = st.getResultSet();
                    ResultSetMetaData rsmd = rs.getMetaData();
                    columnCount = rsmd.getColumnCount();

          
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.printf("%-20s", rsmd.getColumnName(i));
                    }
                    System.out.println();
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");

                    
                    while (rs.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            String ans=rs.getString(i);
                          if("DATE".equalsIgnoreCase(rsmd.getColumnTypeName(i))){  
                                  if(ans!=null)
                                  ans=ans.substring(0,10);
                               }
                            System.out.printf("%-20s", ans);
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Query executed successfully, but it is not a SELECT statement. No results to display.");
                }
 
            } catch (SQLException e) {
                    System.out.println("Error in query: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }

        st.close();
        con.close();
        sc.close();
    }
}
