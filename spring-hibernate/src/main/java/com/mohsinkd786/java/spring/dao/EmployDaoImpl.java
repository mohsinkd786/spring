package com.mohsinkd786.java.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.mohsinkd786.java.spring.entity.Employ;

@Repository
public class EmployDaoImpl implements EmployDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void add(Employ emp) {
		em.merge(emp);
	}

	@Override
	public List<Employ> findAll() {
		CriteriaQuery<Employ> criteriaQuery = em.getCriteriaBuilder().createQuery(Employ.class);
		@SuppressWarnings("unused")
		Root<Employ> root = criteriaQuery.from(Employ.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public void update(Employ emp) {
		em.merge(emp);
	}
}