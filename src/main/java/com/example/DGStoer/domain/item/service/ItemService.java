package com.example.DGStoer.domain.item.service;

import com.example.DGStoer.domain.item.DTO.DownloadDto;
import com.example.DGStoer.domain.item.DTO.ItemListResponse;
import com.example.DGStoer.domain.item.DTO.ItemRequest;
import com.example.DGStoer.domain.item.DTO.ItemResponse;
import com.example.DGStoer.domain.item.entity.Item;
import com.example.DGStoer.domain.item.entity.ItemBinary;
import com.example.DGStoer.domain.item.repository.ItemBinaryRepository;
import com.example.DGStoer.domain.item.repository.ItemRepository;
import com.example.DGStoer.domain.item.type.PlatformType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemBinaryRepository itemBinaryRepository;

    public ItemListResponse getAllItems(int page) {
        Pageable pageRequest = PageRequest.of(page, 20, Sort.Direction.DESC, "createdAt");
        Page<Item> pageResult = itemRepository.findAll(pageRequest);

        return new ItemListResponse(pageResult.getTotalPages(),
                pageResult.toList().stream().map(it ->
                        ItemResponse.builder()
                                .title(it.getTitle())
                                .description(it.getDescription())
                                .developer(it.getDeveloper())
                                .downloads(it.getDownloads().stream().map(file ->
                                                new DownloadDto(file.getPlatformtype(), file.getSavedName())).collect(Collectors.toList()))
                                .github(it.getGithub())
                                .thumb(it.getThumb())
                                .build()
                ).collect(Collectors.toList())
        );
    }

    public void insertBoard(ItemListResponse itemRequest,  List<MultipartFile> files) {
        List<ItemBinary> downloads = new ArrayList<>();

        files.forEach(file -> {
            try {
                String newFilename = System.currentTimeMillis() +  "" + file.getOriginalFilename();
                file.transferTo(new File(newFilename));
                downloads.add(ItemBinary.builder()
                        .platformtype(PlatformType.windows)
                        .savedName(newFilename)
                        .build());
            }catch (Exception ex) { }
        });

        itemRequest.getList().forEach(data -> {
            Item item = Item.builder()
                    .title(data.getTitle())
                    .description(data.getDescription())
                    .developer(data.getDeveloper())
                    .github(data.getGithub())
                    .thumb(data.getThumb())
                    .framework(data.getFramework())
                    .downloads(new ArrayList<>())
                    .build();
            Item savedItem = itemRepository.save(item);

            downloads.forEach(download -> {
                savedItem.addDownload(itemBinaryRepository.save(download));
            });
        });

//        Item item = Item.builder()
//                .title(itemRequest.getTitle())
//                .description(itemRequest.getDescription())
//                .developer(itemRequest.getDeveloper())
//                .github(itemRequest.getGithub())
//                .thumb(itemRequest.getThumb())
//                .framework(itemRequest.getFramework())
//                .downloads(new ArrayList<>())
//                .build();
//        Item savedItem = itemRepository.save(item);
//        downloads.forEach(download -> {
//            savedItem.addDownload(itemBinaryRepository.save(download));
//        });
    }
}
