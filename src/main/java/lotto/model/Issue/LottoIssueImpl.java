package lotto.model.Issue;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.converter.ConverterImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoIssueImpl implements LottoIssue{

    private final BigDecimal count;

    public LottoIssueImpl(BigDecimal count){
        this.count = count;
    }

    @Override
    public List<Lotto> getLotto() {
        List<List<Integer>> randomNumbers = generateRandomNumbers();
        return randomNumbers.stream()
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private List<List<Integer>> generateRandomNumbers(){
        List<List<Integer>> randomNumbers = new ArrayList<>();
        for(int i =0; i< count.intValue(); i++){
            List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            validateRandomNumber(randomNumber);
            randomNumbers.add(randomNumber);
        }
        return randomNumbers;
    }

    private void validateRandomNumber(List<Integer> randomNumbers){
        if (randomNumbers.stream().distinct().count() !=6){
            throw new IllegalArgumentException();
        }
        if (randomNumbers.stream().filter(number -> 1 <= number && number <= 45).count() != 6){
            throw new IllegalArgumentException();
        }
    }



}
