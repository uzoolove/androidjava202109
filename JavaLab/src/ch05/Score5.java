package ch05;

public class Score5 {
	private int kor;
	private int eng;
	private int math;
	
	public Score5(int kor, int eng, int math){
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	// setter
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	// getter
	public int getKor() {
		return this.kor;
	}		
	

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		if(math > 100) math = 100;
		this.math = math;
	}

	private int sum() {
		int total = kor + eng + math;
		return total;
	}
	
	public double avg() {		
		double result = sum() / 3.0;
		return result;
	}
	
	public String toString() {
		return "Score5 [kor: " + kor + ", eng: " + eng + ", math: " + math + "]";
	}
}
