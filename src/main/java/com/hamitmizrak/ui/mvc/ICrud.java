package com.hamitmizrak.ui.mvc;

import org.springframework.ui.Model;

public interface ICrud <T> {

    //CRUD
//    public String createGet(T t);
//    public String createPost(T t);
//
    public String list(Model model);
//    public String createGet(T t);
}
