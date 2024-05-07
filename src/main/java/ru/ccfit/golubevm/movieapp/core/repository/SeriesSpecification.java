package ru.ccfit.golubevm.movieapp.core.repository;

import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.MethodArgumentNotValidException;
import ru.ccfit.golubevm.movieapp.core.entity.Series;
import ru.ccfit.golubevm.movieapp.core.exceptions.BadRequestException;

import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

@RequiredArgsConstructor
public class SeriesSpecification implements Specification<Series> {
    private final Filter filter;
    private static final Set<FilterOperation> STRING_FILTERS = Set.of(FilterOperation.values());
    private static final Set<FilterOperation> INTEGER_FILTERS = Set.of(FilterOperation.EQ,FilterOperation.GR,FilterOperation.GR_EQ,FilterOperation.LW,FilterOperation.LW_EQ,FilterOperation.NOT_EQ);
    private static final Set<FilterOperation> MPAA_RATING_FILTERS = Set.of(FilterOperation.EQ,FilterOperation.NOT_EQ);
    private static final Set<FilterOperation> DATE_FILTERS = INTEGER_FILTERS;

    private static final Map<String, Set<FilterOperation>> possibleFilters = Map.of(
            "id", INTEGER_FILTERS,
            "ruName", STRING_FILTERS,
            "enName", STRING_FILTERS,
            "originalName", STRING_FILTERS,
            "tagline", STRING_FILTERS,
            "releaseDate", DATE_FILTERS,
            "mpaaRating", MPAA_RATING_FILTERS,
            "duration", INTEGER_FILTERS,
            "totalSeason", INTEGER_FILTERS
    );

    private boolean isPossible(String key, FilterOperation operation) {
        if (!possibleFilters.containsKey(key))
            return false;
        return possibleFilters.get(key).contains(operation);
    }

    private <T> BiFunction<Expression<T>, T, Predicate> getPredicateByOp(FilterOperation operation, CriteriaBuilder criteriaBuilder) {
        return switch (operation) {
            case LIKE -> (BiFunction<Expression<String>, String, Predicate>)criteriaBuilder::like;
            case EQ -> criteriaBuilder::equal;
            case NOT_EQ -> criteriaBuilder::notEqual;
            case GR -> criteriaBuilder::greaterThan;
        }
    }

    private <T> Predicate getPredicateByOperation(FilterOperation op, CriteriaBuilder criteriaBuilder, Path<T> x, T y) {
        return switch (op) {
            case EQ -> criteriaBuilder.equal(x,y);
            case NOT_EQ -> criteriaBuilder.notEqual(x,y);
            case LIKE -> criteriaBuilder.like(x,"%"+y+"%");
        }
    }
    @Override
    public Predicate toPredicate(Root<Series> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (!isPossible(filter.getKey(), filter.getOperation())) {
            throw new BadRequestException();
        }
        return switch (filter.getOperation()) {
            case EQ -> criteriaBuilder.equal(
                    root.get(filter.getKey()), root.get
            )
        }

        return null;
    }
}
