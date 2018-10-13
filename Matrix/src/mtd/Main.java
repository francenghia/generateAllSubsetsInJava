package mtd;

public class Main {
	public static void main(String[] args) {
		
		Matrix matrix = new Matrix();
		
		matrix.loadData("D://graph.txt");
		
		matrix.ViewMatrix();
		
		matrix.PushDataIntoStack();
		
		
		
	}
}
