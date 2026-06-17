package com.track_swift.trackswift.repository;

import com.track_swift.trackswift.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
