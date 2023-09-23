package com.aue.config;

import com.aue.pojo.Apple;
import com.aue.pojo.Banana;
import com.aue.pojo.Cat;
import com.aue.pojo.Dog;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({Apple.class, Banana.class, Cat.class, Dog.class})
public class ImportConfig {
}
