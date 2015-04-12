package entityInterfaces;

import java.util.Collection;
import javax.ejb.Local;
import entities.Track;

@Local
public interface LibraryInterface {

	Collection <Track> getAllTracks();

	void addTrack(Track track);

	void addTracks(Collection <Track> tracks);

	//public Collection <Playlist> getAllPlayLists();
}
