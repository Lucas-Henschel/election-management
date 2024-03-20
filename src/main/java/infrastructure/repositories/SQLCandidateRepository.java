package infrastructure.repositories;

import domain.CandidateQuery;
import domain.CandidateRepository;
import domain.Candidate;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class SQLCandidateRepository implements CandidateRepository {
  @Override
  public void save(List<Candidate> candidates) {
  }

  @Override
  public List<Candidate> find(CandidateQuery query) {
    return List.of();
  }
}
