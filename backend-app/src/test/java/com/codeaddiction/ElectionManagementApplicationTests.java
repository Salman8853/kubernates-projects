package com.codeaddiction;

import com.codeaddiction.entity.Candidate;
import com.codeaddiction.model.CandidateModel;
import com.codeaddiction.repository.CandidateRepository;
import com.codeaddiction.service.CandidateService;
import com.codeaddiction.service.impl.CandidateServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
@ExtendWith(MockitoExtension.class)
class ElectionManagementApplicationTests {


    @Mock
	private CandidateService candidateService;

    @Mock
    private CandidateRepository candidateRepository;

    @BeforeEach
    void setUp(){
        this.candidateService=new CandidateServiceImpl(this.candidateRepository);
    }


    @Test
    void saveNewCandidate_AndShoudSuccess(){
      CandidateModel model=  new CandidateModel(1L,"Salman","mskhan8853@gmail.com","20-06-1992","AIMIM","Kanpur");
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
        Mockito.when(candidateRepository.save(any()))
                .thenReturn(candidate);
       // Mockito.doReturn(null).when(candidateRepository.save(ArgumentMatchers.any()));
       String response= candidateService.saveNewCandidate(model);
        Assertions.assertEquals("candidate saved successfully..!!",response);
    }


}
