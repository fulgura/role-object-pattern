/**
 * 
 */
package com.md.ddd.service;

import java.util.List;

import com.md.ddd.entity.Customer;
import com.md.ddd.entity.PersonCore;
import com.md.ddd.entity.PersonRole;

/**
 * @author diego
 * 
 */
public interface RoleService {

	public List<PersonCore> personCoreList() throws ServiceException;

	public List<Customer> customerList() throws ServiceException;

	public PersonCore save(PersonCore personCore) throws ServiceException;

	public <T extends PersonRole> T save(T personRole) throws ServiceException;

}
