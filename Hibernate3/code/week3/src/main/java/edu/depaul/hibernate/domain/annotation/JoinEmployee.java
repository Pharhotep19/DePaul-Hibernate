package edu.depaul.hibernate.domain.annotation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class JoinEmployee {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private long id;
	private String name;

	public long getId() {
		return id;
	}
	public void setId(long newId) {
		id = newId;
	}

	public String getName() {
		return name;
	}
	public void setName(String newName) {
		name = newName;
	}
}