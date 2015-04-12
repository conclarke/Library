package rest;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import entityInterfaces.LibraryInterface;

@Path("/query")
public class Queries {

	@EJB
	private LibraryInterface library;

	@POST
	@Path("/allTracks")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTracks() {
		return Response.ok().status(200).entity(library.getAllTracks()).build();
	}
}
