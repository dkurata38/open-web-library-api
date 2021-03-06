import com.thinkimi.gradle.MybatisGeneratorTask

plugins {
    id("com.thinkimi.gradle.MybatisGenerator") version "2.1.2"
    kotlin("jvm")
}

version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

tasks.withType<MybatisGeneratorTask> {
    verbose = true
    val configFileName = "generatorConfig.xml"
    configFile = sourceSets.getByName("main").resources.find{ (it.name == configFileName) }
    targetDir = projectDir.toPath().toString()
    overwrite = true

    dependencies {
        implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.1")
        implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:1.1.4")
        mybatisGenerator("org.mybatis.generator:mybatis-generator-core:1.4.0")
        mybatisGenerator("org.postgresql:postgresql:42.2.6")
        mybatisGenerator("com.github.dkurata38:mybatis-generator-plugins:0.0.3")
    }
}
