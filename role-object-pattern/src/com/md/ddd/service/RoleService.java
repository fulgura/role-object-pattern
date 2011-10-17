/**
 * 
 */
package com.md.ddd.service;

import java.util.List;

import com.md.ddd.entity.Customer;
import com.md.ddd.entity.PersonCore;

/**
 * @author diego
 * 
 */
public interface RoleService {

	public List<PersonCore> personCoreList() throws ServiceException;

	public List<Customer> allCustomer() throws ServiceException;

	public PersonCore save(PersonCore personCore) throws ServiceException;

	public Customer save(Customer customer) throws ServiceException;

}
