package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.IContaDAO;
import app.model.Conta;

@Service
public class ContaService implements IContaService {

  @Autowired
  private IContaDAO contaDAO;

  @Override
  @Transactional
  public List<Conta> getContas() {
    return contaDAO.getContas();
  }

  @Override
  @Transactional
  public void saveConta(Conta obj) {
    contaDAO.saveConta(obj);
  }

  @Override
  @Transactional
  public Conta getConta(Long id) {
    return contaDAO.getConta(id);
  }

  @Override
  @Transactional
  public void deleteConta(Long id) {
    contaDAO.deleteConta(id);
  }

  @Override
  @Transactional
  public void deleteContas() {
    contaDAO.deleteContas();
  }
}