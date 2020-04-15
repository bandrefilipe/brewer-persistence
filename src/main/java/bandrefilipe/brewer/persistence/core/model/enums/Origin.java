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
public enum Origin {

    NATIONAL("N"),
    INTERNATIONAL("I");

    private static final Map<String, Origin> ORIGINS_BY_CODE = Stream.of(Origin.values())
            .collect(toMap(Origin::getCode, Function.identity()));

    private final String code;

    public static Origin getByCode(final String code) {
        return ORIGINS_BY_CODE.get(code);
    }
}
