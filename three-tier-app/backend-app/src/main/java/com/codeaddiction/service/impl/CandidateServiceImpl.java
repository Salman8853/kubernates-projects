package com.codeaddiction.service.impl;

import com.codeaddiction.entity.Candidate;
import com.codeaddiction.model.CandidateModel;
import com.codeaddiction.repository.CandidateRepository;
import com.codeaddiction.service.CandidateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateServiceImpl implements CandidateService {
    Logger logger = LoggerFactory.getLogger(CandidateServiceImpl.class);

    private CandidateRepository candidateRepository;

    @Autowired
    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public String saveNewCandidate(CandidateModel model) {
        Candidate candidate = new Candidate();
        candidate.setName(model.name());
        candidate.setEmail(model.email());
        candidate.setAddress(model.address());
        candidate.setPartyName(model.partyName());
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dob = new Date();
        try {
            dob = format.parse(model.dob());
        } catch (ParseException e) {
        }
        candidate.setDob(dob);
        this.candidateRepository.save(candidate);
        return "candidate saved successfully..!!";
    }

    @Override
    public CandidateModel getCandidateById(Long id) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(() -> new RuntimeException("Record not found..!!"));
        String dob = "";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        dob = format.format(candidate.getDob());
        CandidateModel model = new CandidateModel(candidate.getId(), candidate.getName(), candidate.getEmail(), dob, candidate.getPartyName(), candidate.getAddress());
        return model;
    }

    @Override
    public List<CandidateModel> getAllCandidateList() {
        List<Candidate> candidateList = candidateRepository.findAll();
        List<CandidateModel>candidateModelList =candidateList.stream().map(candidate -> new CandidateModel(candidate.getId(), candidate.getName(), candidate.getEmail(), new SimpleDateFormat("dd/MM/yyyy").format(candidate.getDob()), candidate.getPartyName(), candidate.getAddress())).collect(Collectors.toList());
        return candidateModelList;
    }


    @Override
    public String updateCandidate(Long id, CandidateModel model) {

        Candidate candidate = candidateRepository.findById(id).orElseThrow(() -> new RuntimeException("Record not found..!!"));
        candidate.setName(model.name());
        candidate.setEmail(model.email());
        candidate.setAddress(model.address());
        candidate.setPartyName(model.partyName());
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dob = new Date();
        try {
            dob = format.parse(model.dob());
        } catch (ParseException e) {
        }
        candidate.setDob(dob);

        this.candidateRepository.save(candidate);
        return "candidate updated successfully..!!";
    }

    @Override
    public String deleteCandidtateById(Long id) {
        candidateRepository.deleteById(id);
        return "Candidate deleted successfully...!!";
    }

}
