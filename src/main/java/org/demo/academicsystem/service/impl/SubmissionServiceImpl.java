package org.demo.academicsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.demo.academicsystem.dto.submission.SubmissionRequest;
import org.demo.academicsystem.dto.submission.SubmissionResponse;
import org.demo.academicsystem.entity.Submission;
import org.demo.academicsystem.handler.exception.SubmissionNotFoundException;
import org.demo.academicsystem.mapper.SubmissionMapper;
import org.demo.academicsystem.repository.SubmissionRepository;
import org.demo.academicsystem.service.SubmissionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubmissionServiceImpl implements SubmissionService {
    private final SubmissionRepository submissionRepository;
    private final SubmissionMapper submissionMapper;

    @Override
    public List<SubmissionResponse> getAll() {
        List<Submission> submissions = submissionRepository.findAll();
        return submissions.stream()
                .map(submissionMapper::toResponse)
                .toList();
    }

    @Override
    public SubmissionResponse getById(Long id) {
        Submission submission = submissionRepository.findById(id).orElseThrow(
                () -> new SubmissionNotFoundException("Submission not found with id " + id)
        );
        return submissionMapper.toResponse(submission);
    }

    @Override
    public SubmissionResponse create(SubmissionRequest submissionRequest) {
        Submission newSubmission = submissionMapper.toEntity(submissionRequest);
        Submission savedSubmission = submissionRepository.save(newSubmission);
        return submissionMapper.toResponse(savedSubmission);
    }

    @Override
    public SubmissionResponse update(Long id, SubmissionRequest submissionRequest) {
        submissionRepository.findById(id)
                .orElseThrow(() -> new SubmissionNotFoundException("Submission not found with id " + id));
        Submission updatedSubmission = submissionMapper.toEntity(submissionRequest);
        updatedSubmission.setId(id);
        Submission savedSubmission = submissionRepository.save(updatedSubmission);
        return submissionMapper.toResponse(savedSubmission);
    }

    @Override
    public void delete(Long id) {
        if (!submissionRepository.existsById(id)) {
            throw new SubmissionNotFoundException("Submission not found with id " + id);
        }
        submissionRepository.deleteById(id);

    }
}
