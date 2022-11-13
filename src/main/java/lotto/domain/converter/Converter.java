package lotto.domain.converter;

import lotto.Lotto;

import java.math.BigDecimal;
import java.util.List;

public interface Converter {
    BigDecimal convertStringToMoney(String userInput);
    Integer convertStringToNumber(String systemInput);
    BigDecimal convertMoneyToCount(BigDecimal money);
    List<Integer> convertStringToNumbers(String systemInput);
    List<Lotto> convertNumbersToLotto(List<List<Integer>> numbersList);

}
