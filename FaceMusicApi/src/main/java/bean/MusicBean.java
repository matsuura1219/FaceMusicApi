package bean;

import java.io.Serializable;

/**  **/
public class MusicBean implements Serializable {

	/** 定数 **/

	// シリアライズを宣言したクラスのバージョンで、クラスの構造を変更した場合に変更すべき変数です
	private static final long serialVersionUID = 1L;

	/** 変数 **/

	// 楽曲ID
	private String id;
	// 画像URL
	private String imageUrl;
	// アーティスト名
	private String artist;
	// 曲名
	private String music;
	// danceability
	private float danceability;
	// energy
	private float energy;
	// loudness
	private float loudness;
	// speechiness
	private float speechiness;
	// acousticness
	private float acousticness;
	// instrumentalness
	private float instrumentalness;
	// liveness
	private float liveness;
	// valence
	private float valence;
	// tempo
	private float tempo;
	// 曲の時間
	private int durationTime;
	// リリースした日
	private String releaseDay;


	/** コンストラクタ **/
	public MusicBean() {

	}


	/** Getter / Setter **/

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}


	public String getMusic() {
		return music;
	}


	public void setMusic(String music) {
		this.music = music;
	}


	public float getDanceability() {
		return danceability;
	}


	public void setDanceability(float danceability) {
		this.danceability = danceability;
	}


	public float getEnergy() {
		return energy;
	}


	public void setEnergy(float energy) {
		this.energy = energy;
	}


	public float getLoudness() {
		return loudness;
	}


	public void setLoudness(float loudness) {
		this.loudness = loudness;
	}


	public float getSpeechiness() {
		return speechiness;
	}


	public void setSpeechiness(float speechiness) {
		this.speechiness = speechiness;
	}


	public float getAcousticness() {
		return acousticness;
	}


	public void setAcousticness(float acousticness) {
		this.acousticness = acousticness;
	}


	public float getInstrumentalness() {
		return instrumentalness;
	}


	public void setInstrumentalness(float instrumentalness) {
		this.instrumentalness = instrumentalness;
	}


	public float getLiveness() {
		return liveness;
	}


	public void setLiveness(float liveness) {
		this.liveness = liveness;
	}


	public float getValence() {
		return valence;
	}


	public void setValence(float valence) {
		this.valence = valence;
	}


	public float getTempo() {
		return tempo;
	}


	public void setTempo(float tempo) {
		this.tempo = tempo;
	}


	public String getReleaseDay() {
		return releaseDay;
	}


	public void setReleaseDay(String releaseDay) {
		this.releaseDay = releaseDay;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public int getDurationTime() {
		return durationTime;
	}


	public void setDurationTime(int durationTime) {
		this.durationTime = durationTime;
	}



}
