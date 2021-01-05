package app.exception;

import java.lang.RuntimeException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ContaNotFoundException extends RuntimeException {
  // Declarar static final Long serialVersionUID

  public ContaNotFoundException() {
    super();
  }

  public ContaNotFoundException(String mensagem) {
    super(mensagem);
  }

  public ContaNotFoundException(Throwable causa) {
    super(causa);
  }

  public ContaNotFoundException(String mensagem, Throwable causa) {
    super(mensagem, causa);
  }
}