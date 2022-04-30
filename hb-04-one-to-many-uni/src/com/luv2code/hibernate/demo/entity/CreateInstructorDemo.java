package com.luv2code.hibernate.demo.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import com.luv2code.employee.Employee;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
		Session session = factory.getCurrentSession();
		try
		{   
		   
			Instructor tempInstructor = new Instructor("Pete","Becker","Pete@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("Wrestling","Boxing");
			tempInstructor.setInstructordetail(tempInstructorDetail);
			 session.beginTransaction();
		    session.save(tempInstructor);
			
			System.out.println("printing the value"+tempInstructor);
			
			session.getTransaction().commit();
			
		}
		
		finally {
			
			factory.close();
			
		}

	}

}
