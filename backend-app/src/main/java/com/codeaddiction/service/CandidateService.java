package com.codeaddiction.service;

import com.codeaddiction.model.CandidateModel;

import java.util.List;

public interface CandidateService {

    String saveNewCandidate(CandidateModel model);

    CandidateModel getCandidateById(Long id);

    List<CandidateModel> getAllCandidateList();

    String updateCandidate(Long id, CandidateModel model);

    String deleteCandidtateById(Long id);
}
