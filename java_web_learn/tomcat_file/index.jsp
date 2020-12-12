<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>

<style>
  table {
    border-collapse: collapse;
  }

  th, td {
    border: 1px solid #C1DAD7;
    font-size: 12px;
    padding: 6px;
    color: #4f6b72;
  }
</style>

<%
  String user = request.getParameter("user");

  String CLASS_NAME = "com.mysql.jdbc.Driver";

  // 数据库链接字符串
  String URL = "jdbc:mysql://localhost:3306/mysql?autoReconnect=true&zeroDateTimeBehavior=round&useUnicode=true&characterEncoding=UTF-8&useOldAliasMetadataBehavior=true&useOldAliasMetadataBehavior=true&useSSL=false";

  // 数据库用户名
  String USERNAME = "root";

  // 数据库密码
  String PASSWORD = "root";
  //Connection connection;
  try {
    Class.forName(CLASS_NAME);// 注册JDBC驱动类
  } catch (ClassNotFoundException e) {
    e.printStackTrace();
  }
  try {
    Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    String sql = "select host,user from mysql.user where user = '" + user + "'";
    System.out.println(sql);
    PreparedStatement pstt = connection.prepareStatement(sql);
    ResultSet rs = pstt.executeQuery();
    System.out.println("<table><tr>");
    System.out.println("<th>主机</th>");
    System.out.println("<th>用户</th>");
    System.out.println("<tr/>");
    while (rs.next()) {
      System.out.println("<tr>");

      // 获取SQL语句中查询的字段值
      System.out.println("<td>" + rs.getObject("host") + "</td>");
      System.out.println("<td>" + rs.getObject("user") + "</td>");
      System.out.println("<tr/>");
    }
    System.out.println("</table>");
    rs.close();
    pstt.close();
    connection.close();
  } catch (SQLException throwables) {
    throwables.printStackTrace();
  }
%>