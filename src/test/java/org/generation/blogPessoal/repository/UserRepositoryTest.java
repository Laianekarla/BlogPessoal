package org.generation.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import org.generation.blogPessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class UserRepositoryTest {

    private @Autowired UsuarioRepository repository;

    @Autowired
    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    @BeforeAll
    void start() {
        repository.save(new Usuario("Laiane","lanne","2317391"));
        repository.save(new Usuario("Laisa","laisss","27183"));
        repository.save(new Usuario("Breno","Badjj","217391"));
        repository.save(new Usuario("Silvlais","açdkiw","29818"));
    }

    @Test
    @DisplayName("Retorna 1 Usuario")
    void deveRetornaUmUsuario() {
        Usuario user = repository.findByUsuario("lanne").get();
        assertTrue(user.getUsuario().equals("lanne"));
    }



}
