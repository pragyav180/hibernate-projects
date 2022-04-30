package com.luv2code.hibernate.demo.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import com.luv2code.employee.Employee;

public class DeleteInstructorDetailsNew {

	public static void main(String[] args) {
		
SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
		Session session = factory.getCurrentSession();
		try
		{   session.beginTransaction();
		   
		int theId = 400;
		
		InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class,theId);
		System.out.println("Print tempInstructorDetail: "+tempInstructorDetail);
		System.out.println("Get associated Instructor: " +tempInstructorDetail.getInstructor());	
			
		session.getTransaction().commit();
			
		}
		
		/*catch(Exception exc) {
			exc.printStackTrace();
		}*/
		
		finally {
			
			//session.close();
			factory.close();
			
		}

	}

}
