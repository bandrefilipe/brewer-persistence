package bandrefilipe.brewer.persistence.core.model.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum BeverageFlavor {

    BITTER("B"),
    FRUITY("F"),
    SOFT  ("S"),
    STRONG("T"),
    SWEET ("W");

    private static final Map<String, BeverageFlavor> FLAVORS_BY_CODE = Stream.of(BeverageFlavor.values())
            .collect(toMap(BeverageFlavor::getCode, Function.identity()));

    private final String code;

    public static BeverageFlavor getByCode(final String code) {
        return FLAVORS_BY_CODE.get(code);
    }
}
