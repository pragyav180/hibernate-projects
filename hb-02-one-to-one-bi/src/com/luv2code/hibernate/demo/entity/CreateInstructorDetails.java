package com.luv2code.hibernate.demo.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import com.luv2code.employee.Employee;

public class CreateInstructorDetails {

	public static void main(String[] args) {
		
SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
		Session session = factory.getCurrentSession();
		try
		{   int theId;
		    session.beginTransaction();
			Instructor tempInstructor = new Instructor("Harley","Quinn","Harley@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("DoctorExpress","Counselling");
			tempInstructor.setInstructordetail(tempInstructorDetail);
			
		    session.save(tempInstructor);
			
			System.out.println("printing the value"+tempInstructor);
			
			
			
		
			
			session.getTransaction().commit();
			
		}
		
		finally {
			
			factory.close();
			
		}

	}

}
