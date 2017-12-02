package com.ipiecoles.java.javaeval.repository;

import com.ipiecoles.java.javaeval.model.Entreprise;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EntrepriseRepository <T extends Entreprise> extends PagingAndSortingRepository<T, Long>
{

}
