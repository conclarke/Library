package utils;

import java.io.File;
import javax.ejb.Local;
import entities.Track;

@Local
public interface ParserInterface {

	int getTrackCount(File f);

	Track readTrackInfo(int i);
}
