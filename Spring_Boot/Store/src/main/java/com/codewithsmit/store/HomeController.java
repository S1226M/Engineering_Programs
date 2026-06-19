package com.codewithsmit.store;

@Controller
public class HomeController {
    @RequestMapping("/")
    public string indfex(){
        return  "index.html";
    }
}
