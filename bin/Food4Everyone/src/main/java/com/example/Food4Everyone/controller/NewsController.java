package com.example.Food4Everyone.controller;

import com.example.Food4Everyone.model.News;
import com.example.Food4Everyone.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


@RestController
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/needs")
    public String getProductList(@RequestParam("address")String address) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
    System.out.println(address);
        return restTemplate.exchange("https://www.givefood.org.uk/api/2/locations/search/?address="+ address, HttpMethod.GET, entity, String.class).getBody();
    }

//create news
    @PostMapping(value = "/news")
    public HashMap<String, String> createNews(@RequestBody News news) {

        newsRepository.save(news);
        HashMap<String, String> result_map = new HashMap<>();
        result_map.put("message", "News Created Successfully.");

        return result_map;
    }
//Get all News
    @GetMapping("/news")
    public List<News> newsList() {
        return newsRepository.findAll();
    }

    @GetMapping("/news/{id}")
    public News getNews(@PathVariable("id") int id) {
        return newsRepository.findById(id).orElse(null);
    }
//Deletes News
    @DeleteMapping("/news/{id}")
    public HashMap<String, String> deleteNews(@PathVariable("id") int id) {

        newsRepository.deleteById(id);
        HashMap<String, String> result_map = new HashMap<>();
        result_map.put("message", "News Deleted Successfully.");

        return result_map;
    }
//Updates News
    @PutMapping("/news/{id}")
    public HashMap<String, String> updateNews(@PathVariable("id") int id, @RequestBody News news)  {

        News news_exists = newsRepository.findById(id).orElse(null);
        news_exists.setTitle(news.getTitle());
        news_exists.setDescription(news.getDescription());
        newsRepository.save(news_exists);

        HashMap<String, String> result_map = new HashMap<>();
        result_map.put("message", "News updated successfully.");

        return result_map;
    }
// Like count updates
    @PutMapping("/news/{id}/update_like")
    public HashMap<String, String> updateLike(@PathVariable("id") int id)  {

        News news_exists = newsRepository.findById(id).orElse(null);
        news_exists.setLike_count(news_exists.getLike_count() + 1);
        newsRepository.save(news_exists);

        HashMap<String, String> result_map = new HashMap<>();
        result_map.put("message", "Like updated successfully.");

        return result_map;
    }
// Dislike count updates
    @PutMapping("/news/{id}/update_dislike")
    public HashMap<String, String> updateDisLike(@PathVariable("id") int id) {

        News news_exists = newsRepository.findById(id).orElse(null);
        news_exists.setDislike_count(news_exists.getDislike_count() + 1);
        newsRepository.save(news_exists);

        HashMap<String, String> result_map = new HashMap<>();
        result_map.put("message", "DisLike updated successfully.");

        return result_map;
    }
}
