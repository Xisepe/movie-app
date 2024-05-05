package ru.ccfit.golubevm.movieapp.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.ccfit.golubevm.movieapp.core.entity.Episode;
@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {
                ReferenceMapper.class
        }
)
public interface EpisodeMapper extends IdToReferenceMapper<Integer, Episode> {
}
