/**
 * 
 */
package com.md.ddd.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 * @author diego
 *
 */
@Entity
@NamedQuery(name = "PersonCore.all", query = "SELECT PC FROM PersonCore PC")
public class PersonCore extends Person {

	private String name;

	
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

	public void addRole(PersonRole personRole){
		this.roleList.add(personRole);
	}
	
	public PersonRole getRole(Class<?> roleClass){
		for (PersonRole role : this.roleList) {
			if(role.getClass().equals(roleClass)){
				return role;
			}
		}
		return null;
	}
	
}
