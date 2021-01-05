package app.dao;

import java.util.List;
import app.model.Conta;

public interface IContaDAO {
  public List<Conta> getContas();

  public void saveConta(Conta obj);

  public Conta getConta(Long id);

  public void deleteConta(Long id);

  public void deleteContas();
}