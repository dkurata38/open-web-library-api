package com.github.dkurata38.open_web_library.repository

import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["com.github.dkurata38.open_web_library.repository.*"])
@MapperScan(basePackages = ["com.github.dkurata38.open_web_library.repository.*"])
class RepositoryModule
