package com.example.democandidate.models.services;

import com.example.democandidate.models.dto.req.CandidateCreateDTO;
import com.example.democandidate.models.dto.req.CandidateUpdateDTO;
import com.example.democandidate.models.entities.Candidate;

import java.util.List;

public interface CandidateService {

    List<Candidate> findAll();

    Candidate create(CandidateCreateDTO request);

    Candidate Update(Long id,CandidateUpdateDTO request);

}
