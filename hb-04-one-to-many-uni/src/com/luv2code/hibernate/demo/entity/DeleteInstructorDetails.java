package com.luv2code.hibernate.demo.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import com.luv2code.employee.Employee;

public class DeleteInstructorDetails {

	public static void main(String[] args) {
		
SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
		Session session = factory.getCurrentSession();
		try
		{
			
			int instructorId = 1;
			session.beginTransaction();
			
			Instructor objInstructor = session.get(Instructor.class,instructorId);
			System.out.println("Printing value at id = 1" +objInstructor);
			
			if(objInstructor != null)
			{
				session.delete(objInstructor);
			}
			
			else {
				System.out.println("No data found");
			}
			
		
			
			session.getTransaction().commit();
			
		}
		
		finally {
			
			factory.close();
			
		}

	}

}
