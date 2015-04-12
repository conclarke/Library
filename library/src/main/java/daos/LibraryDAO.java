package daos;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import daoInterfaces.LibraryDAOInterface;
import entities.Track;

@Stateless
public class LibraryDAO implements LibraryDAOInterface {

	@PersistenceContext
	private EntityManager em;

	public LibraryDAO() {

	}

	@Override
	public Collection <Track> getAllTracks() {
		return em.createNamedQuery("getAllTracks").getResultList();
	}

	@Override
	public void addTrack(Track track) {
		em.persist(track);
	}

	@Override
	public void addTracks(Collection <Track> tracks) {
		for (Track track : tracks) {
			em.persist(track);
		}
	}

	@Override
	public void deleteTrack(Track track) {
		em.remove(track);
	}

}
