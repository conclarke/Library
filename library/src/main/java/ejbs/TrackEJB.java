package ejbs;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import daoInterfaces.LibraryDAOInterface;
import entities.Track;
import entityInterfaces.TrackInterface;

@Stateless
public class TrackEJB implements TrackInterface {

	@PersistenceContext
	private EntityManager em;

	@Inject
	private LibraryDAOInterface dao;

	public TrackEJB() {

	}

	@Override
	public void addTrack(Track track) {
		dao.addTrack(track);
	}
}
