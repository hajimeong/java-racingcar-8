package racingcar.controller;

import racingcar.domain.RacingService;
import racingcar.domain.RoundResult;
import racingcar.repository.RacingCarRepository;
import racingcar.util.RacingValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {

    private final RacingCarRepository repository=new RacingCarRepository();
    private final InputView inputView=new InputView();
    private final OutputView outputView=new OutputView();
    private final RacingValidator racingValidator=new RacingValidator();


    public void run(){
        String carNames=inputView.inputCarNames();
        String CountInput=inputView.inputTryCount();
        //시도 횟수 검증
        racingValidator.validateTryCount(CountInput);
        Integer tryCount=Integer.parseInt(CountInput);

        RacingService racingService=new RacingService(carNames,repository);
        racingService.playRace(tryCount);

        outputView.printResultMessage();
        printRoundResults();

        List<String> winners=racingService.findWinners();
        outputView.printWinners(winners);
    }

    private void printRoundResults(){
        List<RoundResult> roundResults=repository.findAllRounds();
        for(RoundResult roundResult:roundResults){
            outputView.printRoundResult(roundResult.getRoundNumber(),roundResult.getCarsStatus());
        }
    }
}
