//package utils;
//
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import javax.ejb.EJB;
//import javax.ejb.Stateless;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.MultivaluedMap;
//import javax.ws.rs.core.Response;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.xpath.XPath;
//import javax.xml.xpath.XPathFactory;
//import org.jboss.resteasy.plugins.providers.multipart.InputPart;
//import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
//import org.w3c.dom.Document;
//import daoInterfaces.LibraryDAOInterface;
//import entities.Track;
//import entityInterfaces.TrackInterface;
//
//@Stateless
//public class XMLParser implements ParserInterface {
//
//	@EJB
//	LibraryDAOInterface libraryEJB;
//
//	@EJB
//	TrackInterface trackEJB;
//
//	public XMLParser() {
//
//	}
//
//	@POST
//	@Consumes(MediaType.MULTIPART_FORM_DATA)
//	public Response init(MultipartFormDataInput input) {
//		System.out.println(input);
//		Map <String, List <InputPart>> formParts = input.getFormDataMap();
//		List <InputPart> parts = formParts.get("fileName");
//		String inputFile = new String();
//		for (InputPart p : parts) {
//			//	System.out.println(p.getHeaders());
//			MultivaluedMap <String, String> headers = p.getHeaders();
//			String fileName = parseFileName(headers);
//			String path = "C:/Users/User/Downloads/Masters/DistSysAssignment/";
//			System.out.println(fileName);
//			System.out.println("FULL PATH: " + fileName);
//			inputFile = fileName;
//		}
//
//		File f = new File(inputFile);
//		List <Track> tracks = new ArrayList <Track>();
//		int n = getTrackCount(f);
//		for (int i = 0; i < n; i++) {
//			Track t = readTrackInfo(i);
//			libraryEJB.addTrack(t);
//			tracks.add(t);
//		}
//		System.out.println("DAO----------------------------------" + trackEJB);
//		libraryEJB.addTracks(tracks);
//		return Response.status(200).entity("uploadFile is called, Uploaded file name : ").build();
//	}
//
//	private String parseFileName(MultivaluedMap <String, String> headers) {
//		String [] contentDispositionHeader = headers.getFirst("Content-Disposition").split(";");
//		for (String name : contentDispositionHeader) {
//			if ((name.trim().startsWith("filename"))) {
//				String [] tmp = name.split("=");
//				String fileName = tmp[1].trim().replaceAll("\"", "");
//				return fileName;
//			}
//		}
//		return "Something ......";
//	}
//
//	@Override
//	public int getTrackCount(File f) {
//		int n = 0;
//		try {
//			File fXmlFile = new File("C:/Users/User/Downloads/Masters/DistSysAssignment/Assignment/Library1.xml");
//			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder builder = factory.newDocumentBuilder();
//			Document doc = builder.parse(fXmlFile);
//			XPathFactory xpf = XPathFactory.newInstance();
//			XPath path = xpf.newXPath();
//
//			try {
//				n = Integer.parseInt(path.evaluate("count(/plist/dict/dict/dict)", doc));
//			}
//			catch (NumberFormatException e) {
//				e.printStackTrace();
//			}
//		}
//		catch (Exception e) {
//
//		}
//		return n;
//	}
//
//	@Override
//	public Track readTrackInfo(int i) {
//		try {
//			File fXmlFile = new File("C:/Users/User/Downloads/Masters/DistSysAssignment/Assignment/Library1.xml");
//			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder builder = factory.newDocumentBuilder();
//			Document doc = builder.parse(fXmlFile);
//			XPathFactory xpf = XPathFactory.newInstance();
//			XPath path = xpf.newXPath();
//			int n = Integer.parseInt(path.evaluate("count(/plist/dict/dict/dict)", doc));
//			String title = path.evaluate("/plist/dict/dict/dict[" + i + "]/string[1]", doc);
//			String id = path.evaluate("/plist/dict/dict/dict[" + i + "]/integer[1]", doc);
//			String artist = path.evaluate("/plist/dict/dict/dict[" + i + "]/string[2]", doc);
//			int x = 0;
//			try {
//				x = Integer.parseInt(id);
//				System.out.println("ID:" + x);
//				System.out.println("Title:" + title);
//				System.out.println("Artist:" + artist);
//				Track t = new Track(x, title, artist);
//				System.out.println("Track created\n");
//				return t;
//			}
//			catch (Exception e) {
//				return null;
//			}
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//}
