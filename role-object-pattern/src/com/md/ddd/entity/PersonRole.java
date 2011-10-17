/**
 * 
 */
package com.md.ddd.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * It's a ComponentRole in the Role Object Pattern.<BR>
 * <b>Structure</b><BR>
 * - stores a reference to the decorated ComponentCore ( {@link PersonCore} )<BR>
 * - implements the Component interface ( {@link Person} ) by forwarding
 * requests to its core attribute.<BR>
 * 
 * @author diego
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class PersonRole implements Person {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();

	/**
	 * One-to-one unidirectional
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PERSON_CORE_ID")
	private PersonCore personCore;

	PersonRole() {
		// ORM :(
	}

	public PersonRole(PersonCore personCore) {
		this.personCore = personCore;
	}

	/**
	 * 
	 * @return a role name
	 */
	public abstract String roleName();

	public String getName() {
		return personCore.getName();
	}

	public Date getCreatedDate() {
		return personCore.getCreatedDate();
	}

	public void addRole(PersonRole personRole) {
		personCore.addRole(personRole);
	}

	public <T extends PersonRole> T getRole(Class<T> roleClass) {
		return personCore.getRole(roleClass);
	}

	public Long getId() {
		return id;
	}

	public PersonCore getPersonCore() {
		return personCore;
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
		PersonRole other = (PersonRole) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public boolean hasRole(Class<? extends PersonRole> roleClass) {
		return personCore.hasRole(roleClass);
	}

	public boolean removeRole(Class<? extends PersonRole> roleClass) {
		return personCore.removeRole(roleClass);
	}
}
