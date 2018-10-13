package mtd;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Matrix {
	public int[][] arr;

	public Matrix() {
		super();
	}

	public Matrix(int[][] arr) {
		super();
		this.arr = arr;
	}

	public boolean loadData(String filePath) {

		Path path = Paths.get(filePath);
		Charset charset = Charset.forName("US-ASCII");
		try {
			BufferedReader br = Files.newBufferedReader(path, charset);

			String line = null;
			int count = 0;
			while ((line = br.readLine()) != null) {
				String k[] = line.split(" ");
				if (k.length == 1) {
					arr = new int[Integer.parseInt(k[0])][Integer.parseInt(k[0])];
				} else {
					for (int i = 0; i < k.length; i++) {
						arr[count][i] = Integer.parseInt(k[i]);
					}
					count++;
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public void ViewMatrix() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();

		}

	}

	public void PushDataIntoStack() {
		Stacks stack = new Stacks(arr.length, 100);

		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < arr.length; j++) {
				stack.push(j, arr[i][j]);
			}
		}

		System.out.println(stack.pop(0));
		System.out.println(stack.pop(0));
		System.out.println(stack.pop(1));
		
		sortStack(stack);
	}

	private void sortStack(Stacks stack) {
		
	}
	
	

}
