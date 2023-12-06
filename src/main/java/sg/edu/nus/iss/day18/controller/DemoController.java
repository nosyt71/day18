package sg.edu.nus.iss.day18.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/demo")
public class DemoController {

    @GetMapping(path="/hello")
    public ResponseEntity<?> hello() {
        try {
            return new ResponseEntity<>("Hello!!! Springboot is okay...", HttpStatusCode.valueOf(200));
        } catch (Exception ex) {
            return new ResponseEntity<>("Error running Springboot...", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping(path="/healthz")
    public ModelAndView getHealthz() {
        ModelAndView mav = new ModelAndView();
        try {
            mav.setViewName("healthy");
        } catch (Exception ex) {
            mav.setViewName("unhealthy");
        }

        return mav;
    }
}