package com.spring.webmvc.springmvc.chap03.service;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap02.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// Controller & Repository 중간 로직 처리
@Service // 스프링 빈 등록
@RequiredArgsConstructor
// final or @NotNull 이 붙은 필드의 생성자를 자동 생성해주는 lombok 어노테이션
public class ScoreService {

    private final ScoreRepository repository;

    // 점수 목록 요청 중간 처리 메서드
    public List<Score> listService(String sort) {
        // jsp에게 점수 정보 리스트를 전달해야 함.
        List<Score> scoreList = repository.findAll(sort);

        // 이름 마킹 처리
        // ctrl + alt + m
        processMarkName(scoreList);
        return scoreList;
    }

    // 점수 저장 요청 중간 처리
    public boolean saveService(Score score) {
        score.calcTotalAndAvg();
        score.calcGrade();
        return repository.save(score);
    }

    // 점수 삭제 중간처리
    public boolean deleteService(int stuNum) {
        return repository.remove(stuNum);
    }
    // 점수 개별조회 중간처리
    public Score detailService(int stuNum) {
        return repository.findOne(stuNum);
    }

    private void processMarkName(List<Score> scoreList) {
        for (Score s : scoreList) {
            String original = s.getName();
            StringBuilder markName = new StringBuilder(String.valueOf(original.charAt(0)));
            // ex) 이름이 김지연이면 charAt(0) -> 김 (char type)
            // char 타입을 다시 String으로 형변환 -> String.valueOf

            // String끼리의 덧셈(+)은 메모리 할당과 메모리 해제를 발생시킨다, 성능상 좋지 않다. 그래서 사용하는게 StringBuilder!
            // StringBuilder - 문자열 덧셈시 사용, append를 사용해서 문자열을 더한다. 출력 시에는 toString()을 붙여야 한다.

            for (int i = 0; i < original.length() - 1; i++) { // 0, 1
                markName.append("*"); // ex) 이름이 세글자면 두글자에 *이 붙어야한다 (반복문 2번 돌려주기) -> 김**
            }
            s.setName(markName.toString()); // StringBuilder - 출력 시에는 toString()을 붙여야 한다
        }
    }
}