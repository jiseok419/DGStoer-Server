package com.example.DGStoer.domain.item.controller;

import com.example.DGStoer.domain.item.DTO.ItemListResponse;
import com.example.DGStoer.domain.item.DTO.ItemRequest;
import com.example.DGStoer.domain.item.DTO.ItemResponse;
import com.example.DGStoer.domain.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/items")
@RestController
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/")
    public ItemListResponse getAllItems(@RequestParam(defaultValue = "0") int page) {
        return itemService.getAllItems(page);
    }

//    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    @PostMapping
    public void insertBoard(@RequestPart(value = "item") ItemListResponse itemResponse, @RequestPart(value = "files",required = false) List<MultipartFile> files) throws Exception {
        itemService.insertBoard(itemResponse, files);
    }


}
