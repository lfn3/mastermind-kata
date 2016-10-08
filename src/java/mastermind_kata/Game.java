package mastermind_kata;

import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class Game {
    public final List<String> guesses = new ArrayList<>();
    private final String secret;
    private final Character[] validChars = {'r', 'y', 'c', 'b', 'w', 'g'};

    public Game(String secret){
        this.secret = secret;
    }

    public Score guess(String guess) {
        guesses.add(guess);
        return score(guess);
    }

    public Score score(String guess) {
        int inexact = 0;
        int exact = 0;

        Map<Character, Integer> lastSeenAt = Arrays.stream(validChars)
                                                   .collect(Collectors.toMap(Function.identity(),(x) -> 0));

        //TODO: Can we refactor this to be based on streams?
        for (int i = 0; i < guess.length(); i++){
            int secretIndex = secret.indexOf(guess.charAt(i), lastSeenAt.get(guess.charAt(i)));

            if (secret.indexOf(guess.charAt(i), i) == i) {
                exact += 1;
            } else if (secretIndex != -1){
                lastSeenAt.put(guess.charAt(i), secretIndex + 1);
                inexact += 1;
            }
        }
        return new Score(exact, inexact);
    }
}

