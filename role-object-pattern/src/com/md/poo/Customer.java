/**
 * 
 */
package com.md.poo;

/**
 * @author diego
 * 
 */
public class Customer extends PersonRole {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.md.poo.PersonRole#roleName()
	 */
	@Override
	public String roleName() {
		return this.getClass().getCanonicalName();
	}

}
