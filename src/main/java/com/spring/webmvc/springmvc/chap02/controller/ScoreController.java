package com.spring.webmvc.springmvc.chap02.controller;

import com.spring.webmvc.springmvc.chap02.domain.Score;
import com.spring.webmvc.springmvc.chap02.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class ScoreController {

    private final ScoreRepository repository;

    // 점수 등록 및 조회 화면 열기 요청
    /*@RequestMapping("/score/list")
    public String list(Model model) {
        log.info("/score/list GET Request!!");

        // jsp에게 점수 정보 리스트를 전달해야 함
        List<Score> scoreList = repository.findAll();

        // 이름 마킹 처리
        for (Score s : scoreList) {
            String original = s.getName();
            StringBuilder markName = new StringBuilder(String.valueOf(original.charAt(0)));
            for (int i = 0; i < original.length() - 1; i++) {
                markName.append("*");
            }
            s.setName(markName.toString());
        }

        model.addAttribute("scores", scoreList);
        return "chap02/score-list";
    }*/
    @RequestMapping("/score/list")
    public String list(Model model, @RequestParam(defaultValue = "stu_num")String sortingType) {
        log.info("/score/list GET Request!!");
        log.info("model: " + model.toString());
        
        // jsp에게 점수 정보 리스트를 전달해야 함
        List<Score> scoreList = repository.findAll(sortingType);
        model.addAttribute("scores", scoreList);

        return "chap02/score-list";
    }

    @RequestMapping("/score/list/sorting")
    public String sorting(Model model, @RequestParam("sortingType") String sortingType) {
        // @RequestParam 생략가능 (변수이름과 같으면)
        log.info("sortingType: " + sortingType);

        List<Score> scoreList = repository.findAll(sortingType);
        model.addAttribute("scores", scoreList);

        return "chap02/score-list";
    }

    // 점수 신규 등록 요청
    @RequestMapping("/score/register")
    public String register(Score score) {
        score.calcTotalAndAvg(); // calcTotalAndAvg(), private -> public 바꿔야 함
        score.calcGrade(); // calcGrade(), private -> public 바꿔야 함

        log.info("/score/register POST!! - " + score);
        // 기본 생성자로 객체를 만들고 setter 실행한다,
        // 기본 생성자에 calcTotalAndAvg(), calcGrade()를 적어도 입력된 정보가 없기 때문에 계산값이 없다

        // stuNum -  DB에 넣을 때 정해진다 (sequence)

//        return repository.save(score) ? "chap02/score-list" : "redirect:/"; // 삼항 연산자
        return repository.save(score) ? "redirect:/score/list" : "redirect:/"; // 삼항 연산자
    }

    // 개별 점수 조회 요청
    @RequestMapping("/score/detail")
    public String detail(int stuNum, Model model) {

        log.info("/score/detail");

        Score score = repository.findOne(stuNum);
        model.addAttribute("s", score);

        return "chap02/score-detail";
    }

    // 개별 점수 조회 요청
    /*@RequestMapping("/score/detail")
    public ModelAndView detail(int stuNum) {
        log.info("/score/detail GET - param1: {}", stuNum);
        Score score = repository.findOne(stuNum);
        ModelAndView mv = new ModelAndView("chap02/score-detail");
        mv.addObject("s", score);

        return mv;
    }*/


    // 점수 삭제 요청
    // 삭제 후 /score/list 페이지로 redirect
    @RequestMapping("/score/delete")
    public String delete(Score score) {

        log.info("/score/delete");

        return repository.remove(score.getStuNum()) ? "redirect:/score/list" : "redirect:/";
    }

    // 점수 삭제 요청
    /*@RequestMapping("/score/delete")
    public String delete(@RequestParam("stuNum") int sn) {
        log.info("/score/delete GET - param1: {}", sn); // sn이 {}안으로 들어간다

        return repository.remove(sn) ? "redirect:/score/list" : "redirect:/";
    }*/

}
