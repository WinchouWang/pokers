package poker;
import java.util.*;

public class RandomNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner console = new Scanner(System.in);
		
		System.out.println("how many numbers do you need draw?");
		int k = console.nextInt();
		
		System.out.println("what's the highest number you can draw?");
		int n = console.nextInt();
		
		int[] numbers = new int[n];
		for(int i = 0;i<numbers.length; i++)
			numbers[i] = i+1;
		
		int[] result = new int[k];
		for (int i = 0; i < result.length; i++) {
			int r = (int)(Math.random());
			result[i] = numbers[r];
			numbers[r] = numbers[n - 1];
			n--;
		}
		
		Arrays.sort(result);
		System.out.println("bet the following combination.You will win the life!");
		for(int r:result)
			System.out.println(r);
	}

}
