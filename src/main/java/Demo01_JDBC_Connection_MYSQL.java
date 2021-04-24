import java.sql.*;

public class Demo01_JDBC_Connection_MYSQL {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("传统数据库连接");
        createConnectionMysql();
        System.out.println("优化版：try with resources：数据库连接");
        createConnectionMysqlPlus();
    }

    public static void createConnectionMysqlPlus() throws ClassNotFoundException, SQLException {
        try (Connection conn = DriverManager.getConnection(Config.JDBC_URL)) {
        }
    }

    public static void createConnectionMysql() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(Config.JDBC_URL);
        } catch (SQLException e) {
            System.out.println("连接数据库失败");
            e.printStackTrace();
        } finally {
            //3：关闭数据库资源  Connection。
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
