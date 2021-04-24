public class Config {
    public static final String JDBC_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    public static final String JDBC_CONNECTION_STRING = "jdbc:mysql://localhost:3306/test1";
    public static final String MYSQL_ACCOUNT = "root";
    public static final String MYSQL_PWD = "root";
    public static final String JDBC_URL = JDBC_CONNECTION_STRING + "?user=" + MYSQL_ACCOUNT + "&password=" + MYSQL_PWD;
}
