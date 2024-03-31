package infrastructure.repositories;

import domain.Election;
import domain.ElectionRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

@ApplicationScoped
public class SQLElectionRepository implements ElectionRepository {
  private final EntityManager entityManager;

  public SQLElectionRepository(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public void submit(Election election) {
     infrastructure.repositories.entities.Election entity = infrastructure.repositories.entities.Election.fromDomain(election);
     entityManager.merge(entity);

    election.votes()
      .entrySet()
      .stream()
      .map(entry -> infrastructure.repositories.entities.ElectionCandidate.fromDomain(election, entry.getKey(), entry.getValue()))
      .forEach(entityManager::merge);
  }
}
