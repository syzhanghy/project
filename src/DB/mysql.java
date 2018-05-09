package DB;

import java.sql.*;

/**
 * Created by Administrator on 2018/5/8.
 */
public class mysql
{
    //时间原点：1970年1月1日   0点0分0秒
    public static void main(String[] args)
    {
        PreparedStatement ps = null;
        Connection conn=null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/neuedu", "root", "root");
            String sql="insert into sorder values (null,?,?,?,?,?,?,?,?)";
            ps =conn.prepareStatement(sql);
            ps.setInt(1,1);
            ps.setString(2,"oooo");
            ps.setDouble(3,1000);
            ps.setString(4,"ppp");
            ps.setDouble(5,556);
            ps.setString(6,"uuu");
            Timestamp now=new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(7,now);
            ps.setInt(8,5);
            ps.executeUpdate();

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        finally
        {

            try
            {
                ps.close();
                conn.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }


    }
}
