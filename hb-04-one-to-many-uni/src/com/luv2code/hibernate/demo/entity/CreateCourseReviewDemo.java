package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseReviewDemo {

	public static void main(String[] args) {
		
SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
		Session session = factory.getCurrentSession();
		try
		{   
		   session.beginTransaction();
		   
		   Course tempCourse = new Course("How to be Satisfied and Happy");
		   
		   tempCourse.addReview(new Review("Very awesome"));
		   tempCourse.addReview(new Review("Most helpful"));
		   tempCourse.addReview(new Review("Not So good"));
		   
		   System.out.println("Printing course");
		   System.out.println(tempCourse);
		   System.out.println(tempCourse.getReviews());
		   
		   session.save(tempCourse);
		   
		   
		   
		   session.getTransaction().commit();
			
		}
		
		finally {
			
			factory.close();
			
		}

	}

}
