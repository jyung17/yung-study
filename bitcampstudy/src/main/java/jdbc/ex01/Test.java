package jdbc.ex01;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Test {
  
  public static void main(String[] args) {
    
    Dimension dim = new Dimension(800, 400);
    
    JFrame frm = new JFrame("database");
    frm.setLocation(200, 400);
    frm.setSize(dim);
    
    JTable tbl = new JTable();
    DefaultTableModel model = new DefaultTableModel();
    
    String driver = "org.mariadb.jdbc.Driver";
    String url = "jdbc:mariadb://127.0.0.1:3306/studydb?useSSL=false";
    String id = "study";
    String pw = "1111";
    String sql = "select * from lect";
    List<Map<String, Object>> list = queryForList(driver, url, id, pw, sql);
    
    if (list.size() > 0) {
      String[] headers = null;
      for (int i = 0; i < list.size(); i++) {
        Map<String, Object> map = list.get(i);
        if (i == 0) {
          int j = 0;
          headers = new String[map.size()];
          for (String key : map.keySet()) {
            headers[j++] = key;
          }
          model = new DefaultTableModel(headers, 0);   //header추가, 행은 0개 지정
        }
        int j = 0;
        Object[] data = new Object[map.size()];
        for (String key : headers) {
          data[j++] = map.get(key);
        }
        model.addRow(data);
      }
    }
    tbl.setModel(model);
    JScrollPane sp = new JScrollPane();
    sp.setViewportView(tbl);
    frm.add(sp);
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frm.setVisible(true);
    
    
  }
  
  // 무조건 외우기
  public static List<Map<String, Object>> queryForList(String driver, String url, String id,
      String pw, String sql) {
    List<Map<String, Object>> retValue = new ArrayList<Map<String, Object>>();
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    try {
      //순서 꼭 외우기!
      Class.forName(driver); //드라이버를 불러온다
      conn = DriverManager.getConnection(url, id, pw);// db에 접속한다.
      st = conn.createStatement();// Statement객체를 생성한다.
      rs = st.executeQuery(sql); // st를 가지고 쿼리를 실행한다.
      
      ResultSetMetaData rsmd = rs.getMetaData();//컴럼명,컬럼파일을 메타데이터라 하는데 그 메타데이터를 불러온다.
      while (rs.next()) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        for (Integer i = 1; i <= rsmd.getColumnCount(); i++) {
          String fieldName = rsmd.getColumnName(i);
          int type = rsmd.getColumnType(i);
          map.put(fieldName, rs.getObject(i));//맵에 데이터를 한줄씩 넣는다.
        }
        retValue.add(map);//위 맵을 한줄씩 리스트에다가 데이터를 쌓는다.
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException e) {
        }
      }
      if (st != null) {
        try {
          st.close();
        } catch (SQLException e) {
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
        }
      }
    }
    return retValue;
  }
  
}
