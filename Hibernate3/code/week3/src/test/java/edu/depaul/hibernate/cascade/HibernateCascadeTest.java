package edu.depaul.hibernate.cascade;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class HibernateCascadeTest {

	@Autowired
	private SessionFactory sessionFactory;

	@Test
	public void test() {

	}
}
