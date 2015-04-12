package daoInterfaces;

import java.util.Collection;
import javax.ejb.Local;
import entities.Track;
import entityInterfaces.LibraryInterface;

@Local
public interface LibraryDAOInterface extends LibraryInterface {

	@Override
	void addTrack(Track track);

	void deleteTrack(Track track);

	void addTracks(Collection <Track> tracks);
}
