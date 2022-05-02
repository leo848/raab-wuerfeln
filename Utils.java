import java.util.*;
public class Utils {
	static Scanner scanner = new Scanner(System.in);
	static void print(String str){
		System.out.println(str);
	}
	static void print() {
		print("");
	}
	static void print(int times) {
		for (int i = 0; i < times; i++) print();
	}
	static void printr(String str) {
		System.out.print(str + "\r");
	}
	static String input(String str){
		System.out.print(str);
		return scanner.nextLine();
	}
}
