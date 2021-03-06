package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import bean.MusicBean;
import dao.EmotionDao;
import util.Constants;

/**
 * 感情に応じたSpotify楽曲のIDを返却するコントローラです。
 */

public class GetMusicForEmotions extends HttpServlet {

	/** 定数 **/

	// シリアライズを宣言したクラスのバージョンで、クラスの構造を変更した場合に変更すべき変数です
	private static final long serialVersionUID = 1L;

	/** コンストラクタ **/
    public GetMusicForEmotions() {
        super();

    }

    /** GET関数です **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得します

		float anger = Float.parseFloat(request.getParameter(Constants.ANGER));
		float contempt = Float.parseFloat(request.getParameter(Constants.CONTEMPT));
		float disgust = Float.parseFloat(request.getParameter(Constants.DISGUST));
		float fear = Float.parseFloat(request.getParameter(Constants.FEAR));
		float happiness = Float.parseFloat(request.getParameter(Constants.HAPPINESS));
		float neutral = Float.parseFloat(request.getParameter(Constants.NEUTRAL));
		float sadness = Float.parseFloat(request.getParameter(Constants.SADNESS));
		float surprise = Float.parseFloat(request.getParameter(Constants.SURPRISE));

		int from = Integer.parseInt(request.getParameter(Constants.FROM));
		int to = Integer.parseInt(request.getParameter(Constants.TO));

		EmotionDao dao = new EmotionDao();
		ArrayList<MusicBean> list = new ArrayList<MusicBean>();

		try {

			// DBからデータを取得します
			list = dao.findMusic(anger, contempt, disgust, fear, happiness, neutral, sadness, surprise, from, to);

		} catch (SQLException se) {

			se.printStackTrace();

		} catch (ClassNotFoundException cnfe) {

			cnfe.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}

		// responseの設定を行います。
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		//DBから取得した情報をJson形式に変換します
		Gson gson = new Gson();
		gson.toJson(list, new TypeToken<ArrayList<MusicBean>>() {}.getType(), response.getWriter());


	}


	/** POST関数です **/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
