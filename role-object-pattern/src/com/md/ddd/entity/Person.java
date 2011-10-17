/**
 * 
 */
package com.md.ddd.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author diego
 * 
 */
@Entity
@NamedQuery(name = "Person.all", query = "SELECT P FROM Person P")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();

	Person() {
		// ORM nedeed :(
	}

	public Long getId() {
		return id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
