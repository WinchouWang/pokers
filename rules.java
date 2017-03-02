package poker;

import java.util.Comparator;

public class rules implements Comparator<poker> {

	@Override
	public int compare(poker o1, poker o2) {
		// TODO Auto-generated method stub
		String color[] = {"红桃","方片","梅花","黑桃"};
		String point[] = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		int temp1 = 0;
		int temp2 = 0;
		for (int i = 0; i < point.length; i++) {
			if(o1.point.equals(point[i]))
				temp1 += i*10;
			if(o2.point.equals(point[i]))
				temp2 += i*10;
		for (int j = 0; j < color.length; j++) {
			if (o1.color.equals(color[i])) 
				temp1 += i;
			if (o2.color.equals(color[i]))
				temp2 +=i ;
		}
		if (temp1 > temp2)
			return -1;
		if (temp1 < temp2)
			return 1;
		}
		return 0;
	}
}
