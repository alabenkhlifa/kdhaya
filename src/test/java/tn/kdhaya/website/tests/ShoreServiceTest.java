package tn.kdhaya.website.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.kdhaya.website.entities.*;
import tn.kdhaya.website.enums.ShoreStatus;
import tn.kdhaya.website.enums.SteedShift;
import tn.kdhaya.website.repositories.*;
import tn.kdhaya.website.services.IMenuItemService;
import tn.kdhaya.website.services.IShoreService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ShoreServiceTest {

//    @Autowired
//    private IMenuItemService menuItemService;
//
//    @Autowired
//    private DipatcherRepository dipatcherRepository;
//
//    @Autowired
//    private SteedRepository steedRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private ShoreCategoryRepository shoreCategoryRepository;
//
//    @Autowired
//    private ShoreItemsRepository shoreItemsRepository;
//
//    @Autowired
//    private ProviderRepository providerRepository;
//
//    @Autowired
//    private IShoreService service;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findAllByStatus() {
    }

    @Test
    public void cancel() throws Exception {
//        service.cancel(1L);
//        Shore shore = service.findById(1L);
//        assertNotNull(shore.getCancelDate());
    }

    @Test
    public void takeCharge() {
    }

    @Test
    public void findByCreationDateBetween() {
//        Date beginDate = new Date();
//        beginDate.setDate(24);
//        beginDate.setMonth(9);
//        beginDate.setYear(2019);
//        Date endDate = new Date();
//        endDate.setDate(27);
//        endDate.setMonth(9);
//        endDate.setYear(2019);
//        List<Shore> byCreationDateBetween = service.findByCreationDateBetween(beginDate, endDate);
//        System.out.println("byCreationDateBetween = " + byCreationDateBetween);
//        assertNotNull(byCreationDateBetween);
    }
}