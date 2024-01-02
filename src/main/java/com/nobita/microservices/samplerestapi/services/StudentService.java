package com.nobita.microservices.samplerestapi.services;

import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.nobita.microservices.samplerestapi.repository.StudentRepository;
import com.nobita.microservices.samplerestapi.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StudentService {

    private final Storage storage;
    private final StudentRepository studentRepository;

    @Value("${sm://storage-bucket-name}")
    private String bucketName;

    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudentById(int id) {
        if (getStudentById(id).isEmpty())
            return;
        studentRepository.delete(getStudentById(id).get());
    }

    public void saveFileToGC(MultipartFile file) throws IOException {
        if (file.isEmpty())
            throw new FileNotFoundException("File Not Found");
        BlobId blobId = BlobId.of(bucketName, file.getOriginalFilename());
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
        byte[] data = file.getBytes();
        storage.create(blobInfo, data);
    }
}
