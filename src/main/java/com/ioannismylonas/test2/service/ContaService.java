package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.IContaDAO;
import app.model.Conta;
import app.exception.ContaNotFoundException;

@Service
public class ContaService implements IContaService {

  @Autowired
  private IContaDAO contaDAO;

  @Override
  public List<Conta> getContas() {
    return contaDAO.findAll();
  }

  @Override
  public void saveConta(Conta obj) {
    contaDAO.saveAndFlush(obj);
  }

  @Override
  public Conta getConta(Long id) {
    return contaDAO.findById(id).orElseThrow(ContaNotFoundException::new);
  }

  @Override
  public void deleteConta(Long id) {
    contaDAO.deleteById(id);
  }

  @Override
  public void deleteContas() {
    contaDAO.deleteAllInBatch();
  }
}