package com.serveeasy.dao.bar;

import com.serveeasy.model.bar.BarDetails;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 */
@Transactional
public interface BarDetailsDao {

    public static final String SPRING_BEAN_NAME = "barDetailsDao";

    //todo: redenumin in insert()
    void addBarDetails(BarDetails barDetails);

    //todo: hai sa redenumim in update()
    void modifyBarDetails(BarDetails barDetails);

    //todo: redenumim in find()
    BarDetails findBarDetails(int id);

    //todo: redenumin in delete()
    void deleteBarDetails(int id);
}
