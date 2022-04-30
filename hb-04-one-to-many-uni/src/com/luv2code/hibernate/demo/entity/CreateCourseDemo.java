package com.luv2code.hibernate.demo.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import com.luv2code.employee.Employee;

public class CreateCourseDemo {

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
		   
		   Course course1 = new Course("The Classical Expert");
		   Course course2 = new Course("The Baking Course");
		   
		   tempInstructor.add(course1);
		   tempInstructor.add(course2);
		   
		   session.save(course1);
		   session.save(course2);
		   
		   session.getTransaction().commit();
			
		}
		
		finally {
			
			factory.close();
			
		}

	}

}
