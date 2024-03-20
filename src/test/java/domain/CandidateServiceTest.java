package domain;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import static org.mockito.Mockito.verify;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@QuarkusTest
class CandidateServiceTest {
  @Inject
  CandidateService service;

  @InjectMock
  CandidateRepository repository;

  @Test
  void save() {
    Canditate canditate = Instancio.create(Canditate.class);
    service.save(canditate);

    verify(repository).save(canditate);
    verifyNoMoreInteractions(repository);
  }

  @Test
  void findAll() {
    service.findAll();
  }

}