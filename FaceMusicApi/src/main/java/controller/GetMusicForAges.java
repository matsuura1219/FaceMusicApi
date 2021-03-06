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
import dao.AgeDao;
import util.Constants;


public class GetMusicForAges extends HttpServlet {

	/** 定数 **/

	// シリアライズを宣言したクラスのバージョンで、クラスの構造を変更した場合に変更すべき変数です
	private static final long serialVersionUID = 1L;


	/** コンストラクタ **/
    public GetMusicForAges() {
        super();

    }


    /** Get関数です **/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得します

				String age = request.getParameter(Constants.AGE);


				int from = Integer.parseInt(request.getParameter(Constants.FROM));
				int to = Integer.parseInt(request.getParameter(Constants.TO));

				AgeDao dao = new AgeDao();
				ArrayList<MusicBean> list = new ArrayList<MusicBean>();

				try {

					// DBからデータを取得します
					list = dao.findMusic(age, from, to);

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


	/** Post関数です**/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
