package com.spring.webmvc.springmvc.chap02.api;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap02.repository.ScoreMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Log4j2
@CrossOrigin
@RequestMapping("/score")
public class ScoreApiController {

    private final ScoreMapper scoreMapper;

    // 점수 등록 및 조회 화면 열기 요청
    @GetMapping("")
    public List<Score> list(String sort) {

        log.info("/score GET! - {}", sort);
        List<Score> scoreList = scoreMapper.findAll(sort);

        // 이름 마킹 처리
        for (Score s : scoreList) {
            String original = s.getName();
            StringBuilder markName = new StringBuilder(String.valueOf(original.charAt(0)));
            for (int i = 0; i < original.length() - 1; i++) {
                markName.append("*");
            }
            s.setName(markName.toString());
        }

        return scoreList;
    }
    
    // 점수 신규 등록 요청
    @PostMapping("")
    public String register(@RequestBody Score score ) {
        score.calcTotalAndAvg();
        score.calcGrade();
        log.info("/score POST! - {}", score);

        boolean flag = scoreMapper.save(score);

        return flag ? "register-success" : "register-fail";
    }

    // 개별 점수 조회 요청
    @GetMapping("/{stuNo}")
    public Score detail(@PathVariable int stuNo) {
        log.info("/score/{sno} GET! - {}", stuNo);

        Score score = scoreMapper.findOne(stuNo);
        return score;
    }

    // 점수 삭제 요청
    @DeleteMapping("/{stuNo}")
    public String delete(@PathVariable int stuNo) {
        log.info("/score DELETE! - {}", stuNo);

        boolean flag = scoreMapper.remove(stuNo);

        return flag ? "delete-success" : "delete-fail";
    }
}
