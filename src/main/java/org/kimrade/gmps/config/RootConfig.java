package org.kimrade.gmps.config;

import org.kimrade.gmps.domain.NoticeCheck;
import org.kimrade.gmps.domain.UserInfo;
import org.kimrade.gmps.dto.NoticeCheckDTO;
import org.kimrade.gmps.repository.UserInfoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RootConfig {
	
	private final UserInfoRepository uir;
	
	public RootConfig(UserInfoRepository uir) {
		this.uir = uir;
	}
	
    @Bean //수동으로 빈등록 @Configuration 활용해서 등록하면 싱글톤보장
    public ModelMapper getMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);	// STANDARD,LOOSE,STRICT
        
        // DTO → Entity 변환 시, userInfo 매핑 규칙 추가
        modelMapper.typeMap(NoticeCheckDTO.class, NoticeCheck.class)
                .addMappings(mapper -> mapper.skip(NoticeCheck::withUserInfo)) // 기본 매핑 방지
                .setPostConverter(context -> {
                    NoticeCheckDTO source = context.getSource();
                    NoticeCheck destination = context.getDestination();

                    // id 값이 존재하면 UserInfo 엔티티 조회 후 새로운 NoticeCheck 반환
                    if (source.getId() != null) {
                        UserInfo userInfo = uir.findById(source.getId())
                                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + source.getId()));

                        // 📌 기존 객체를 수정하는 대신, 새로운 객체를 생성하여 반환
                        return destination.withUserInfo(userInfo);
                    }
                    return destination;
                });
        
        // 📌 Entity → DTO 변환 (userInfo의 id 값만 설정)
        modelMapper.typeMap(NoticeCheck.class, NoticeCheckDTO.class)
                .addMappings(mapper -> mapper.map(src -> src.getUserInfo().getId(), NoticeCheckDTO::setId));

        
        return modelMapper;
    }
	
	
}
