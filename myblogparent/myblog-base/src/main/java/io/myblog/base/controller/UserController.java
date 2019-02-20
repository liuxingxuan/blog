package io.myblog.base.controller;

import entity.Result;
import entity.StatusCode;
import io.myblog.base.pojo.Label;
import io.myblog.base.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/label")
public class UserController {

    @Autowired
    private LabelService labelService;

}