package ru.ccfit.golubevm.movieapp.core.mapper;

import org.springframework.stereotype.Service;
import ru.ccfit.golubevm.movieapp.core.repository.Filter;
import ru.ccfit.golubevm.movieapp.core.repository.FilterOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class FilterMapperImpl implements FilterMapper {
    @Override
    public List<Filter> getFiltersFromString(String filter) {
        if (filter == null) {
            return null;
        }
        var res = new ArrayList<Filter>();
        var pattern = Pattern.compile("(\\w+?)([:<=>]|<=|>=|!=)([\\w|-]+),", Pattern.UNICODE_CHARACTER_CLASS);
        var matcher = pattern.matcher(filter + ",");
        while (matcher.find()) {
            var cr = new Filter(
                    matcher.group(1),
                    FilterOperation.fromString(matcher.group(2)),
                    matcher.group(3)
            );
            res.add(cr);
        }
        return res;
    }
}
