package com.yes.dl.shop.controller.test;

import com.yes.dl.shop.db.domain.Person;
import com.yes.dl.shop.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/first")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/testGet", method = RequestMethod.GET)
    public ModelAndView test01(){
        System.out.println(testService.findPerson());
        System.out.println(testService.getPerson(8));
        System.out.println(testService.queryPersons());
        System.out.println(testService.queryPersons());


        return new ModelAndView("test","name","michael");
    }

    @RequestMapping(value = "/testPost", method = RequestMethod.POST)
    public ModelAndView test02(Person person){
//        testService.addPerson(person);
//        testService.createPerson(person);
//        testService.insertPerson(person);
//        testService.insertPerson(person);
        //person = new Person();
        person.setId(12);
        //person.setUserName("lili");
//        testService.updatePerson(person);
//        testService.deletePerson(1);
//        testService.removePerson(2);
//        testService.mod(person);

        testService.addTranscationTest();

        return new ModelAndView("test","name","michael");
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView test03(String username, MultipartFile fileName){
        System.out.println(username);
        System.out.println(fileName.getSize());
        return new ModelAndView("test","name","michael");
    }

    @RequestMapping(value = "/mostUpload", method = RequestMethod.POST)
    public ModelAndView test04(@RequestParam("name") ArrayList<String> name,
                                @RequestParam("fileName") ArrayList<MultipartFile> fileName){
        System.out.println(name);
        for (MultipartFile multipartFile: fileName){
            System.out.println(multipartFile.getSize());
            System.out.println(multipartFile.getName());
        }
        return new ModelAndView("test","name","michael");
    }

}
