package org.example;
import org.example.CoffeeGenerator;
import org.junit.jupiter.api.Test;
import org.example.model.Producer;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CoffeeGeneratorTest {

    @Test
    void shouldGenerateRequestedNumberOfProducers() {
        // When
        final int count = 5;
        List<Producer> result = CoffeeGenerator.generateProducerList(5);

        // Then
        assertThat(result)
                .hasSize(count)
                .allMatch(producer -> producer.sort() != null)
                .allMatch(producer -> producer.country() != null);
    }
}