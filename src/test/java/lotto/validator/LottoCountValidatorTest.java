package lotto.validator;

import static lotto.Option.ErrorMessage.NOT_DIVISION_1000;
import static lotto.Option.ErrorMessage.NOT_NEGATIVE_NUMBER;
import static lotto.Option.ErrorMessage.NOT_ZERO;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoCountValidatorTest {
    @DisplayName("음수를 입력했을 때 예외가 발생한다.")
    @Test
    void NotPositiveNumberThrowException() {
        assertThatThrownBy(() -> LottoCountValidator.check(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_NEGATIVE_NUMBER.getErrorMessage());
    }

    @DisplayName("0을 입력했을 때 예외가 발생한다.")
    @Test
    void ZeroNumberThrowException() {
        assertThatThrownBy(() -> LottoCountValidator.check(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ZERO.getErrorMessage());
    }

    @DisplayName("1000으로 나누어 떨어지지 않는 값을 입력했을 때 예외가 발생한다.")
    @Test
    void NotDivisionNumberThrowException() {
        assertThatThrownBy(() -> LottoCountValidator.check(8888))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_DIVISION_1000.getErrorMessage());
    }
}
