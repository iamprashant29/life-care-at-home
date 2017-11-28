package com.angularscripts.lifecare.app.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angularscripts.lifecare.app.constants.Constants;
import com.angularscripts.lifecare.app.entity.JobCandidate;
import com.angularscripts.lifecare.app.repository.JobCandidateRepository;


@Service
public class JobCandidateService {

	@Autowired
	JobCandidateRepository jobCandidateRepository;
	
	public JobCandidate storeJobCandidateDetails(JobCandidate jobCandidate){
		return jobCandidateRepository.save(jobCandidate);
	}
	
	public String uploadResume(InputStream fileInputStream, FormDataContentDisposition file) {
		String filePath = "";
		try {  
			File pathTofFile = new File(Constants.BASE_FOLDER_PATH);
			if(!pathTofFile.exists())
				pathTofFile.mkdirs();
			filePath = Constants.BASE_FOLDER_PATH + File.separator + file.getFileName();
            FileOutputStream out = new FileOutputStream(new File(filePath));  
            int read = 0;  
            byte[] bytes = new byte[1024];  
            while ((read = fileInputStream.read(bytes)) != -1) {  
                out.write(bytes, 0, read);  
            }  
            out.flush();  
            out.close();  
        } catch (IOException e) {
        	System.out.println("Error uploading file to "+filePath);
        	e.printStackTrace();
        	return null;
        }  
		System.out.println("File successfully uploaded to "+filePath);
		return filePath;
	}
}
