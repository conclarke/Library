package entityInterfaces;

import javax.ejb.Local;
import entities.Track;

@Local
public interface TrackInterface {

	void addTrack(Track track);
}
