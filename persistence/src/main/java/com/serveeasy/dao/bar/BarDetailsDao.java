package com.serveeasy.dao.bar;

import com.serveeasy.model.bar.BarDetails;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Transactional
public interface BarDetailsDao {

    public static final String SPRING_BEAN_NAME = "barDetailsDao";

    void insert(BarDetails barDetails);

    void update(BarDetails barDetails);

    BarDetails find(long id);

    void delete(long id);
}
