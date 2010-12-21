package com.serveeasy.dao.bar;

import com.serveeasy.model.bar.BarDetails;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Transactional
public interface BarDetailsDao {

    public static final String SPRING_BEAN_NAME = "barDetailsDao";

    public abstract void addBarDetails(BarDetails barDetails);

    public abstract void modifyBarDetails(BarDetails barDetails, int id);
}
