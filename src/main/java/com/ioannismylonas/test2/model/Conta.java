package app.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "CONTA")
public class Conta {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @NotNull
  @NotEmpty
  @Column(name = "nome")
  private String nome;

  @NotNull
  @NotEmpty
  @Email
  @Column(name = "email", unique = true)
  private String email;

  @NotNull
  @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$")
  @Column(name = "cpf", unique = true)
  private String cpf;

  @NotNull
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
  @Column(name = "dataNascimento")
  private LocalDate dataNascimento;

  public Conta() {}

  public Conta(String nome, String email, String cpf, LocalDate dataNascimento) {
    this.nome = nome;
    this.email = email;
    this.cpf = cpf;
    this.dataNascimento = dataNascimento;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public Long getId() {
    return this.id;
  }
    
  public String getNome() {
    return this.nome;
  }
    
  public String getEmail() {
    return this.email;
  }
    
  public String getCpf() {
    return this.cpf;
  }
    
  public LocalDate getDataNascimento() {
    return this.dataNascimento;
  }
    
  @Override
  public String toString() {
    return "Conta(id=" + this.id + ", nome='" + this.nome + "', email='" + this.email + "', cpf='" + this.cpf + "', dataNascimento='" + this.dataNascimento + "')";
  }
}