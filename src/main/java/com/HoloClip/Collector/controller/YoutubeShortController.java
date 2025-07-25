package com.HoloClip.Collector.controller;

import com.HoloClip.Collector.model.PageResponse;
import com.HoloClip.Collector.model.YoutubeShort;
import com.HoloClip.Collector.service.YoutubeShortService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shorts")
public class YoutubeShortController {

    private final YoutubeShortService youtubeShortService;

    @Autowired
    public YoutubeShortController(YoutubeShortService youtubeShortService) {
        this.youtubeShortService = youtubeShortService;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping
    public ResponseEntity<PageResponse<YoutubeShort>> getShorts(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String channelId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {
        Page<YoutubeShort> shortPage = youtubeShortService.getShorts(search, channelId, page, size);
        return ResponseEntity.ok(new PageResponse<>(shortPage));
    }
}