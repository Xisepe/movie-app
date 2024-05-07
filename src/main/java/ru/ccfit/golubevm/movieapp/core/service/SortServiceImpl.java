package ru.ccfit.golubevm.movieapp.core.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class SortServiceImpl implements SortService {
    @Override
    public Sort buildSort(String sort) {
        if (sort == null) {
            return Sort.unsorted();
        }
        var pattern = Pattern.compile("(\\w+?):(asc|desc),", Pattern.UNICODE_CHARACTER_CLASS);
        var matcher = pattern.matcher(sort + ",");
        var orders = new ArrayList<Sort.Order>();
        while (matcher.find()) {
            var prop = matcher.group(1);
            var order = matcher.group(2);
            var o = switch (order){
                case "asc"-> Sort.Order.asc(prop);
                case "desc" -> Sort.Order.desc(prop);
                default -> throw new IllegalArgumentException();
            };
            orders.add(o);
        }
        return Sort.by(orders);
    }
}
