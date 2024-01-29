package org.kazino.t1_task;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
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
    public static String countSymbols(String str) throws Exception {
        if (!str.matches("^[a-zA-Z, а-яА-Я]+$") || str.length()<1){
            throw new InvalidSymbolException("Invalid characters in string!");
        }
        else {
            Map<String, Long> mapOfCounts = str.codePoints().mapToObj(Character::toString)
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            mapOfCounts = sortMapByValueDescending(mapOfCounts);

            StringBuilder res = new StringBuilder();

            List<Map.Entry<String, Long>> pairsOfCounts = mapOfCounts.entrySet().stream()
                    .sorted(Comparator.comparingLong(x -> -x.getValue())).toList();

            for (Map.Entry<String, Long> entry : pairsOfCounts) {
                res.append(String.format("\"%s\":%d, ", entry.getKey(), entry.getValue()));
            }
            if(res.length() !=0) {
                res.delete(res.length()-2, res.length());
            }

            return res.toString();
        }
    }
}
