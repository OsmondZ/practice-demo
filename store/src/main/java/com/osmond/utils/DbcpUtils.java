package com.osmond.utils;


	import java.io.IOException;
	import java.io.InputStream;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.Properties;

	import javax.sql.DataSource;

	import org.apache.commons.dbcp.BasicDataSourceFactory;

	public class DbcpUtils {
		private static DataSource dataSource;
		static{
			try {
				InputStream inputStream = DbcpUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
				Properties properties = new Properties();
				properties.load(inputStream);
				//BasicDataSource 基础的数据源（基础的数据库连接池）
				dataSource = BasicDataSourceFactory.createDataSource(properties);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static Connection getConnection(){
			try {
				Connection connection = dataSource.getConnection();
				return connection;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		//最后一步关闭所有资源
		public static void closeAll(Connection conn,PreparedStatement pst, ResultSet resultSet){
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
