package ch11;

public class TreeTest {
	public static void main(String[] args) {
//		Tree t1 = new PineTree();
		Tree t1 = new Maple();
		t1.leafShape();
	}
}
interface Tree{
	void leafShape();
}
class PineTree implements Tree{
	public void leafShape() {
		System.out.println("뾰족한 소나무 잎을 그린다.");
	}	
}
class Maple implements Tree{
	public void leafShape() {
		System.out.println("별모양의 단풍나무 잎을 그린다.");
	}	
}