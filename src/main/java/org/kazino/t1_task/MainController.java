package org.kazino.t1_task;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {
    @RequestMapping("/")
    public String processInput(String str) throws Exception {
        try {
            return SymbolsCounter.countSymbols(str);
        } catch (Exception e) {
            return "Invalid symbols in a string!";
        }
    }
}
