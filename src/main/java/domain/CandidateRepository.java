package domain;

import java.util.List;

public interface CandidateRepository {
  void save(List<Canditate> canditates);
  default void save(Canditate canditate) {
    save(List.of(canditate));
  }

  List<Canditate> findAll();
}
