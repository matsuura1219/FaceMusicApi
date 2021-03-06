package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Databaseに関する処理をまとめたクラスです **/

public class DbUtil {

	/** 変数 **/

	//接続オブジェクト
	private Connection con;

	/** 定数 **/

	// DBサーバ名(ホスト名)
	private final String SERVER = "facemusic-database.cvhwnuodjgqb.ap-northeast-1.rds.amazonaws.com";
	// ユーザ名
	private final String USER = "matsuurayuki";
	// パスワード
	private final String PASSWORD = "kawaijuku1219";

	/**
	 * DB接続用の関数です
	 * @throws ClassNotFoundException
	 */

	public Connection getConnection() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");

		// 接続先URL
		String url = "jdbc:mysql://" + SERVER + ":3306/face_music_db";
		// 接続をします
		con = DriverManager.getConnection(url, USER, PASSWORD);

		return con;

	}

	/**
	 * DB遮断用の関数です
	 */
	public void close() throws SQLException {

		if (con != null) {
			con.close();
		}
	}
}
