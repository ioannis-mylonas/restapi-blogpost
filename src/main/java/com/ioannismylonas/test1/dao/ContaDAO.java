package app.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import app.model.Conta;

@Repository
public class ContaDAO implements IContaDAO {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public List<Conta> getContas() {
    Session session = sessionFactory.getCurrentSession();

    // Usando CriteriaBuilder
    CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery<Conta> cq = cb.createQuery(Conta.class);
    Root<Conta> root = cq.from(Conta.class);
    cq.select(root);

    return session.createQuery(cq).getResultList();

    /*
    // Usando JPQL
    return session
    .createQuery("SELECT c FROM app.model.Conta c")
    .getResultList();
    */
  }

  @Override
  public void saveConta(Conta obj) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(obj);
  }

  @Override
  public Conta getConta(Long id) {
    Session session = sessionFactory.getCurrentSession();
    return session.get(Conta.class, id);
  }

  @Override
  public void deleteConta(Long id) {
    Session session = sessionFactory.getCurrentSession();

    Conta conta = session.byId(Conta.class).load(id);
    session.delete(conta);
  }

  @Override
  public void deleteContas() {
    Session session = sessionFactory.getCurrentSession();

    // Usando CriteriaBuilder
    CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaDelete<Conta> cd = cb.createCriteriaDelete(Conta.class);

    cd.from(Conta.class);
    session.createQuery(cd).executeUpdate();

    /*
    // Usando JPQL
    session
    .createQuery("DELETE from app.model.Conta")
    .executeUpdate();
    */

    // Necessário para atualizar o cache da sessão
    session.flush();
    session.clear();
  }
}