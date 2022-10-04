package com.example.stargram.domain.bookmark.domain.repository;

import com.example.stargram.domain.bookmark.domain.BookMark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookMarkRepository extends JpaRepository<BookMark, Long> {
}
