package poker;

import java.util.ArrayList;
import java.util.List;

public class gamer {
	public int id;
	public String name;
	public List<poker> handcards = new ArrayList<poker>();
	
	public gamer(int id,String name){
		this.id = id;
		this.name = name;
	}
}
