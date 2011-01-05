package com.serveeasy.dao.bar;

import com.serveeasy.model.bar.BarDetails;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Transactional
public interface BarDetailsDao {

    public static final String SPRING_BEAN_NAME = "barDetailsDao";

    void addBarDetails(BarDetails barDetails);

    void modifyBarDetails(BarDetails barDetails, int id);

    BarDetails findBarDetails(int id);
}
