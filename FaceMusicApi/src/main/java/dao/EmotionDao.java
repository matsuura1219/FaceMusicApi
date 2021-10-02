package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.MusicBean;
import util.DbUtil;

/** EmotionAPIのDAOクラスです **/

public class EmotionDao {

	/** 定数 **/
	private final String SQL = "SELECT * FROM emotion_detection_table LIMIT ?,?";


	/** コンストラクタ **/
	public EmotionDao () {

	}


	/**
	 * 引数に応じたMusicBeanを返却する関数です
	 * @param anger float 怒り
     * @param contempt float 軽蔑
     * @param disgust float 嫌悪
     * @param fear float 恐怖
     * @param happiness fLoat 幸福
     * @param neutral float 自然
     * @param sadness float 悲しさ
     * @param surprise float 驚き
     * @param from Int DB検索のスタート行
     * @param to Int DB検索のファイナル行
	 */

	public ArrayList<MusicBean> findMusic (float anger, float contempt, float disgust, float fear, float happiness, float neutral, float sadness, float surprise, int from, int to)
			throws SQLException, ClassNotFoundException {

		DbUtil dbCon = new DbUtil();
		ResultSet res = null;
		PreparedStatement stmt = null;
		ArrayList<MusicBean> beanList = new ArrayList<MusicBean>();

		try {

			// SQL文を用意します
			stmt = dbCon.getConnection().prepareStatement(SQL);
			stmt.setInt(1, from);
			stmt.setInt(2, to - from + 1);
			// SQL文を実行します
			res = stmt.executeQuery();

			while (res.next()) {

				MusicBean bean = new MusicBean();
				bean.setId(res.getString(1));
				bean.setImageUrl(res.getString(2));
				bean.setArtist(res.getString(3));
				bean.setMusic(res.getString(4));
				bean.setDanceability(res.getFloat(5));
				bean.setEnergy(res.getFloat(6));
				bean.setLoudness(res.getFloat(7));
				bean.setSpeechiness(res.getFloat(8));
				bean.setAcousticness(res.getFloat(9));
				bean.setInstrumentalness(res.getFloat(10));
				bean.setLiveness(res.getFloat(11));
				bean.setValence(res.getFloat(12));
			    bean.setTempo(res.getFloat(13));
			    bean.setDurationTime(res.getInt(14));
			    bean.setReleaseDay(res.getString(15));
			    beanList.add(bean);

			}

		} finally {

			// Connectionを切断します
			dbCon.close();

		}


		return beanList;

	}

}
