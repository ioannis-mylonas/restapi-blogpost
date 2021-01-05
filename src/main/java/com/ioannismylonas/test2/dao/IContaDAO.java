package app.dao;

import app.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContaDAO extends JpaRepository<Conta, Long> {}