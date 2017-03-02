package poker;
import java.util.*;

public class StartGame {
	String point[] = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	String color[] = {"红桃","方片","梅花","黑桃"};
	Scanner kb = new Scanner(System.in);
	List<poker> pokerList= new ArrayList<>();
	List<gamer> playerList = new ArrayList<>();
	
	public void createPoker(){
		for (int i = 0; i < color.length; i++) {
			for (int j = 0; j < point.length; j++) {
				pokerList.add(new poker(color[i], point[j]));
			}
		}
		System.out.println("-------------------游戏准备就绪-----------------------");
		int i = 0;
		for(poker poker : pokerList){
			System.out.println(poker.color + poker.point + " ");
			i++;
			if(i%13==0)
				System.out.println(" ");
		}
	}
	
	public void shuffle(){
		System.out.println("--------------------开始洗牌-----------------------------");
		Collections.shuffle(pokerList);
		System.out.println("--------------------洗牌完毕-----------------------------");
	}
	
	public void sort(){
		Collections.sort(playerList.get(0).handcards,new rules());
		Collections.sort(playerList.get(1).handcards,new rules());
		System.out.println(playerList.get(0).name + "最大手牌" + playerList.get(0).handcards.get(0).color + playerList.get(0).handcards.get(0).point);
		System.out.println(playerList.get(1).name + "最大手牌" + playerList.get(1).handcards.get(0).color + playerList.get(1).handcards.get(0).point);
	}
	
	public void print(){
		System.out.println("--------------------玩家各自手牌------------------------");
		for(gamer gamer:playerList)
		{
			System.out.println(gamer.name+":");
			for(poker poker: gamer.handcards)
			{
				System.out.println("["+poker.color+poker.point+"]");
			}
		}
	}
	
	public void comparePoint(){
		System.out.println("---------------------获胜方-----------------------------");
		List<poker> maxPokers = new ArrayList<poker>();
		List<poker> minPokers = new ArrayList<poker>();
		maxPokers.add(playerList.get(0).handcards.get(0));
		maxPokers.add(playerList.get(1).handcards.get(0));
		minPokers.add(playerList.get(0).handcards.get(1));
		minPokers.add(playerList.get(1).handcards.get(1));
		Collections.sort(maxPokers,new rules());
		Collections.sort(minPokers,new rules());
		
		if(maxPokers.get(0).point.equals(maxPokers.get(1).point)){
			if (minPokers.get(0).point.equals(minPokers.get(1).point)) {
					if (maxPokers.get(0).equals(playerList.get(0).handcards.get(0))) {
						System.out.println("玩家1胜利！");
					}else{
						System.out.println("玩家2胜利！");
				}
			}else{
					if (minPokers.get(0).equals(playerList.get(0).handcards.get(1))) {
						System.out.println("玩家1胜利！");
					}else{
						System.out.println("玩家2胜利！");
					}
				}
			}else if(maxPokers.get(0).equals(playerList.get(0).handcards.get(0)))
			{
					System.out.println("玩家1胜利！");
			}else{
					System.out.println("玩家2胜利！");
			}
	}
	
	public void gamerSet(){
		System.out.println("--------------------创建两名玩家---------------------------");
		for(int i=1;i<=2;i++){
			System.out.println("输入玩家"+i+"的ID：");
			int id=0;
			try{
				id = scanf();
			}catch(Exception e){
				System.out.println(e.getMessage());
				i--;
				continue;
			}
			System.out.println("输入玩家"+i+"的姓名:");
			String name = kb.next();
			playerList.add(new gamer(id, name));
		}
		kb.close();
		System.out.println("-----------------GameStart!----------------------\n玩家1\t玩家2");
		for(gamer gamer:playerList)
			System.out.println(gamer.name+"\t");
	}
	
	public int scanf() throws Exception{
		try{
			int in = kb.nextInt();
			return in;
		}catch(Exception e){
			kb = new Scanner(System.in);
			throw new Exception("请输入正确的id！");
		}
	}
	
	public void deal(){
		System.out.println("\n--------------开始发牌------------------");
		System.out.println(playerList.get(0).name+"拿牌");
		playerList.get(0).handcards.add(pokerList.get(0));
		System.out.println(playerList.get(1).name+"拿牌");
		playerList.get(1).handcards.add(pokerList.get(1));

		System.out.println(playerList.get(0).name+"拿牌");
		playerList.get(0).handcards.add(pokerList.get(2));
		System.out.println(playerList.get(1).name+"拿牌");
		playerList.get(1).handcards.add(pokerList.get(3));
		System.out.println("-----------------发牌结束-----------------");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("----------------欢迎进入纸牌游戏！-----------------");
		StartGame sg = new StartGame();
		sg.createPoker();
		sg.shuffle();
		sg.gamerSet();
		sg.deal();
		sg.sort();
		sg.comparePoint();
		sg.print();
		System.out.println("----------------游戏结束！-------------------------");
	}
}
