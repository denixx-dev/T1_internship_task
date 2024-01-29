package org.kazino.t1_task;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {
    @RequestMapping("/")
    public Map<String, Long> processInput(String str) throws Exception {
        try {
            Map<String, Long> count = SymbolsCounter.countSymbols(str);
            return SymbolsCounter.countSymbols(str);
        } catch (Exception e) {
            Map<String, Long> emptyRes = new HashMap<>();
            emptyRes.put("", 0l);
            return emptyRes;
        }
    }
}
