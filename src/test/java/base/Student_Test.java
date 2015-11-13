package base;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.StudentDomainModel;

public class Student_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		StudentDomainModel s = new StudentDomainModel("Brian", "Patrick", "Dawkins", new Date(1973, 10, 13));
		
		s.getFirstName();
		s.getMiddleName();
		s.getLastName();
		s.getDOB();
		s.getStudentID();
		
		System.out.println(s.getFirstName());
		System.out.println(s.getMiddleName());
		System.out.println(s.getLastName());
		System.out.println(s.getDOB());
		System.out.println(s.getStudentID());
		
		assertEquals(s.getFirstName(), "Brian");
		assertEquals(s.getMiddleName(), "Patrick");
		assertEquals(s.getLastName(), "Dawkins");
		assertEquals(s.getDOB(), new Date(1973, 10, 13));
	}

}
