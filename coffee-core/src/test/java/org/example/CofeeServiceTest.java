package org.example;

import org.example.model.ProcessingType;
import org.example.model.Producer;
import org.example.model.Sort;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class CoffeeServiceTest {

    @Test
    void shouldGroupSortsByProcessingType() {
        // Given
        List<Producer> producers = List.of(
                new Producer(Sort.ARABICA, "Brazil", "Farm A", ProcessingType.HONEY, 1200),
                new Producer(Sort.ROBUSTA, "Vietnam", "Farm B", ProcessingType.NATURAL, 800),
                new Producer(Sort.ARABICA, "Colombia", "Farm C", ProcessingType.HONEY, 1600)
        );

        // When
        Map<ProcessingType, Set<Sort>> result =
                CoffeeService.getSortsByProcessingType(producers);

        // Then
        assertThat(result)
                .hasSize(2)
                .containsEntry(ProcessingType.HONEY, Set.of(Sort.ARABICA))
                .containsEntry(ProcessingType.NATURAL, Set.of(Sort.ROBUSTA));
    }

    @Test
    void shouldFilterHighAltitudeCountries() {
        // Given
        List<Producer> producers = List.of(
                new Producer(Sort.ARABICA, "Brazil", "Farm A", ProcessingType.HONEY, 1200),
                new Producer(Sort.ROBUSTA, "Ethiopia", "Farm B", ProcessingType.NATURAL, 1800),
                new Producer(Sort.LIBERICA, "Kenya", "Farm C", ProcessingType.WASHED, 2000)
        );

        // When
        Set<String> result =
                CoffeeService.getCountriesWithHighAltitude(producers);

        // Then
        assertThat(result)
                .hasSize(2)
                .containsExactlyInAnyOrder("Ethiopia", "Kenya");
    }
}