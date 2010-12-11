package com.serveeasy.model.bar;

import com.serveeasy.model.AbstractTestCase;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: eu
 * Date: Nov 29, 2010
 * Time: 12:27:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class TableCollectionTest extends AbstractTestCase {

    @Test
    public void testCollection() {

        TableCollection tc = new TableCollection();
        Table t1 = new Table(3, "t1");
        Table t2 = new Table(3, "t2");
        Table t3 = new Table(3, "t3");
        Table t4 = new Table(3, "t4");
        Table t5 = new Table(3, "t5");
        tc.addTable(t1);
        tc.addTable(t2);
        tc.addTable(t3);
        tc.addTable(t4);
        tc.addTable(t5);

        assertEquals(5, tc.getTables().size());

        tc.removeTable(t3);

        assertEquals(4, tc.getTables().size());

        
    }

}
