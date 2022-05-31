package com.suda.fleamarket.controller;

import com.suda.fleamarket.anno.CurrentUserId;
import com.suda.fleamarket.dto.StarDTO;
import com.suda.fleamarket.http.ResultBody;
import com.suda.fleamarket.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/star")
public class StarController {
    @Autowired
    StarService starService;

    @PostMapping("/list")
    ResultBody listAllGoodsStared(@CurrentUserId Long currentUserId) {
        return ResultBody.success().setData(starService.listAllByUserId(currentUserId));
    }

    @PostMapping("/add")
    ResultBody add(@CurrentUserId Long currentUserId, @RequestBody @Valid StarDTO starDTO) {
        return ResultBody.success().setData(starService.save(currentUserId, starDTO.getGoodId()));
    }

    @PostMapping("/remove")
    ResultBody remove(@CurrentUserId Long currentUserId, @RequestBody @Valid StarDTO starDTO) {
        return ResultBody.success().setData(starService.remove(currentUserId, starDTO.getGoodId()));
    }
}
