package testpckg;

import javax.persistence.*;

@Entity
public class B {

	private A a;
	private Integer id;

	public B() {
		this.a = new A("some a");
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

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
	}

}
