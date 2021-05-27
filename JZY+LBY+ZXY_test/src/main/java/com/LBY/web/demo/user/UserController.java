package com.LBY.web.demo.user;

import com.LBY.web.webmvc.annotation.GetMapping;
import com.LBY.web.webmvc.annotation.PathVariable;
import com.LBY.web.webmvc.annotation.RequestMapping;
import com.LBY.web.webmvc.annotation.RestController;
import com.LBY.web.webmvc.entity.RequestMethod;

@RestController
@RequestMapping("/haha")

public class UserController {

    @GetMapping("/{id}")
    public String get(@PathVariable("id") String id) {

        return id;
    }

    @RequestMapping(value = "/mapping/{id}",method = RequestMethod.GET)
    public Integer get0(@PathVariable("id") Integer id){
        return id;
    }

}
