package com.serveeasy.dao.bar;

import com.serveeasy.dao.DaoRepository;
import com.serveeasy.model.bar.BarDetails;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 */
public class BarDetailsDaoImplTest {

    private BarDetailsDao dao;

    @Before
    public void setUp() throws Exception {
         ApplicationContext ctx = new ClassPathXmlApplicationContext("com/serveeasy/context/applicationContext.xml");


        DaoRepository repository = (DaoRepository) ctx.getBean("daoRepository");
        dao = repository.getBarDetailsDao();
    }

    @Test
    public void testAddBarDetails() throws Exception {

        BarDetails bd = new BarDetails();
        bd.setBarName("testing bar");
        bd.setEmail("test@sss.com");
//        bd.setImageFile(new File("C:\\Users\\eu\\Desktop\\t.jpg"));

        dao.addBarDetails(bd);

    }

    @Test
    public void testModifyBarDetails() throws Exception {
        BarDetails bd = new BarDetails();
        bd.setBarName("new testing bar");
        bd.setEmail("newtest@sss.com");


        dao.modifyBarDetails(bd, 2);
    }
}
