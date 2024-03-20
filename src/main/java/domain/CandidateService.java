package domain;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CandidateService {
  private final CandidateRepository repository;

  public CandidateService(CandidateRepository repository) {
    this.repository = repository;
  }

  public void save(Canditate canditate) {
    repository.save(canditate);
  }

  public List<Canditate> findAll() {
    return repository.findAll();
  }
}
