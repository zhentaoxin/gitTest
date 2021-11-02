package 平时作业;
import java.util.*;
interface IParking{
	public void print();
	public boolean addCar(int carType);
	public static IParams parse() throws Exception{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine().toString();
		String ar[]=s.split("[^0-9]");
		ArrayList<Integer> list1=new ArrayList<Integer>();
		while(sc.hasNextInt()) {
			list1.add(Integer.parseInt(sc.next()));
		}
		IParams params=new IParams() {
			Integer big=list1.get(0);
			Integer medium=list1.get(1);
			Integer small=list1.get(2);
			public int getBig() {
				return big;
			}
			public int getMedium() {
				return medium;
			}
			public int getSmall() {
				return small;
			}
			public ArrayList<Integer> getPlanParking(){
				ArrayList<Integer> list2=new ArrayList<Integer>();
				for(int i=3;i<list1.size();i++) {
				    list2.add(list1.get(i));
				   }
				return list2;
			}
		};
		return params;
	}
}
interface IParams{
	public int getBig();
	public int getMedium();
	public int getSmall();
	public ArrayList<Integer> getPlanParking();
}
public class ParkingSystem implements IParking {
	int big,medium,small;
	ParkingSystem(int big,int medium,int small){
		this.big=big;
		this.medium=medium;
		this.small=small;
	}
	String s1;
	String[] s2=null;
	String []parse(String input) {
		s1+=input+" ";
		s2=s1.split("[^0-9]");
		return s2;
	}
	public boolean addCar(int carT){
		if(carT==1&&big>0) {
			big--;
			parse("true");
			return true;
		}
		else if(carT==2&&medium>0) {
			medium--;
			parse("true");
			return true;
		}
		else if(carT==3&&small>0) {
			small--;
			parse("true");
			return true;
		}
		parse("false");
		return false;
	}
	public static void main(String[] args)throws Exception{
		
		System.out.println("请输入：");
		IParams params=IParking.parse();
		ParkingSystem ps=new ParkingSystem(params.getBig(),params.getMedium(),params.getSmall());
		ArrayList<Integer> plan=params.getPlanParking();
		for(int i=0;i<plan.size();i++) {
			ps.addCar(plan.get(i));
		}
		ps.print();
	}
	public void print() {
		System.out.println(s2);
	}
}