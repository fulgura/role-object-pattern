/**
 * 
 */
package com.md.poo;

import static org.junit.Assert.fail;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.openejb.api.LocalClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author diego
 * 
 */
@LocalClient
public class SimpleTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Properties p = new Properties();
		p.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.apache.openejb.client.LocalInitialContextFactory");
		p.put("lastfmDatabase", "new://Resource?type=DataSource");
		p.put("lastfmDatabase.JdbcDriver", "org.postgresql.Driver");
		p.put("lastfmDatabase.JdbcUrl", "jdbc:postgresql://localhost/role-pattern");
		p.put("lastfmDatabase.UserName", "rp");
		p.put("lastfmDatabase.Password", "rp");

		InitialContext initialContext = new InitialContext(p);
		initialContext.bind("inject", this);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void test() {
		fail("Not yet implemented"); // TODO
	}

}
