import java.sql.*;

public class Demo02_GetUsers {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection(Config.JDBC_URL)) {
            System.out.println("使用Statement,存在注入问题");
            System.out.println("查询name='zhangsan'的用户");
            getUserByName(conn, "zhangsan");
            System.out.println("sql注入，骗过mysql");
            getUserByName(conn, "zhangsan' or '1'='1");

            System.out.println("使用PreparedStatement防注入");
            getUserByNameAndUsePreparedStatement(conn, "zhangsan' or '1'='1");
            getUserByNameAndUsePreparedStatement(conn, "zhangsan");
        }
    }

    public static void getUserByName(Connection conn, String name) throws SQLException {
        System.out.println("-------------");
        try (Statement st = conn.createStatement()) {
            ResultSet rs = null;
            rs = st.executeQuery("select * from USER where NAME='" + name + "'");
            printResult(rs);
        }
    }

    public static void getUserByNameAndUsePreparedStatement(Connection conn, String name) throws SQLException {
        System.out.println("-------------");
        System.out.println("用户输入name=" + name);
        try (PreparedStatement st = conn.prepareStatement("select * from USER where NAME= ?")) {
            st.setString(1, name);
            ResultSet rs = null;
            rs = st.executeQuery();
            printResult(rs);
        }
    }

    public static void printResult(ResultSet rs) throws SQLException {
        System.out.println("id,name,tel,address,created_at,updated_at");
        while (rs.next()) {
            System.out.println(
                    rs.getInt(1) + "," +
                            rs.getString(2) + "," +
                            rs.getString(3) + "," +
                            rs.getString(4) + "," +
                            rs.getDate(5) + "," +
                            rs.getDate(6)
            );
        }
    }

}
