package com.gabia.project.internproject.service.review;

import com.gabia.project.internproject.repository.review.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;


}
