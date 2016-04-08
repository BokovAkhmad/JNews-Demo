package jnews.repository;

import jnews.model.News;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Akhmat on 02.04.2016.
 */


public interface NewsRepository extends CrudRepository<News,Long> {

}
