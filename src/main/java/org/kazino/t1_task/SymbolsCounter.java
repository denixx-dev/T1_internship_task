package org.kazino.t1_task;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SymbolsCounter {
    private static <K, V extends Comparable<? super V>> Map<K, V>
            sortMapByValueDescending(Map<K, V> map){
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.<K, V>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
                        LinkedHashMap::new));
    }
    public static Map<String, Long> countSymbols(String str) throws Exception {
        if (str.matches(".*\\d.*") || str.length()<1){
            throw new InvalidSymbolException("Invalid characters in string!");
        }
        else {
            Map<String, Long> res = str.codePoints().mapToObj(Character::toString)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            res = sortMapByValueDescending(res);

            return res;
        }
    }
}
