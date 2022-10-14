package co.kr.tybms.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CacheType {

    MATERIALS(Integer.MAX_VALUE, 100),
    NOTICES(Integer.MAX_VALUE, 100),
    PRODUCTS(Integer.MAX_VALUE, 100);

    private final int expireAfterWrite;
    private final int maximumSize;

}
