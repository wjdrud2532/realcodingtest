package ac.cnu.realcodingapi.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserGroupDomainService {

    private final UserGroupRepository userGroupRepository;

    public UserGroupDomainService(UserGroupRepository userGroupRepository) {
        log.info("도메인 서비스 입니다");
        this.userGroupRepository = userGroupRepository;

    }

    @Transactional(readOnly = true)
    public UserGroup getUserGroup(long id) {
        log.info("레포지토리 입니다");
        return userGroupRepository.findById(id)
                .orElseGet(() -> new UserGroup("no group"));
    }
}
