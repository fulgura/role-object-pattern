/**
 * 
 */
package com.md.ddd.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * It's a ComponentCore in the Role Object Pattern.<BR>
 * <b>Structure</b><BR>
 * - implements the Component interface ({@link Person}) including the role
 * management protocol<BR>
 * - creates ConcreteRole instances.<BR>
 * - manages its role objects.
 * 
 * @author diego
 * 
 */
@Entity
@Table(name = "PERSON_CORE")
@NamedQuery(name = "PersonCore.all", query = "SELECT PC FROM PersonCore PC")
public class PersonCore implements Person {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "ID")
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATE_DATE")
	private Date createdDate = new Date();

	@Column(name = "NAME")
	private String name;

	/**
	 * All {@link PersonRole}s for this {@link PersonCore}
	 */
	@OneToMany(cascade = CascadeType.ALL)
	@Column(name = "ROLE_LIST")
	private Set<PersonRole> roleList;

	PersonCore() {
		// ORM :(
		this.roleList = new HashSet<PersonRole>();
	}

	public PersonCore(String name) {
		super();
		this.name = name;
		this.roleList = new HashSet<PersonRole>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void addRole(PersonRole personRole) {
		this.roleList.add(personRole);
	}

	@Override
	public <T extends PersonRole> T getRole(Class<T> roleClass) {
		for (PersonRole role : this.roleList) {
			if (role.getClass().equals(roleClass)) {
				return (T) role;
			}
		}
		return null;
	}

	@Override
	public boolean hasRole(Class<? extends PersonRole> roleClass) {

		for (PersonRole role : this.roleList) {
			if (role.getClass().equals(roleClass)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeRole(Class<? extends PersonRole> roleClass) {
		// TODO Auto-generated method stub
		return false;
	}

	public Long getId() {
		return id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public Set<PersonRole> getRoleList() {
		return roleList;
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
		PersonCore other = (PersonCore) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
