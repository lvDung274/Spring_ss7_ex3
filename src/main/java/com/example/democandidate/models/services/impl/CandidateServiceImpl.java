package com.example.democandidate.models.services.impl;

import com.example.democandidate.models.dto.req.CandidateCreateDTO;
import com.example.democandidate.models.dto.req.CandidateUpdateDTO;
import com.example.democandidate.models.entities.Candidate;
import com.example.democandidate.models.repositories.CandidateRepository;
import com.example.democandidate.models.services.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepository candidateRepository;

    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }


    @Override
    public Candidate create(CandidateCreateDTO request){

        Candidate candidate =Candidate.builder()
                .fullName(request.fullName())
                .email(request.email())
                .age(request.age())
                .yearsOfExperience(request.yearsOfExperience())
                .build();
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate Update(Long id,CandidateUpdateDTO request){
        Candidate candidate =candidateRepository.findById(id).orElseThrow(()->new RuntimeException("Khong tim thay ung vien"));

        candidate.setAddress(request.address());
        candidate.setBio(request.bio());
        return candidateRepository.save(candidate);
    }

}
