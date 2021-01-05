package app.controller;

import java.util.List;

import app.model.Conta;
import app.service.IContaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.BindingResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.validation.Valid;

@RestController
public class ContaController {

  @Autowired
  private IContaService contaService;

  @GetMapping("/conta")
  public List<Conta> getConta() {
    return contaService.getContas();
  }

  @GetMapping("/conta/{id}")
  public Conta getContaId(@PathVariable Long id) {
    Conta conta = contaService.getConta(id);
    if (conta == null) // Se nenhuma conta foi encontrada
      throw new ResponseStatusException(HttpStatus.NOT_FOUND); // Mostrar que nenhuma conta foi encontrada

    return conta;

  }

  @PostMapping("/conta")
  public void postConta(@Valid @RequestBody Conta conta, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) // Se existirem erros na validação
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST); // Mostrar que há erro no pedido

    contaService.saveConta(conta); // Caso contrário, salvar conta

  }

  @PutMapping("/conta/{id}")
  public void putConta(@PathVariable Long id, @Valid @RequestBody Conta conta,
    BindingResult bindingResult) {
    Conta alvo = contaService.getConta(id);

    if (alvo == null) // Se o ID não pertence a nenhuma conta
      throw new ResponseStatusException(HttpStatus.NOT_FOUND); // Mostrar que nenhuma conta foi encontrada

    if (bindingResult.hasErrors()) // Se existirem erros na validação
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST); // Mostrar que há erro no pedido

    alvo.setNome(conta.getNome());
    alvo.setEmail(conta.getEmail());
    alvo.setCpf(conta.getCpf());
    alvo.setDataNascimento(conta.getDataNascimento());

    contaService.saveConta(alvo);

  }

  @DeleteMapping("/conta/{id}")
  public void deleteContaId(@PathVariable Long id) {
    contaService.deleteConta(id);
  }

  @DeleteMapping("/conta")
  public void deleteConta() {
    contaService.deleteContas();
  }
}