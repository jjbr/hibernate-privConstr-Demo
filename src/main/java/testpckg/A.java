package testpckg;

import javax.persistence.*;

@Entity
public class A {

	private Integer id;
	String someString;

	// This private modifier causes the issue.
	private A() {
		someString = "Empty";
	}

	public A(String s) {
		this.someString = s;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
