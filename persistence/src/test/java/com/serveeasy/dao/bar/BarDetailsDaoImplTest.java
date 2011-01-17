package com.serveeasy.dao.bar;

import com.serveeasy.dao.AbstractSpringTestCase;
import com.serveeasy.model.bar.BarDetails;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.FileInputStream;

/**
 *
 */
public class BarDetailsDaoImplTest extends AbstractSpringTestCase {

    @Autowired
    private BarDetailsDao dao;

    @Test
    public void testAddBarDetails() throws Exception {

        BarDetails bd = new BarDetails();
        bd.setBarName("testing bar");
        bd.setEmail("test@sss.com");
        File f = new File("C:\\Users\\eu\\Desktop\\3.jpg");
        byte[] content = new byte[(int) f.length()];
        new FileInputStream(f).read(content);
        bd.setImageFileContent(content);
        bd.setImageName(f.getName());
        bd.setImageFileMimeType(new MimetypesFileTypeMap().getContentType(f));

        dao.insert(bd);

    }

    @Test
    public void testModifyBarDetails() throws Exception {
        BarDetails bd = new BarDetails();
        bd.setId(2);
        bd.setBarName("testing bar updated");
        bd.setEmail("test updated@sss.com");
        File f = new File("C:\\Users\\eu\\Desktop\\4.jpg");
        byte[] content = new byte[(int) f.length()];
        new FileInputStream(f).read(content);
        bd.setImageFileContent(content);
        bd.setImageName(f.getName());
        bd.setImageFileMimeType(new MimetypesFileTypeMap().getContentType(f));


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
