package com.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.model.Student;
import com.hibernate.util.HibernateUtil;

public class StudentDaon {
	Transaction tx = null;

	public void saveStudent(Student student) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start transaction
			tx = session.beginTransaction();
			// save student object
			session.save(student);
			// commit transaction
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Student> displayStudent() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Student", Student.class).list();
		}

	}

	public void updateStudent(Student student) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			tx = session.beginTransaction();
			session.saveOrUpdate(student);
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}

	}

	public void updateStudent2(int id, String email) {
		try (Session ses = HibernateUtil.getSessionFactory().openSession()) {
			tx = ses.beginTransaction();
			Query q2 = ses.createQuery("update Student set email=:mail where ID=:id");
			q2.setParameter("mail", email);
			q2.setParameter("id", id);
			int n2 = q2.executeUpdate();
			if (n2 > 0)
				System.out.println(n2 + " record updated");
			else
				System.out.println("record not found");
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			if (tx != null)
				tx.rollback();
		}

	}

	public void deleteStudent(int id) {

		try (Session ses = HibernateUtil.getSessionFactory().openSession()) {
			tx = ses.beginTransaction();
			Query q1 = ses.createQuery("delete from Student where ID=:x");
			q1.setParameter("x", id);
			int n = q1.executeUpdate();
			if (n > 0)
				System.out.println(n + " record deleted: ");
			else
				System.out.println("record not found: ");
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public void displayById(int id) {	
		try(Session ses=HibernateUtil.getSessionFactory().openSession()){
			tx=ses.beginTransaction();
			Query q3=ses.createQuery("from Student where id=:id2");
			q3.setParameter("id2", id);
			Student st=(Student) q3.getSingleResult();
			System.out.println(st.toString());
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}