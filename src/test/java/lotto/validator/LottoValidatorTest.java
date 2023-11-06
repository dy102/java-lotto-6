package lotto.validator;

import static lotto.Option.ErrorMessage.NOT_SIX_LENGTH;
import static lotto.Option.ErrorMessage.ONE_TO_FORTY_FIVE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoValidatorTest {
    @DisplayName("List의 길이가 6이 아니면 오류를 던진다.")
    @Test
    void NotSixNumberLengthThrowException() {
        assertThatThrownBy(() -> LottoValidator.go(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_SIX_LENGTH.getErrorMessage());
    }

    @DisplayName("범위를 벗어난 수를 입력하면 오류를 던진다.")
    @ParameterizedTest
    @MethodSource("invalidParameters")
    void overRangeThrowException(List<Integer> numbers) {
        assertThatThrownBy(() -> LottoValidator.go(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ONE_TO_FORTY_FIVE.getErrorMessage());
    }

    static Stream<Arguments> invalidParameters() {
        return Stream.of(
                Arguments.of(List.of(0, 1, 2, 3, 4, 5)),
                Arguments.of(List.of(1, 2, 3, 4, 5, 46))
        );
    }
}
