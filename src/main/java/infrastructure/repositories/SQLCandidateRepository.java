package infrastructure.repositories;

import domain.CandidateRepository;
import domain.Canditate;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class SQLCandidateRepository implements CandidateRepository {
  @Override
  public void save(List<Canditate> canditates) {
  }

  @Override
  public List<Canditate> findAll() {
    return List.of();
  }
}
