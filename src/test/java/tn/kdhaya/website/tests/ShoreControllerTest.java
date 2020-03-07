package tn.kdhaya.website.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.kdhaya.website.controllers.ShoreRestController;
import tn.kdhaya.website.entities.Shore;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ShoreControllerTest {

    @Autowired
    private ShoreRestController controller;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllBetweenTwoDates() {
//        List<Shore> shoreList = controller.getAllBetweenTwoDates("2019/09/21", "2019/09/23");
//        assertEquals(1, shoreList.size());
    }

    @Test
    public void getAllWithStatus() {

    }

    @Test
    public void cancelShore() {
    }
}