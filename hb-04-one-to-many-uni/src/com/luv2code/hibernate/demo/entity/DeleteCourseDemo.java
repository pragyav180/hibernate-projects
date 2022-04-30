package com.luv2code.hibernate.demo.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import com.luv2code.employee.Employee;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		
SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
		Session session = factory.getCurrentSession();
		try
		{   int theId = 1;
		   session.beginTransaction();
		   
		   Instructor tempInstructor = session.get(Instructor.class,theId);
		   
		   System.out.println("Printing the Instructor object" +tempInstructor);
		   
		   System.out.println("Getting all associated courses to given instructor" +tempInstructor.getCourses());
		   
		   
		   session.getTransaction().commit();
		   
		   System.out.println("Done");
			
		}
		
		finally {
			
			factory.close();
			
		}

	}

}
