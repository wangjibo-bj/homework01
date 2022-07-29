package geektime.spring.springbucks.model;


import java.math.BigDecimal;

public class Student {

	private String username;

	private BigDecimal score;

	public Student(String username, BigDecimal score) {
		this.username = username;
		this.score = score;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

}
