package data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Getter
@RequiredArgsConstructor(access = PRIVATE)
public enum ErrorMessage {
    NOT_ENOUGH_FUNDS("Not enough funds");

    private final String message;
}
