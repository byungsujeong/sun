package jeong.sun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SunController {
    @GetMapping("go")
    public String Sun(Model model) {
        model.addAttribute("data", "go");
        return "go";
    }

    @GetMapping("sun-mvc")
    public String sunMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "sun_template";
    }

    @GetMapping("sun-string")
    @ResponseBody
    public String sunString(@RequestParam("name") String name) {
        return "sun " + name;
    }

    @GetMapping("sun-api")
    @ResponseBody
    public Sun sunApi(@RequestParam("name") String name) {
        Sun sun = new Sun();
        sun.setName(name);
        return sun;
    }

    static class Sun {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
