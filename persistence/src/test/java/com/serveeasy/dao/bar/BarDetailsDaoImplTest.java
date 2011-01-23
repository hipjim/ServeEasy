package com.serveeasy.dao.bar;

import com.serveeasy.dao.AbstractSpringTestCase;
import com.serveeasy.model.bar.BarDetails;
import com.serveeasy.utils.file.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;

/**
 *
 */
public class BarDetailsDaoImplTest extends AbstractSpringTestCase {

    @Autowired
    private BarDetailsDao dao;

    private byte[] imageContent;

    @Before
    public void init() {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("HardRockCafe.jpg");
        imageContent = FileUtils.open(in).toByteArray();
    }

    @Test
    public void testAddBarDetails() throws Exception {
        BarDetails bd = new BarDetails();
        bd.setBarName("testing bar");
        bd.setEmail("test@sss.com");
        bd.setImageFileContent(imageContent);
        bd.setImageName("Test name");
        bd.setImageFileMimeType("img/jpg");

        dao.insert(bd);

    }

    @Test
    public void testModifyBarDetails() throws Exception {
        BarDetails bd = new BarDetails();
        bd.setId(2);
        bd.setBarName("testing bar updated");
        bd.setEmail("test updated@sss.com");
        bd.setImageFileContent(imageContent);
        bd.setImageName("Test name");
        bd.setImageFileMimeType("img/jpg");


        dao.update(bd);
    }

    @Test
    public void testFindBarDetails() throws Exception {
        BarDetails bd = dao.find(2);
        System.out.println(bd);
        System.out.println(bd.getImageFileContent().length);
    }


    @Test
    public void testDelete() throws Exception {
        dao.delete(2);
    }
}
