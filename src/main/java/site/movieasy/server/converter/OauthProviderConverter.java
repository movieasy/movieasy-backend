package site.movieasy.server.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import site.movieasy.server.domain.OauthProvider;

@Converter
public class OauthProviderConverter implements AttributeConverter<OauthProvider, Integer> {

    @Override
    public Integer convertToDatabaseColumn(OauthProvider attribute) {
        if (attribute.equals(OauthProvider.KAKAO)) {
            return 1;
        }
        else if (attribute.equals(OauthProvider.EMAIL)) {
            return 0;
        }
        return -1;
    }

    @Override
    public OauthProvider convertToEntityAttribute(Integer dbData) {
        if (dbData == OauthProvider.KAKAO.ordinal()) {
            return OauthProvider.KAKAO;
        } else if (dbData == OauthProvider.EMAIL.ordinal()) {
            return OauthProvider.EMAIL;
        }
        return null;
    }
}
