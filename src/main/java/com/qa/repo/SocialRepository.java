package com.qa.repo;

import com.qa.domain.Social;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialRepository extends JpaRepository<Social, Long> {

    Social findByTitle(String title);

}
