package domain;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
    List<Canditate> canditates = Instancio.stream(Canditate.class).limit(10).toList();
    when(repository.findAll()).thenReturn(canditates);

    List<Canditate> result = service.findAll();

    verify(repository).findAll();
    verifyNoMoreInteractions(repository);

    assertEquals(canditates, result);
  }

  @Test
  void findById_whenCandidateIsFound_returnsCandidate() {
    Canditate canditate = Instancio.create(Canditate.class);
    when(repository.findById(canditate.id())).thenReturn(Optional.of(canditate));

    Canditate result = service.findById(canditate.id());

    verify(repository).findById(canditate.id());
    verifyNoMoreInteractions(repository);

    assertEquals(canditate, result);
  }

  @Test
  void findById_whenCandidateIsNotFound_throwsException() {
    Canditate canditate = Instancio.create(Canditate.class);
    when(repository.findById(canditate.id())).thenReturn(Optional.empty());

    assertThrows(NoSuchElementException.class, () -> service.findById(canditate.id()));

    verify(repository).findById(canditate.id());
    verifyNoMoreInteractions(repository);
  }

}