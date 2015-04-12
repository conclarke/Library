package ejbs;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import daoInterfaces.LibraryDAOInterface;
import entities.Track;
import entityInterfaces.LibraryInterface;

@Stateless
@NamedQueries({@NamedQuery(name = "getAllTracks", query = "SELECT DISTINCT t.trackId , t.trackTitle, t.artist FROM Track t")})
public class LibraryEJB implements LibraryInterface {

	@PersistenceContext
	private EntityManager em;

	@Inject
	private LibraryDAOInterface dao;

	public LibraryEJB() {

	}

	@Override
	public Collection <Track> getAllTracks() {
		return dao.getAllTracks();
	}

	@Override
	public void addTracks(Collection <Track> tracks) {
		dao.addTracks(tracks);;
	}

	@Override
	public void addTrack(Track track) {
		dao.addTrack(track);
	}

	//	@Override
	//	public Collection <Playlist> getAllPlayLists() {
	//		return dao.getAllPlayLists();
	//	}

}
