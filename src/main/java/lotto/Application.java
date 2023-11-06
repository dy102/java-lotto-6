package lotto;

import lotto.controller.LottoController;
import lotto.generator.RandomNumberGenerator;
import lotto.view.Input;
import lotto.view.Output;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new Input(), new Output(), new RandomNumberGenerator());
        lottoController.play();
    }
}
