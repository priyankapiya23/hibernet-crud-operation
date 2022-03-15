package com.hibernate.main;

import java.util.List;

import com.hibernate.dao.StudentDaon;
import com.hibernate.model.Student;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDaon stDao=new StudentDaon();
	   // Student student=new Student("piya","ku","piya@gmail.com");
	   // stDao.saveStudent(student);
		
		System.out.println("Student Information:");
		List<Student> stud1=stDao.displayStudent();
		for(Student std: stud1) {
			System.out.println(std);
		}
		
		//Student student1=new Student("riya","yd","riya@gmail.com");
	   // stDao.updateStudent(student1);
		
	stDao.deleteStudent(3);
		
	stDao.updateStudent2(4, "satish30@gmail.com");
		
	stDao.displayById(1);
		 stDao.displayStudent(); 
		
	}

}
