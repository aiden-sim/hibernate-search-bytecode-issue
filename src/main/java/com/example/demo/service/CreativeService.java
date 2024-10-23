package com.example.demo.service;

import com.example.demo.domain.AbstractCreative;
import com.example.demo.domain.AdGroup;
import com.example.demo.domain.RichNativeCreative;
import com.example.demo.domain.UrlLandingInfo;
import com.example.demo.repository.AdGroupRepository;
import com.example.demo.repository.CreativeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CreativeService {
    private final AdGroupRepository adGroupRepository;
    private final CreativeRepository creativeRepository;

    @Transactional
    public void create() {
        log.info("create transaction Status :" + TransactionSynchronizationManager.isActualTransactionActive());

        AdGroup adGroup = new AdGroup();
        adGroup.setCreatedDate(LocalDateTime.now());
        adGroup.setStatus("ON");
        adGroupRepository.save(adGroup);

        RichNativeCreative creative = new RichNativeCreative();
        creative.setName("name");
        creative.setCreatedDate(LocalDateTime.now());
        creative.setAdGroup(adGroup);

        UrlLandingInfo landing = new UrlLandingInfo();
        landing.setUrl("http://demo.net");
        landing.setCreatedDate(LocalDateTime.now());
        landing.setCreative(creative);
        creative.setLandingInfo(landing);
        creativeRepository.save(creative);

        RichNativeCreative richNativeCreative = new RichNativeCreative();
        richNativeCreative.setName("name");
        richNativeCreative.setCreatedDate(LocalDateTime.now());
        richNativeCreative.setCopySourceCreative(creative);
        richNativeCreative.setAdGroup(adGroup);

        UrlLandingInfo landing2 = new UrlLandingInfo();
        landing2.setUrl("http://demo2.net");
        landing2.setCreatedDate(LocalDateTime.now());
        landing2.setCreative(richNativeCreative);
        richNativeCreative.setLandingInfo(landing2);
        creativeRepository.save(richNativeCreative);

        adGroup.setCreatives(List.of(creative, richNativeCreative));
    }

    public void getCreatives(List<Long> ids, Long adGroupId) {
        log.info("getCreatives transaction Status :" + TransactionSynchronizationManager.isActualTransactionActive());

        validateCreativeLimit(adGroupId);

        ids.forEach(id -> {
            try {
                ((CreativeService) AopContext.currentProxy()).getCreative(id, adGroupId);
            } catch (Exception e) {
                log.error("failed : ", e);
            }
        });
    }

    @Transactional
    public AbstractCreative getCreative(Long id, Long adGroupId) {
        log.info("getCreative transaction Status :" + TransactionSynchronizationManager.isActualTransactionActive());
        AdGroup adGroup = adGroupRepository.findByIdAndStatus(adGroupId, "ON")
                .orElseThrow(() -> new RuntimeException("데이터 없음"));
        AbstractCreative abstractCreative = creativeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("데이터 없음"));

        return abstractCreative;
    }

    private AdGroup validateCreativeLimit(Long adGroupId) {
        AdGroup adGroup = adGroupRepository.findByIdAndStatus(adGroupId, "ON")
                .orElseThrow(() -> new RuntimeException("데이터 없음"));

        // count check
        Long count = adGroup.getCreativesCount();

        return adGroup;
    }
}
