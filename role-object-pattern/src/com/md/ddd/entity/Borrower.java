/**
 * 
 */
package com.md.ddd.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * @author diego
 *
 */
@Entity
@PrimaryKeyJoinColumn
@NamedQuery(name = "Borrower.all", query = "SELECT C FROM Borrower C")
public class Borrower extends PersonRole {

	private static final long serialVersionUID = 1L;

	/**
	 * All {@link Credit}s for this {@link Borrower}
	 */
	@OneToMany(cascade = CascadeType.ALL)
	private List<Credit> creditList = new ArrayList<Credit>();
	
	Borrower() {
		// ORM :(
	}
	
	/* (non-Javadoc)
	 * @see com.md.ddd.entity.PersonRole#roleName()
	 */
	@Override
	public String roleName() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Credit> getCreditList() {
		return creditList;
	}

	@Override
	public String toString() {
		return "Borrower [creditList=" + creditList + ", toString()="
				+ super.toString() + "]";
	}

	
}
