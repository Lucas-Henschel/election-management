package domain;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CandidateRepository {
  void save(List<Canditate> canditates);
  default void save(Canditate canditate) {
    save(List.of(canditate));
  }

  List<Canditate> find(CandidateQuery query);

  default List<Canditate> findAll() {
    return find(new CandidateQuery.Builder().build());
  };

  default Optional<Canditate> findById(String id) {
    CandidateQuery query = new CandidateQuery.Builder().ids(Set.of(id)).build();
    return find(query).stream().findFirst();
  };
}
