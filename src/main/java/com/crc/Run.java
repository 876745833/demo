package com.crc;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * @Author CRC
 * @Date 2020/7/23
 * @Describe
 */
public class Run {
    public static void main(String[] args) {
        PreparedStatement pstm=null;
        Connection con=null;
        //2.从MyDataSource的池中获得连接对象
        con= ConDemo.mysqlconn();
        //3.写sql
        String sql="insert into sys_config values (?,?,?,?)";
        //4,预编译
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sf.format(System.currentTimeMillis());
        try {
            pstm= con.prepareStatement(sql);
            pstm.setString(1, "");
            pstm.setString(2, "23");
            pstm.setTimestamp(3, Timestamp.valueOf(format));
            pstm.setString(4, "45");
            int col=pstm.executeUpdate();
            if(col>0) {
                System.out.println("添加成功："+col+"条数");
            }else {
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            mysqlcolse(con,pstm,null);
        }
    }

    public static void mysqlcolse(Connection con, PreparedStatement pstem, ResultSet rs) {

        try {
            if(con!=null) {
                con.close();
            }
            if(pstem!=null)
            {
                pstem.close();
            }
            if(rs!=null) {
                rs.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
