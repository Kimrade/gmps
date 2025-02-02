package org.kimrade.gmps.repository;

import org.kimrade.gmps.domain.Label;
import org.kimrade.gmps.repository.search.LabelSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepository extends JpaRepository<Label, Integer>, LabelSearch {

}
