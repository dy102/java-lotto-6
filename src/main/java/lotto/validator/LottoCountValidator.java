package lotto.validator;

import static lotto.Option.ErrorMessage.NOT_DIVISION_1000;
import static lotto.Option.ErrorMessage.NOT_NEGATIVE_NUMBER;
import static lotto.Option.ErrorMessage.NOT_ZERO;

public class LottoCountValidator {
    private LottoCountValidator() {
    }

    public static void check(int money) {
        validatePositiveNumber(money);
        validateZeroNumber(money);
        validateDivision(money);
    }

    private static void validatePositiveNumber(int money) {
        if (money < 0) {
            throw new IllegalArgumentException(NOT_NEGATIVE_NUMBER.getErrorMessage());
        }
    }

    private static void validateZeroNumber(int money) {
        if (money == 0) {
            throw new IllegalArgumentException(NOT_ZERO.getErrorMessage());
        }
    }

    private static void validateDivision(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(NOT_DIVISION_1000.getErrorMessage());
        }
    }
}
