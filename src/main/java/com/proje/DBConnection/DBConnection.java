package com.proje.DBConnection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.mysql.cj.jdbc.Driver;

public class DBConnection {

	public static final Logger logger = (Logger) LogManager.getLogger();
	public static String driver = null;
	public static String url = null;
	public static String user = null;
	public static String password = null;

	static {

		Properties properties = new Properties();

		try {
			InputStream inputStream = new FileInputStream("src/main/resources/database.properties");
			properties.load(inputStream);
			driver = properties.getProperty("db_driver");
			url = properties.getProperty("db_url");
			user = properties.getProperty("db_user");
			password = properties.getProperty("db_password");

		} catch (IOException e) {
			logger.warn("database.properties dosyas�ndan verileri �ekerken hata meydana geldi " + e);
		}

	}

	public static Connection getconnection() {
		Connection connection = null;

		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			logger.warn("database driver bulunamad�" + e);
		}

		try {
			connection = (Connection) DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			logger.warn("BA�LANTI OLU�TURULURKEN HATA MEYDANA GELD�" + e);
		}

		return connection;
	}

	public static void closeConnection(Connection connection, PreparedStatement preparedstatement,ResultSet resultset) { 
	if (resultset != null)
 {

			try {
				resultset.close();

			} catch (SQLException e) {
				logger.warn("ResultSet baglan�lamad�" + e);
			}
			if (preparedstatement != null) {

				try {
					preparedstatement.close();

					logger.warn("preparedstatement kapat�l�rken bir sorun yok");

				} catch (SQLException e) {
					logger.warn("preparedstatement kapat�l�rken bir sorun var" + e);
				}
				if (connection != null) {

					try {
						connection.close();

						logger.warn("connection kapat�l�rken bir sorun yok");

					} catch (SQLException e) {
						logger.warn("connection kapat�l�rken bir sorun var" + e);
					}
			}
		}
	}
}
}
