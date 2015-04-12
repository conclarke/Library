package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "track")
public class Track {

	@Id
	@Column(name = "track_id")
	private int trackId;

	@Column(name = "title")
	private String trackTitle;

	private String artist;

	public Track() {
	}

	public Track(int trackId, String trackTitle, String artist) {
		this.trackId = trackId;
		this.trackTitle = trackTitle;
		this.artist = artist;
	}

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public String getTrackTitle() {
		return trackTitle;
	}

	public void setTrackTitle(String trackTitle) {
		this.trackTitle = trackTitle;
	}

}
