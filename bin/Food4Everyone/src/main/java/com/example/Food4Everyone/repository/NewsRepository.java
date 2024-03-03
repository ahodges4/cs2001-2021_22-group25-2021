package com.example.Food4Everyone.repository;

import com.example.Food4Everyone.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Integer> {
}
