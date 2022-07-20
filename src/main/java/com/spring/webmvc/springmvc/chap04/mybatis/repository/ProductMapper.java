package com.spring.webmvc.springmvc.chap04.mybatis.repository;

import com.spring.webmvc.springmvc.chap04.mybatis.domain.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // mybatis 동작 인터페이스 등록 (mybatis 너가 이거 등록해라)
public interface ProductMapper {

    // mybatis - resources 밑에 interface package 경로를 똑같이 만들어야 한다
    // interface 이름이랑 대소문자도 똑같이 해서 .xml 파일을 생성한다

    // 제품 등록
    boolean save(Product product);

    // 제품 전체 조회
    List<Product> findAll();

    // 제품 개별 조회
    Product findOne(String serialNo);

    // 제품 수정
    boolean modify(Product product);

    // 제품 삭제
    boolean remove(String serialNo);
}