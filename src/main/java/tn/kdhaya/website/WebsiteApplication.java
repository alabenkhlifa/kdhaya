package tn.kdhaya.website;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.kdhaya.website.entities.*;
import tn.kdhaya.website.enums.ShoreStatus;
import tn.kdhaya.website.enums.SteedShift;
import tn.kdhaya.website.repositories.DipatcherRepository;
import tn.kdhaya.website.repositories.ShoreItemsRepository;
import tn.kdhaya.website.repositories.SteedRepository;
import tn.kdhaya.website.repositories.UserRepository;
import tn.kdhaya.website.services.*;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.util.*;

@SpringBootApplication
@Log
public class WebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteApplication.class, args);
    }

    @Bean
    CommandLineRunner populateDatabase(
            IShoreService shoreService,
            SteedRepository steedRepository,
            UserRepository userRepository,
            ShoreItemsRepository shoreItemsRepository,
            DipatcherRepository dipatcherRepository,
            IShoreCategoryService shoreCategoryService,
            IProviderService providerService,
            IMenuService menuService,
            IMenuItemService menuItemService) {
        return args -> {
            Provider mixMax = new Provider(null, "MinMAX", "Fontaine", "Bassem", new Date(), null, 0L);
            Menu mixMAXMenu = new Menu(null, new Date(), mixMax);
            MenuItem item1 = new MenuItem(null, "Escalope Panée", 5.5, "Sandwich", null, mixMAXMenu);
            MenuItem item2 = new MenuItem(null, "Escalope Grillé", 5.0, "Sandwich", null, mixMAXMenu);
            MenuItem item3 = new MenuItem(null, "Tacos", 5.0, "Sandwich", null, mixMAXMenu);
            MenuItem item4 = new MenuItem(null, "Tandori", 6.0, "Sandwich", null, mixMAXMenu);
            MenuItem item5 = new MenuItem(null, "4 saisons", 12.0, "Pizza", null, mixMAXMenu);
            MenuItem item6 = new MenuItem(null, "Fromage", 10.0, "Pizza", null, mixMAXMenu);
            MenuItem item7 = new MenuItem(null, "Thon", 9.0, "Pizza", null, mixMAXMenu);

            List<MenuItem> menuItemList = new ArrayList<>();
            menuItemList.add(item1);
            menuItemList.add(item2);
            menuItemList.add(item3);
            menuItemList.add(item4);
            menuItemList.add(item5);
            menuItemList.add(item6);
            menuItemList.add(item7);

            List<MenuItem> menuItems = menuItemService.saveAll(menuItemList);

            Dispatcher dispatcher = new Dispatcher("1234-5678");
            dispatcher.setEmail("dispatcher@kdhaya.tn");
            dispatcher.setName("Mehdi");
            dispatcher.setPassword("Mehdi1234");
            dispatcher.setPhone("22366333");
            dispatcher.setSurname("Souissi");
            dispatcher.setUsername("Mehdi");
            dipatcherRepository.save(dispatcher);
            Steed steed = new Steed("1234-1234", SteedShift.Morning);
            steed.setEmail("Steed@kdhaya.tn");
            steed.setName("Hechem");
            steed.setPassword("Hechem1234");
            steed.setPhone("50205020");
            steed.setSurname("Ben ismail");
            steed.setUsername("Hech");
            steedRepository.save(steed);
            User user = new User(26);
            user.setEmail("SimpleUser@kdhaya.tn");
            user.setName("Ala");
            user.setPassword("Ala1234");
            user.setPhone("50280400");
            user.setSurname("Ben Khlifa");
            user.setUsername("Ala");
            userRepository.save(user);
            ShoreCategory category = new ShoreCategory();
            category.setName("Food");
            shoreCategoryService.save(category);
            Shore shore = new Shore();
            shore.setCategory(category);
            shore.setCost(3.5D);
            shore.setCreator(user);
            shore.setDescription("Fast Please!");
            shore.setDispatcher(dispatcher);
            shore.setFromLocation("33.23565132");
            shore.setStatus(ShoreStatus.InProgress);
            shore.setSteed(steed);
            shore.setToLocation("33.33565132");
            shore.setUserAgent("FireFox 53.0");

            ShoreItems shoreItems = new ShoreItems();
            shoreItems.setShore(shore);
            shoreItems.setMenuItem(item1);
            shoreItems.setQuantity(2);

            shore.addMenuItem(shoreItems);

            shoreService.save(shore);

            log.info(shore.toString());
//
//            shoreService.cancel(1L);

//            ShoreItems items = new ShoreItems();
//            items.setMenuItem(item1);
//            items.setShore(shore);
//            items.setQuantity(2);
//            shoreItemsRepository.save(items);

//            Shore shore1 = new Shore();
//            shore1.setCategory(category);
//            shore1.setCost(4.5D);
//            shore1.setCreator(user);
//            shore1.setSatisfaction(5);
//            shore1.setDescription("Fast Please!");
//            shore1.setDispatcher(dispatcher);
//            shore1.setFromLocation("33.23565132");
//            shore1.setInChargeAt(new Date());
//            shore1.setStatus(ShoreStatus.Finished);
//            shore1.setSteed(steed);
//            shore1.setToLocation("33.33565132");
//            shore1.setUserAgent("CHROME 53.0");
//            shoreService.save(shore1);
        };
    }

}
