package ro.fasttrackit.curs21.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.curs21.homework.model.Studio;

public interface StudioRepository extends JpaRepository<Studio, Integer> {
}
