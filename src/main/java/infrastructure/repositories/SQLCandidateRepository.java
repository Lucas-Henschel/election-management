package infrastructure.repositories;

import domain.CandidateQuery;
import domain.CandidateRepository;
import domain.Canditate;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class SQLCandidateRepository implements CandidateRepository {
  @Override
  public void save(List<Canditate> canditates) {
  }

  @Override
  public List<Canditate> find(CandidateQuery query) {
    return List.of();
  }
}
