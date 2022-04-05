package com.SpringBoot.Repository;

import com.SpringBoot.Entity.Topics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends CrudRepository<Topics,String>
{

}
